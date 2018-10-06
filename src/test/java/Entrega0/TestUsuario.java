package Entrega0;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;

import org.junit.Test;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoInteligente;
import Usuario.Cliente;

public class TestUsuario {

    @Test
    public void CantidadDispositivoEncendido() throws IOException, ParseException {
    	
    	Cliente alejandro = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
    	Dispositivo dispositivo = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "A");
    	Dispositivo dispositivo1 = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "E");
    	
    	alejandro.addDispositivo(dispositivo);
    	alejandro.addDispositivo(dispositivo1);

    	assertEquals("Dispositivos Encendidos",1, alejandro.cantidadDispositivosEncencidos(alejandro.getDispositivos()));
    }

    @Test
    public void ExisteAlgunDispositivoEncendido() throws IOException, ParseException {
    	
    	Cliente alejandro = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
    	Dispositivo dispositivo = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "A");
    	Dispositivo dispositivo1 = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "E");
    	
    	alejandro.addDispositivo(dispositivo);
    	alejandro.addDispositivo(dispositivo1);

    	assertEquals("Existen Dispositivos Encendidos", true, alejandro.hayDispositivosEncendidos(alejandro.getDispositivos()));
    }

    @Test
    public void CantidadDispositivoApagado() throws IOException, ParseException {
    	
    	Cliente alejandro = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
    	Dispositivo dispositivo = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "A");
    	Dispositivo dispositivo1 = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "E");
    	
    	alejandro.addDispositivo(dispositivo);
    	alejandro.addDispositivo(dispositivo1);

    	assertEquals("Dispositivos Encendidos",1, alejandro.cantidadDispositivosApagados(alejandro.getDispositivos()));
    }
    
    @Test
    public void CantidadDispositivos() throws IOException, ParseException {
    	
    	Cliente alejandro = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
    	Dispositivo dispositivo = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "A");
    	Dispositivo dispositivo1 = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "E");
    	
    	alejandro.addDispositivo(dispositivo);
    	alejandro.addDispositivo(dispositivo1);

    	assertEquals("Dispositivos Encendidos",2, alejandro.cantidadTotalDispositivos());
    }    
}