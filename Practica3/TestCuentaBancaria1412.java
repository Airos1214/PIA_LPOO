package Practica3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestCuentaBancaria1412 {

    @Test
    public void testCrearCuenta1412() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");

        assertEquals("123456784647", cuenta.getNumeroCuenta());
        assertEquals("Alexis", cuenta.getNombre());
        assertEquals(500.0, cuenta.getSaldo());
        assertEquals("Inversiones", cuenta.getTipoCuenta());
        assertTrue(cuenta.getActiva());
    }

    @Test
    public void testNumeroCuenta() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 100.0, "Inversiones");

        cuenta.setNumeroCuenta("123459111290");
        assertNotEquals("123459111290", cuenta.getNumeroCuenta());
    }

    @Test
    public void testSaldoNoNegativos() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");

        cuenta.setSaldo(-666);
        assertEquals(500.0, cuenta.getSaldo());
    }

    @Test
    public void testSetNombreValido() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");

        cuenta.setNombre("Anastasio");
        assertEquals("Anastasio", cuenta.getNombre());
    }

    @Test
    public void testSetNombreInvalido() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");

        cuenta.setNombre(null);
        assertNotNull(cuenta.getNombre());
    }
}
