package Practica9;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class GestorArchivosIbarra4647 {
    public void escribirTexto(String rutaArchivo, String contenido) {
        try {
            Path path = Paths.get(rutaArchivo);
            Files.writeString(path, contenido);
            System.out.println("Archivo de texto escrito correctamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("ERROR al escribir el archivo de text: " + e.getMessage());
        }
    }

    public String leerTexto(String rutaArchivo) {
        try {
            Path path = Paths.get(rutaArchivo);
            return Files.readString(path);
        } catch (IOException e) {
            System.err.println("ERROR al leer el archivo de text: " + e.getMessage());
            return null;
        }
    }

    public void escribirBinario(String rutaArchivo, byte[] datos) {
        try {
            Path path = Paths.get(rutaArchivo);
            Files.write(path, datos);
            System.out.println("Archivo binario escrito correctamente en:" + rutaArchivo);
        } catch (IOException e) {
            System.err.println("ERROR al escribir el archivo binario: " + e.getMessage());
        }
    }

    public byte[] leeBinario(String rutaArchivo) {
        try {
            Path path = Paths.get(rutaArchivo);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("ERROR al leer el archivo binario: " + e.getMessage());
            return null;
        }
    }

    public void crearDirectorio(String rutaDirectorio) {
        try {
            Path path = Paths.get(rutaDirectorio);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("Directorio creado correctamente en: " + rutaDirectorio);
            } else {
                System.out.println("El directorio ya existe en: " + rutaDirectorio);
            }
        } catch (Exception e) {
            System.err.println("ERROR al crear el directorio: " + e.getMessage());
        }
    }

    public void guardarObjeto(String rutaArchivo, Object objeto) {
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(objeto);
            System.out.println("Objeto guardado correctamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("ERROR al guardar el objeto: " + e.getMessage());
        }
    }

    public Object cargarObjeto(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object objeto = ois.readObject();
            System.out.println("Objeto cargado correctamente desde: " + rutaArchivo);
            return objeto;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERROR al cargar el objeto: " + e.getMessage());
            return null;
        }
    }

    public void escribirCSV(String rutaArchivo, List<String[]> datos) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(rutaArchivo),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            for (String[] linea : datos) {
                bw.write(String.join(",", linea));
                bw.newLine();
            }
            System.out.println("Datos CSV escritos correctamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("ERROR al escribir el archivo CSV: " + e.getMessage());
        }
    }

    public List<String[]> leerCSV(String rutaArchivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            return lineas.stream()
                    .map(linea -> linea.split(","))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("ERROR al leer el archivo CSV: " + e.getMessage());
            return null;
        }
    }

    public void crearBackup(String archivoOriginal, String carpetaBackup) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = now.format(formato);

        Path origen = Paths.get(archivoOriginal);
        Path destino = Paths.get(carpetaBackup, "Backup_" + timestamp + ".dat");

        try {
            this.crearDirectorio(carpetaBackup);
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup creado correctamente en: " + destino.toString());

        } catch (IOException e) {
            System.err.println("ERROR al crear el backup: " + e.getMessage());
        }
    }
}
