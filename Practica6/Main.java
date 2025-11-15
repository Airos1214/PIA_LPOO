package Practica6;

public class Main {
    public static void main(String[] args) {

        GerenteIbarra g1 = new GerenteIbarra("Lucía", 40, "Femenino", 25000, "Recursos Humanos", "Gerente General");
        DesarrolladorIbarra d1 = new DesarrolladorIbarra("Alexis", 22, "Masculino", 18000);
        VendedorIbarra v1 = new VendedorIbarra("Rafael", 28, "Masculino", 15000, 14000);

        EmpresaTIA4647 empresa = new EmpresaTIA4647();

        empresa.agregarEmpleado(g1);
        empresa.agregarEmpleado(d1);
        empresa.agregarEmpleado(v1);

        g1.trabajar();
        d1.trabajar();
        v1.trabajar();

        System.out.println();
        g1.bonificar(10);
        d1.bonificar(15);
        v1.bonificar(8);

        System.out.println();
        g1.evaluarDesempeno(95);
        d1.evaluarDesempeno(88);
        v1.evaluarDesempeno(70);

        System.out.println();
        g1.promover("Directora General", 5000);
        d1.promover("Líder Técnico", 3000);
        v1.promover("Supervisor de Ventas", 2000);

        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        empresa.mostrarEmpleados();
    }
}
