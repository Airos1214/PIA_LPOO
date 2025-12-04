package Practica4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAutoIbarra {
    @Test
    void testConstructorValido() {
        AutoIbarra auto = new AutoIbarra("Tesla", "Cybertruck", 2024, 4);
        assertEquals("Tesla", auto.marca);
        assertEquals("Cybertruck", auto.modelo);
    }

    @Test
    void testConstructorLlantasInvalidas() {
        AutoIbarra auto = new AutoIbarra("Tesla", "Model S", 2023, 2);
        assertDoesNotThrow(() -> auto.informacion());
    }

    @Test
    void testEncenderSobrescrito() {
        AutoIbarra auto = new AutoIbarra("Audi", "A4", 2020, 4);
        assertDoesNotThrow(() -> auto.encender());
    }

    @Test
    void testApagarSobrescrito() {
        AutoIbarra auto = new AutoIbarra("Audi", "A4", 2020, 4);
        assertDoesNotThrow(() -> auto.apagar());
    }
}
