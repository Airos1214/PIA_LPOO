package Practica7;

public class Main {
    public static void main(String[] args) {
        SistemaBancoAI banco = new SistemaBancoAI();

        try {
            banco.agregarCuenta("123647", 1000);
            banco.agregarCuenta("456", 500);
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
            banco.retirar("999647", 50); // Provoca UsuarioNoEncontradoException
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            banco.retirar("123647", 2000); // Provoca SaldoInsuficienteException
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        banco.guardarDatos();
    }
}
