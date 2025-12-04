package Practica3;

public class CuentaBancaria1412 {
    private String numeroCuenta;
    private String nombre;
    private double saldo;
    private String tipoCuenta;
    private boolean activa;

    public CuentaBancaria1412(String numeroCuenta, String nombre, double saldo, String tipoCuenta) {
        try {
            if (!numeroCuenta.endsWith("4647")) {
                throw new Exception("El número de cuenta debe terminar en 4647");
            }
            if (saldo < 0) {
                throw new Exception("El saldo inicial no puede ser negativo");
            }

            this.numeroCuenta = numeroCuenta;
            this.nombre = nombre;
            this.saldo = saldo;
            this.tipoCuenta = tipoCuenta;
            this.activa = true;

        } catch (Exception e) {
            System.out.println("Error al crear la cuenta: " + e.getMessage());
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        try {
            if (!numeroCuenta.endsWith("4647")) {
                throw new Exception("El número de cuenta es inválido (debe terminar en 4647)");
            }
            this.numeroCuenta = numeroCuenta;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setNombre(String nombre) {
        try {
            if (nombre == null) {
                throw new Exception("El nombre no puede estar nulo");
            }
            this.nombre = nombre;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setSaldo(double saldo) {
        try {
            if (saldo < 0) {
                throw new Exception("El saldo no puede ser menor que 0");
            }
            this.saldo = saldo;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setTipoCuenta(String tipoCuenta) {
        try {
            if (tipoCuenta == null) {
                throw new Exception("El tipo de cuenta no puede estar vacío");
            }
            this.tipoCuenta = tipoCuenta;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nNúmero de cuenta: " + numeroCuenta +
                "\nSaldo: " + saldo +
                "\nTipo de cuenta: " + tipoCuenta +
                "\nActiva: " + (activa ? "Sí" : "No");
    }
}

