package Practica4;

public class MotocicletaIbarra extends VehiculoBaseA {
    private double gasolina;

    public MotocicletaIbarra(String marca, String modelo, int anio, double gasolina) {
        super(marca, modelo, anio);
        try {
            if (gasolina < 0) {
                throw new IllegalArgumentException("La gasolina no puede ser menor que 0");
            }

            this.gasolina = gasolina;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.gasolina = 0;
        }

    }

    @Override
    public void encender() {
        System.out.println("Nomanches apenas la prendí salio disparada");
    }

    @Override
    public void informacion() {
        super.informacion();
        System.out.println("La moto tenía " + gasolina + " litros cuando me la robaron");
    }

    @Override
    public void apagar() {
        super.apagar();
        System.out.println("Pues... La moto no se apaga");
    }
}
