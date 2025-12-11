package daw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PanelBotonesTest {
    
    @Test
    public void testCreacionBotones() {
        PanelBotones panel = new PanelBotones();
        assertNotNull(panel.getgrupoBotones(), "El array de botones no debe ser nulo");
        assertEquals(16, panel.getgrupoBotones().length, "Debe haber 16 botones");
    }
    
    @Test
    public void testTextoBotonNumerico() {
        PanelBotones panel = new PanelBotones();
        assertEquals("0", panel.getgrupoBotones()[0].getText(), "El botón 0 debe tener texto '0'");
        assertEquals("5", panel.getgrupoBotones()[5].getText(), "El botón 5 debe tener texto '5'");
    }
    
    @Test
    public void testBotonesOperadores() {
        PanelBotones panel = new PanelBotones();
        assertEquals("+", panel.getgrupoBotones()[10].getText(), "Botón suma debe ser '+'");
        assertEquals("-", panel.getgrupoBotones()[11].getText(), "Botón resta debe ser '-'");
        assertEquals("*", panel.getgrupoBotones()[12].getText(), "Botón multiplicación debe ser '*'");
        assertEquals("/", panel.getgrupoBotones()[13].getText(), "Botón división debe ser '/'");
        assertEquals("=", panel.getgrupoBotones()[14].getText(), "Botón igual debe ser '='");
        assertEquals("C", panel.getgrupoBotones()[15].getText(), "Botón limpiar debe ser 'C'");
    }
}
