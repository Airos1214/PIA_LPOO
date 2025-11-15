package Practica6;

public class GerenteIbarra extends EmpleadoAI implements Bonificable14, Evaluable12, Promovible4647 {
    private final String departamento;
    private String cargo;

    public GerenteIbarra(String nombre, int edad, String genero, double salario, String departamento, String cargo) {
        super(nombre, edad, genero, salario);
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo");
        }
        if (cargo == null) {
            throw new IllegalArgumentException("El cargo no puede ser nulo");
        }
        this.departamento = departamento;
        this.cargo = cargo;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " se encuentra en el departamento de " + departamento);
    }

    @Override
    public void bonificar(double porcentaje) {
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje no puede ser negativo");
        }
        double bonificacion = salario * (porcentaje / 100);
        salario += bonificacion;
        System.out.println(nombre + " ha recibido una bonificación del " + porcentaje + "%, nuevo salario: " + salario);
    }

    @Override
    public void evaluarDesempeno(int puntos) {
        System.out.println(nombre + " ha sido evaluado con " + puntos + " puntos.");
    }

    @Override
    public void promover(String nuevoCargo, double aumentoSalario) {
        if (nuevoCargo == null) {
            throw new IllegalArgumentException("El nuevo cargo no puede ser nulo");
        }
        if (aumentoSalario < 0) {
            throw new IllegalArgumentException("El aumento de salario no puede ser negativo");
        }
        this.cargo = nuevoCargo;
        this.salario += aumentoSalario;
        System.out.println(nombre + " ha sido promovido a " + nuevoCargo + " con un aumento de salario de " + aumentoSalario + ", nuevo salario: " + salario);
    }

    @Override
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("Departamento: " + departamento);
        System.out.println("Cargo: " + cargo);
    }
}
