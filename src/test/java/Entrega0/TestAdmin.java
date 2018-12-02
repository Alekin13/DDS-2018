package Entrega0;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import Usuario.Administrador;

public class TestAdmin {

    @Test
    public void CantidadDeMesesComoAdmin() throws IOException, ParseException {
    	
    	Administrador alejandro = new Administrador("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 0);
    	
    	System.out.println(alejandro.getFecAlta().toString());

    	assertEquals("Cantidad de Meses Como Admin",0, alejandro.antiguedadEnMeses(alejandro.getFecAlta()));
    }

}
