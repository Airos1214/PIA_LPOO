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
        System.out.println(nombre + " ha sido promovido a " + nuevoCargo + " con un aumento de salario de " + aumentoSalario);
        setSalario(getSalario() + aumentoSalario);
    }

    @Override
    public void bonificar(double porcentaje) {
        double bonificacion = getSalario() * (porcentaje / 100);
        System.out.println(nombre + " ha recibido una bonificación de " + bonificacion);
        setSalario(getSalario() + bonificacion);
    }

    @Override
    public void evaluarDesempeno(int puntos) {
        System.out.println(nombre + " ha sido evaluado con " + puntos + " puntos.");
    }
}
