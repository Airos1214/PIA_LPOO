package Practica4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMotocicletaIbarra {
    @Test
    void testConstructorValido() {
        MotocicletaIbarra moto = new MotocicletaIbarra("Suzuki", "Avenis", 2025, 2.5);
        assertEquals("Suzuki", moto.marca);
        assertEquals("Avenis", moto.modelo);
    }

    @Test
    void testConstructorGasolinaNegativa() {
        MotocicletaIbarra moto = new MotocicletaIbarra("Suzuki", "Gixxer", 2023, -1);
        assertDoesNotThrow(() -> moto.informacion());
    }

    @Test
    void testEncenderSobrescrito() {
        MotocicletaIbarra moto = new MotocicletaIbarra("Honda", "Cargo", 2024, 1.5);
        assertDoesNotThrow(() -> moto.encender());
    }

    @Test
    void testApagarSobrescrito() {
        MotocicletaIbarra moto = new MotocicletaIbarra("Honda", "Cargo", 2024, 1.5);
        assertDoesNotThrow(() -> moto.apagar());
    }
}
