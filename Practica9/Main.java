package Practica9;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivoTxt = "datos_2094647.txt";
        String archivoBin = "backup_1214.dat";
        String archivoCsv = "log_Ibarra.csv";
        String carpetaBackup = "backup_Ibarra4647";

        GestorArchivosIbarra4647 gestor = new GestorArchivosIbarra4647();
        PersonaASerializable persona = new PersonaASerializable("Alexis", "Ibarra", 21, "2094647");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTOR DE ARCHIVOS I/O ---");
            System.out.println("1. Escribir archivo de texto");
            System.out.println("2. Leer archivo de texto");
            System.out.println("3. Serializar objeto Persona a " + archivoBin);
            System.out.println("4. Deserializar objeto Persona desde " + archivoBin);
            System.out.println("5. Escribir en archivo binario");
            System.out.println("6. Leer en archivo binario");
            System.out.println("7. Crear Backup de todos los archivos");
            System.out.println("8. Generar log de actividades en CSV");
            System.out.println("9. Leer log de actividades desde CSV");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");

            int opcion = 0;
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("\nERROR, se debe ingresar un número entero.");
                opcion = -1;
            } finally {
                scanner.nextLine();
            }

            switch (opcion) {
                case 1:
                    System.out.println("Escribiendo el contenido para " + archivoTxt + ": ");
                    String contenido = scanner.nextLine();
                    if (contenido.isBlank()) {
                        System.err.println("\nNo se puede escribir nada en el archivo.");
                        break;
                    }
                    gestor.escribirTexto(archivoTxt, contenido);
                    break;

                case 2:
                    if (!Files.exists(Paths.get(archivoTxt))) {
                        System.err.println("\nERROR: el archivo " + archivoTxt + " no existe.");
                    }
                    System.out.println("El contenido de " + archivoTxt + " es: ");
                    System.out.println(gestor.leerTexto(archivoTxt));
                    break;

                case 3:
                    System.out.println("Serializando objeto: " + persona);
                    gestor.guardarObjeto(archivoBin, persona);
                    break;

                case 4:
                    if (!Files.exists(Paths.get(archivoBin))) {
                        System.err.println("\nERROR: el archivo " + archivoBin + " no existe.");
                        break;
                    }
                    System.out.println("Deserializando objeto desde " + archivoBin);
                    PersonaASerializable personaLeida = (PersonaASerializable) gestor.cargarObjeto(archivoBin);
                    if (personaLeida != null) {
                        System.out.println("Objeto recuperado: " + personaLeida);
                    }
                    break;

                case 5:
                    System.out.println("Escribiendo el contenido en el archivo binario");
                    String textoBinario = scanner.nextLine();
                    if (textoBinario.isBlank()) {
                        System.err.println("\nERROR: no se puede escribir nada duh.");
                        break;
                    }
                    byte[] datosBinarios = textoBinario.getBytes();
                    gestor.escribirBinario(archivoBin, datosBinarios);
                    break;

                case 6:
                    if (!Files.exists(Paths.get(archivoBin))) {
                        System.err.println("\nERROR: el archivo "+ archivoBin + " no existe.");
                        break;
                    }
                    System.out.println("Leyendo el log desde " + archivoBin + "...");
                    byte [] datosLeidos = gestor.leeBinario(archivoBin);
                    if (datosLeidos != null) {
                        String leido = new String(datosLeidos);
                        System.out.println("Contenido binario leido: \n" + leido);
                    }
                    break;

                case 7:
                    System.out.println("Creando los backups en la carpeta " + carpetaBackup + "...");
                    if (Files.exists(Paths.get(archivoTxt))) {
                        gestor.crearBackup(archivoTxt, carpetaBackup);
                    } else {
                        System.out.println("\nERROR: no se encontro el archivo");
                    }

                    if (Files.exists(Paths.get(archivoBin))) {
                        gestor.crearBackup(archivoBin, carpetaBackup);
                    } else {
                        System.out.println("\nERROR: no se encontro el archivo");
                    }

                    if (Files.exists(Paths.get(archivoCsv))) {
                        gestor.crearBackup(archivoCsv, carpetaBackup);
                    } else {
                        System.out.println("\nERROR: no se encontró el archivo");
                    }

                    System.out.println("Backup ups finalizados");
                    break;

                case 8:
                    System.out.println("Generando log de actividades en " + archivoCsv + "...");
                    List<String[]> registros = new ArrayList<>();
                    registros.add(new String[] {"2094647", "Alexis Ibarra Rodríguez", "air@gmail.com"});
                    registros.add(new String[] {"1243323", "Juan Pérez Gómez", "Juan@outlook.com"});
                    registros.add(new String[] {"9988776", "María López Sánchez", "Maria@hotmail.com"});
                    gestor.escribirCSV(archivoCsv, registros);
                    System.out.println("Log generado correctamente.");
                    break;

                case 9:
                    System.out.println("Leyendo log de actividades desde " + archivoCsv + "...");
                    List<String[]> datosCsv = gestor.leerCSV(archivoCsv);
                    if (datosCsv != null) {
                        System.out.println("Contenido del archivo CSV:");
                        for (String[] fila : datosCsv) {
                            System.out.println(String.join(", ", fila));
                        }
                    }
                    break;

                case 10:
                    salir = true;
                    System.out.println("\n1Saliendo del programa. CHAITO!");
                    break;

                default:
                    System.out.println("\nOpcion no valida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
