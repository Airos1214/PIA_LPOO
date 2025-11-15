package Practica8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a la Biblioteca!");
        BibliotecaA4647 biblioteca = new BibliotecaA4647();
        Scanner sc = new Scanner(System.in);

        try {
            biblioteca.agregarLibro(new Libro1412("Cien Años de Soledad", "Gabriel García Márquez", 1967), "Ficción");
            biblioteca.agregarLibro(new Libro1412("Don Quijote de la Mancha", "Miguel de Cervantes", 1605), "Clásicos");
            biblioteca.agregarLibro(new Libro1412("Programacion Orientada a Objetos", "Alexis Ibarra Rodríguez", 2024), "Educacion");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            }

        int opcion = 0;
        while (opcion != 10) {
            System.out.println("\nMENU DE LA BIBLIOTECA");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Buscar por autor");
            System.out.println("3. Ordenar libros por autor");
            System.out.println("4. Registrar usuario");
            System.out.println("5.Reservar libro");
            System.out.println("6.Mostrar reservas");
            System.out.println("7.Medir tiempo de ordenamiento");
            System.out.println("8. Mostrar Usuarios");
            System.out.println("9.Eliminar libros");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: \n");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        biblioteca.mostrarLibros();
                        break;
                    case 2:
                        System.out.print("Ingrese el autor a buscar: ");
                        String autor = sc.nextLine();
                        biblioteca.buscarPorAutor(autor);
                        break;
                    case 3:
                        biblioteca.ordenarPorAutor();
                        System.out.println("Libros ordenados por autor.");
                        break;
                    case 4:
                        System.out.print("Ingrese ID de usuario: ");
                        int id = sc.nextInt();
                        System.out.print("Ingrese nombre de usuario: ");
                        sc.nextLine();
                        String nombre = sc.nextLine();
                        biblioteca.registrarUsuario(id, nombre);
                        break;
                    case 5:
                        System.out.print("Ingrese el título del libro a reservar: ");
                        String titulo = sc.nextLine();
                        biblioteca.agregarReserva(titulo);
                        break;
                    case 6:
                        biblioteca.mostrarReservas();
                        break;
                    case 7:
                        biblioteca.medirTiempoOrdenamientoPorAutor();
                        break;
                    case 8:
                        biblioteca.mostrarUsuarios();
                        break;
                    case 9:
                        System.out.print("Ingrese el título del libro a eliminar: ");
                        String tituloEliminar = sc.nextLine();
                        biblioteca.eliminarLibro(tituloEliminar);
                        break;
                    case 10:
                        System.out.println("Saliendo de la biblioteca. Ahí te ves");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}
