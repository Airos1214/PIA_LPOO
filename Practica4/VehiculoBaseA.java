package Practica4;

public class VehiculoBaseA {
    protected  String marca;
    protected  String modelo;
    protected  int anio;

    public VehiculoBaseA(String marca, String modelo, int anio) {
        try {
            if (marca == null) {
                throw new IllegalArgumentException("La marca no puede estar vacía");
            }
            if (modelo == null) {
                throw new IllegalArgumentException("El modelo no puede estar vacío");
            }
            if (anio < 1886 || anio > 2025) {
                throw new IllegalArgumentException("El año no puede ser menor que 1886 ni mayor que 2025");
            }

            this.marca = marca;
            this.modelo = modelo;
            this.anio = anio;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.marca = "Desconocida";
            this.modelo = "Desconocido";
            this.anio = 1886;
        }
    }

    public void encender() {
        System.out.println("El carro se esta encendiendo...");
    }

    public void informacion() {
        System.out.println("Marca: " + marca + ", " + " Modelo: " + modelo + ", " + " Año: " + anio);
    }

    public void apagar() {
        System.out.println("El carro se esta apagando...");
    }
}

