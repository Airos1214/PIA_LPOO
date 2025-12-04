package Practica4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehiculoBaseATest {
    @Test
    void testConstructorValido() {
        VehiculoBaseA v = new VehiculoBaseA("Toyota", "Corolla", 2020);
        assertEquals("Toyota", v.marca);
        assertEquals("Corolla", v.modelo);
        assertEquals(2020, v.anio);
    }

    @Test
    void testConstructorInvalidoMarca() {
        VehiculoBaseA v = new VehiculoBaseA(null, "Corolla", 2020);
        assertEquals("Desconocida", v.marca);
    }

    @Test
    void testConstructorInvalidoModelo() {
        VehiculoBaseA v = new VehiculoBaseA("Toyota", null, 2020);
        assertEquals("Desconocido", v.modelo);
    }

    @Test
    void testConstructorInvalidoAnio() {
        VehiculoBaseA v = new VehiculoBaseA("Ford", "F150", 5000);
        assertEquals(1886, v.anio);
    }
}
