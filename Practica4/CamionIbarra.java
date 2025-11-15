package Practica4;

public class CamionIbarra extends VehiculoBaseA{
    private double capacidad;

    public CamionIbarra(String marca, String modelo, int anio, double capacidad) {
        super(marca, modelo, anio);
        try {
            if (capacidad <= 0) {
                throw new Exception("La capacidad del camion debe ser mayor a 0");
            }

            this.capacidad = capacidad;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.capacidad = 1;
        }
    }

    @Override
    public void encender(){
        System.out.println("Siempre que el chofer enciende el camion, pita tu tu");
    }

    @Override
    public void informacion() {
        super.informacion();
        System.out.println("Al camion le caben " + capacidad + " toneladas de galletas");
    }

    @Override
    public void apagar() {
        super.apagar();
        System.out.println("El chofer apago el camion en medio de la nada y se quedo zzz");
    }
}
