package Practica4;

public class AutoIbarra extends VehiculoBaseA {
    private int llantas;

    public AutoIbarra(String marca, String modelo, int anio, int llantas) {
        super(marca, modelo, anio);
        try {
            if (llantas < 4) {
                throw new Exception("Un carro debe tener al menos 4 llantas");
            }

            this.llantas = llantas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.llantas = 4;
        }
    }

    @Override
    public void encender() {
        super.encender();
        System.out.println("No se si vaya a prender el carro");
    }

    @Override
    public void informacion() {
        super.informacion();
        System.out.println("El carro tiene: " + llantas + " llantas");
    }

    @Override
    public void apagar() {
        super.apagar();
        System.out.println("Se me apago el carro");
    }
}


