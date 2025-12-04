package Practica8;

public class Libro1412 implements Comparable<Libro1412> {
    private final String titulo;
    private final String autor;
    private final int anio;

    public Libro1412(String titulo, String autor, int anio) {
        if(titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
        }
        if(autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo o vacío.");
        }
        if(anio <= 0) {
            throw new IllegalArgumentException("El año debe ser un número positivo.");
        }
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public int compareTo(Libro1412 otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Año: " + anio;
    }
}
