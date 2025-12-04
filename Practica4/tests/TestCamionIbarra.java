package Practica4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCamionIbarra {
    @Test
    void testConstructorValido() {
        CamionIbarra camion = new CamionIbarra("Volvo", "FH", 2023, 10);
        assertEquals("Volvo", camion.marca);
        assertEquals("FH", camion.modelo);
    }

    @Test
    void testConstructorCapacidadInvalida() {
        CamionIbarra camion = new CamionIbarra("Volvo", "FM", 2023, -5);
        assertDoesNotThrow(() -> camion.informacion());
    }

    @Test
    void testEncenderSobrescrito() {
        CamionIbarra camion = new CamionIbarra("Isuzu", "Forward", 2024, 12);
        assertDoesNotThrow(() -> camion.encender());
    }

    @Test
    void testApagarSobrescrito() {
        CamionIbarra camion = new CamionIbarra("Isuzu", "Forward", 2024, 12);
        assertDoesNotThrow(() -> camion.apagar());
    }
}
