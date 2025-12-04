package Practica7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSistemaBanco {

    @Test
    void testAgregarCuentaMatriculaInvalida() {
        SistemaBancoAI banco = new SistemaBancoAI();

        Matricula14InvalidaException ex = assertThrows(Matricula14InvalidaException.class, () -> {
            banco.agregarCuenta("123456", 500);
        });

        assertEquals("Matrícula inválida (debe terminar en 4647)", ex.getMessage());
    }

    @Test
    void testRetiroUsuarioNoExiste() {
        SistemaBancoAI banco = new SistemaBancoAI();

        Usuario4647NoEncontradoException ex = assertThrows(Usuario4647NoEncontradoException.class, () -> {
            banco.retirar("11114647", 100);
        });

        assertEquals("Usuario no encontrado", ex.getMessage());
    }

    @Test
    void testRetiroSaldoInsuficiente() throws Matricula14InvalidaException, Usuario4647NoEncontradoException {
        SistemaBancoAI banco = new SistemaBancoAI();
        banco.agregarCuenta("1234647", 500);

        Saldo12InsuficienteException ex = assertThrows(Saldo12InsuficienteException.class, () -> {
            banco.retirar("1234647", 99999);
        });

        assertEquals("Saldo insuficiente", ex.getMessage());
    }

    @Test
    void testConsultarSaldoUsuarioNoExiste() {
        SistemaBancoAI banco = new SistemaBancoAI();

        Usuario4647NoEncontradoException ex = assertThrows(Usuario4647NoEncontradoException.class, () -> {
            banco.consultarSaldo("88884647");
        });

        assertEquals("Usuario no encontrado", ex.getMessage());
    }

    @Test
    void testAgregarCuentaSaldoNegativo() {
        SistemaBancoAI banco = new SistemaBancoAI();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            banco.agregarCuenta("4564647", -9999);
        });

        assertEquals("El saldo debe ser mayor que 0", ex.getMessage());
    }

    @Test
    void testRetiroMontoNegativo() throws Matricula14InvalidaException {
        SistemaBancoAI banco = new SistemaBancoAI();
        banco.agregarCuenta("6664647", 500);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            banco.retirar("6664647", -666);
        });

        assertEquals("El monto debe ser mayor que 0", ex.getMessage());
    }
}
