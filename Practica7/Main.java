package Practica7;

public class Main {
    public static void main(String[] args) {
        SistemaBancoAI banco = new SistemaBancoAI();

        try {
            banco.agregarCuenta("123647", 1000);
            banco.agregarCuenta("4647", 500);
        } catch (Matricula14InvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            banco.retirar("123647", 200);
            System.out.println("Saldo actual: " + banco.consultarSaldo("123647"));
        } catch (Usuario4647NoEncontradoException | Saldo12InsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            banco.retirar("994647", 50);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            banco.retirar("124647", 2000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        banco.guardarDatos();
    }
}
