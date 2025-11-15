package Practica4;

public class Main {
    public static void main(String[] args) {
        VehiculoBaseA auto = new AutoIbarra("Tesla", "Cybertruck", 2024, 4);
        VehiculoBaseA moto = new MotocicletaIbarra("Suzuki", "Avenis 125", 2025, 2.5);
        VehiculoBaseA camion = new CamionIbarra("Isuzu", "Forward 1400", 2025, 12);

        Concesionaria4647 concesionaria = new Concesionaria4647();
        concesionaria.insertarVehiculos(auto);
        concesionaria.insertarVehiculos(moto);
        concesionaria.insertarVehiculos(camion);

        System.out.println("POLIMORFISMO");
        VehiculoBaseA[] vehiculos = {auto, moto, camion};
        for (VehiculoBaseA v : vehiculos) {
            v.encender();
            v.apagar();
            v.informacion();
            System.out.println();
        }
        concesionaria.imprimirInventario();
    }
}
