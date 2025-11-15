package Practica8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BibliotecaA4647 {
    private final ArrayList<Libro1412> libros = new ArrayList<>();
    private final LinkedList<String> reservas = new LinkedList<>();
    private final HashMap<Integer, String> usuarios = new HashMap<>();
    private final HashSet<String> categorias = new HashSet<>();

    public void agregarLibro(Libro1412 libro, String categoria) {
        try {
            if (libro == null || categoria == null || categoria.isEmpty()) {
                throw new IllegalArgumentException("El libro o la categoría no pueden ser nulos o vacíos.");
            }

            libros.add(libro);
            categorias.add(categoria);
            System.out.println("Se ha agregado el libro: " + libro.getTitulo() + " en la categoría: " + categoria);

        } catch (Exception e) {
            System.err.println("Error al agregar el libro: " + e.getMessage());
        }
    }

    public void eliminarLibro(String titulo) {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
            }

            for(int i = 0; i < titulo.length(); i++) {
                char c = titulo.charAt(i);
                if (Character.isDigit(c)) {
                    System.out.println("El título no puede contener números.");
                    return;
                }
            }

            boolean remover = libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
            if (remover) {
                System.out.println("Se ha eliminado el libro: " + titulo);
            } else {
                System.out.println("No se encontró el libro: " + titulo);
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el libro: " + e.getMessage());
        }
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        System.out.println("Libros en la biblioteca:");
        for (Libro1412 libro : libros) {
            System.out.println("- " + libro.getTitulo() + " por " + libro.getAutor() + " (" + libro.getAnio() + ")");
        }
    }

    public void registrarUsuario(int id, String nombre) {
        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El ID y el nombre no pueden ser nulos o vacíos.");
            }

            for(int i = 0; i < nombre.length(); i++) {
                char c = nombre.charAt(i);
                if (Character.isDigit(c)) {
                    System.out.println("El nombre no puede contener números.");
                    return;
                }
            }
            if (id < 0) {
                System.out.println("El ID no puede ser negativo.");
                return;
            }

            if (usuarios.containsKey(id)) {
                System.out.println("El usuario con ID " + id + " ya está registrado");
                return;
            }

            usuarios.put(id, nombre);
            System.out.println("Usuario registrado: " + nombre + " con ID: " + id);
        } catch (Exception e) {
            System.err.println("Error al registrar el usuario: " + e.getMessage());
        }
    }

    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("Usuarios registrados:");
        for (Integer id : usuarios.keySet()) {
            System.out.println("- ID: " + id + ", Nombre: " + usuarios.get(id));
        }
    }

    public void agregarReserva(String titulo) {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
            }

            for(int i = 0; i < titulo.length(); i++) {
                char c = titulo.charAt(i);
                if (Character.isDigit(c)) {
                    System.out.println("El título no puede contener números.");
                    return;
                }
            }
            if(!libros.stream().anyMatch(libro -> libro.getTitulo().equalsIgnoreCase(titulo))) {
                System.out.println("El libro con título " + titulo + " no está disponible en la biblioteca.");
                return;
            }

            reservas.addLast(titulo);
            System.out.println("Reserva agregada para el libro: " + titulo);
        } catch (Exception e) {
            System.err.println("Error al agregar la reserva: " + e.getMessage());
        }
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }
        System.out.println("Libros reservados:");
        for (String titulo : reservas) {
            System.out.println("- " + titulo);
        }
    }

    public void buscarPorAutor(String autor) {
        boolean encontrado = false;
        if (autor == null || autor.isEmpty()) {
            System.out.println("El autor no puede ser nulo o vacío.");
            return;
        }
        for(int i = 0; i < autor.length(); i++) {
            char c = autor.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println("El nombre del autor no puede contener números.");
                return;
            }
        }
        for (Libro1412 libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("Libro encontrado: " + libro.getTitulo() + " por " + libro.getAutor());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros del autor: " + autor);
        }
    }

    public void ordenarPorAutor() {
        libros.sort(new ComparadorPorAutor());
        System.out.println("Libros ordenados por autor:");
        mostrarLibros();
    }

    public void medirTiempoOrdenamientoPorAutor() {
        long inicio = System.nanoTime();
        ordenarPorAutor();
        long fin = System.nanoTime();
        long duracion = fin - inicio;
        System.out.println("Tiempo de ordenamiento por autor: " + duracion + " nanosegundos");
    }
}

