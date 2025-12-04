package Practica6;

public class DesarrolladorIbarra extends EmpleadoAI implements Promovible4647, Bonificable14, Evaluable12 {
    public DesarrolladorIbarra(String nombre, int edad, String genero, double salario) {
        super(nombre, edad, genero, salario);
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está desarrollando código.");
    }

    @Override
    public void promover(String nuevoCargo, double aumentoSalario) {
        if (nuevoCargo == null) {
            throw new IllegalArgumentException("El nuevo cargo no puede ser nulo");
        }

        if (aumentoSalario < 0) {
            throw new IllegalArgumentException("El aumento de salario no puede ser negativo");
        }

        setSalario(getSalario() + aumentoSalario);
        System.out.println(nombre + " ha sido promovido a " + nuevoCargo + " con un aumento de salario de " + aumentoSalario
        + ", el nuevo salario es: " + getSalario());

    }

    @Override
    public void bonificar(double porcentaje) {
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje no puede ser negativo");
        }

        double bonificacion = getSalario() * (porcentaje / 100);
        setSalario(getSalario() + bonificacion);
        System.out.println(nombre + " ha recibido una bonificación de " + bonificacion);
    }

    @Override
    public void evaluarDesempeno(int puntos) {
        System.out.println(nombre + " ha sido evaluado con " + puntos + " puntos.");
    }
}
