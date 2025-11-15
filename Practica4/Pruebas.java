package Practica4;

public class Pruebas {
    public static void main(String[] args) {
        VehiculoBaseA auto = new AutoIbarra("Tesla", "Cybertruck", 2024, 4);
        VehiculoBaseA moto = new MotocicletaIbarra("Suzuki", "Avenis 125", 2025, 2.5);
        VehiculoBaseA camion = new CamionIbarra("Isuzu", "Forward 1400", 2025, 12);

        System.out.println("Pruebas del carro");
        auto.encender();
        auto.apagar();
        auto.informacion();

        System.out.println("\nPruebas de la moto");
        moto.encender();
        moto.apagar();
        moto.informacion();

        System.out.println("\nPruebas del camion");
        camion.encender();
        camion.apagar();
        camion.informacion();
    }
}
