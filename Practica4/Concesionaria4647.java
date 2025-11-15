package Practica4;

import java.util.ArrayList;

public class Concesionaria4647 {
    private ArrayList<VehiculoBaseA> inventario = new ArrayList<>();

    public void insertarVehiculos(VehiculoBaseA vehiculo) {
        try {
            if (vehiculo == null) {
                throw new Exception("El vehiculo no puede ser nulo");
            }
            inventario.add(vehiculo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void imprimirInventario() {
        try {
            if (inventario.isEmpty()) {
                throw new Exception("El inventario esta vacio");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("INVENTARIO");
        for (VehiculoBaseA v : inventario) {
            v.informacion();
            System.out.println("****************");
        }
    }
}
