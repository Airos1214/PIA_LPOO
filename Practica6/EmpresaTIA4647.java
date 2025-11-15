package Practica6;

import java.util.ArrayList;

public class EmpresaTIA4647 {
    private ArrayList<EmpleadoAI> empleados = new ArrayList<>();

    public void agregarEmpleado(EmpleadoAI empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (EmpleadoAI empleado : empleados) {
            empleado.imprimirInfo();
            System.out.println("*******************************");
        }
    }
}
