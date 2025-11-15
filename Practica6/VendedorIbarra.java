package Practica6;

public class VendedorIbarra extends EmpleadoAI implements Promovible4647, Bonificable14, Evaluable12 {
    private double ventasMensuales;

    public VendedorIbarra(String nombre, int edad, String genero, double salario, double ventasMensuales) {
        super(nombre, edad, genero, salario);
        if(ventasMensuales < 0){
            throw new IllegalArgumentException("Las ventas mensuales no pueden ser negativas");
        }
        this.ventasMensuales = ventasMensuales;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está vendiendo productos.");
    }

    @Override
    public void promover(String nuevoCargo, double aumentoSalario) {
        System.out.println(nombre + " ha sido promovido a " + nuevoCargo + " con un aumento de salario de " + aumentoSalario);
        setSalario(getSalario() + aumentoSalario);
    }

    @Override
    public void bonificar(double porcentaje) {
        if(ventasMensuales > 10000) {
            double bonificacion = getSalario() * (porcentaje / 100);
            System.out.println(nombre + " ha recibido una bonificación de " + bonificacion);
            setSalario(getSalario() + bonificacion);
        } else {
            System.out.println(nombre + " no califica para una bonificación");
        }

    }

    @Override
    public void evaluarDesempeno(int puntos) {
        System.out.println(nombre + " ha sido evaluado con " + puntos + " puntos.");
    }
}
