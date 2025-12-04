package Practica8;

import java.util.*;
import java.util.stream.Collectors;

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

            Iterator<Libro1412> iteracion = libros.iterator();
            boolean eliminar = false;
            while(iteracion.hasNext()) {
                Libro1412 libro = iteracion.next();
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    iteracion.remove();
                    eliminar = true;
                }
            }

            if (eliminar) {
                System.out.println("Libro eliminado:" + titulo);
            } else {
                System.out.println("No se pudo encontrar el libro:" + titulo);
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
                throw new IllegalArgumentException("El nombre no puede ser nulos o vacío.");
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

            usuarios.put(id, nombre.trim());
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
            if(libros.stream().noneMatch(libro -> libro.getTitulo().equalsIgnoreCase(titulo))) {
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
        Iterator<String> iteracion = reservas.iterator();
        while (iteracion.hasNext()) {
            System.out.println("- " + iteracion.next());
        }
    }

    public void buscarPorAutor(String autor) {
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

        List<Libro1412> busqueda = libros.stream().filter(libro ->libro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());

        if (busqueda.isEmpty()) {
            System.out.println("No se encontraron libros del autor: " + autor);
        } else {
            busqueda.forEach(libro -> System.out.println("Encontrado: " + libro));
        }

    }

    public void ordenarPorAutor() {
        libros.sort(new ComparadorPorAutor());
    }

    public void medirTiempoOrdenamientoPorAutor() {
        long inicio = System.nanoTime();
        ordenarPorAutor();
        long fin = System.nanoTime();
        System.out.println("Libros ordenados por autor");
        mostrarLibros();
        long duracion = fin - inicio;
        System.out.println("\nTiempo de ordenamiento por autor: " + duracion + " nanosegundos");
    }
}

