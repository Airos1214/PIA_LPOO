package Practica7;

import java.io.*;
import java.util.HashMap;
import java.util.logging.*;

public class SistemaBancoAI {
    private HashMap<String, Double> cuentas = new HashMap<>();
    private static Logger logger = Logger.getLogger("LogBanco");

    public SistemaBancoAI() {
        try {
            FileHandler fh = new FileHandler("Practica7/log_sistema_banco.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            System.out.println("Error al crear archivo de log: " + e.getMessage());
        }
    }

    public void agregarCuenta(String matricula, double saldo) throws Matricula14InvalidaException {
        if (matricula == null || !matricula.endsWith("4647")) {
            throw new Matricula14InvalidaException("Matrícula inválida (debe terminar en 4647)");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo debe ser mayor que 0");
        }
        cuentas.put(matricula, saldo);
        logger.info("Cuenta creada: " + matricula + " con saldo: " + saldo);
    }

    public double consultarSaldo(String matricula) throws Usuario4647NoEncontradoException {
        if (!cuentas.containsKey(matricula)) {
            throw new Usuario4647NoEncontradoException("Usuario no encontrado");
        }
        return cuentas.get(matricula);
    }

    public void retirar(String matricula, double monto) throws Usuario4647NoEncontradoException, Saldo12InsuficienteException {
        if (!cuentas.containsKey(matricula)) {
            throw new Usuario4647NoEncontradoException("Usuario no encontrado");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }

        double saldoActual = cuentas.get(matricula);

        if (monto > saldoActual) {
            throw new Saldo12InsuficienteException("Saldo insuficiente");
        }

        cuentas.put(matricula, saldoActual - monto);
        logger.info("Retiro exitoso de " + monto + " en la cuenta " + matricula);
    }

    // Aqui se usa try-with-resources
    public void guardarDatos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Practica7/cuentas_guardadas.txt"))) {
            for (String matricula : cuentas.keySet()) {
                writer.write(matricula + ": " + cuentas.get(matricula));
                writer.newLine();
            }
            logger.info("Datos guardados correctamente en archivo.");
        } catch (IOException e) {
            logger.severe("Error al guardar datos: " + e.getMessage());
        }
    }
}
