package Practica8;

import java.util.Comparator;

public class ComparadorPorAutor implements Comparator<Libro1412> {
    @Override
    public int compare(Libro1412 libro1, Libro1412 libro2) {
        return libro1.getAutor().compareToIgnoreCase(libro2.getAutor());
    }
}
