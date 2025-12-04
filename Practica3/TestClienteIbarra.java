package Practica3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestClienteIbarra {

    @Test
    public void testCrearClienteValido() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");
        ClienteIbarra cliente = new ClienteIbarra("Alexis", "Ibarra", 19, "alexis@email.com", cuenta);

        assertEquals("Alexis", cliente.nombre);
        assertEquals("Ibarra", cliente.apellido);
        assertEquals(19, cliente.getEdad());
        assertEquals(cuenta, cliente.getCuenta());
    }

    @Test
    public void testClienteMenorDeEdad() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");

        assertThrows(IllegalArgumentException.class, () -> {
            new ClienteIbarra("Alexis", "Ibarra", 16, "test@test.com", cuenta);
        });
    }

    @Test
    public void testCorreoInvalid() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");

        assertThrows(IllegalArgumentException.class, () -> {
            new ClienteIbarra("Alexis", "Ibarra", 25, "correo-sin-arroba", cuenta);
        });
    }

    @Test
    public void testCuentaNotNull() {
        assertThrows(NullPointerException.class, () -> {
            new ClienteIbarra("Alexis", "Ibarra", 25, "correo@email.com", null);
        });
    }

    @Test
    public void testAgregarEdadValida() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");
        ClienteIbarra cliente = new ClienteIbarra("Alexis", "Ibarra", 19, "alexis@email.com", cuenta);

        cliente.agregarEdad(25);
        assertEquals(25, cliente.getEdad());
    }

    @Test
    public void testAgregarEdadInvalida() {
        CuentaBancaria1412 cuenta = new CuentaBancaria1412("123456784647", "Alexis", 500.0, "Inversiones");
        ClienteIbarra cliente = new ClienteIbarra("Alexis", "Ibarra", 19, "alexis@email.com", cuenta);

        cliente.agregarEdad(10);
        assertNotEquals(10, cliente.getEdad());
    }
}
