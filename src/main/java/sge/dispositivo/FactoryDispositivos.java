package sge.dispositivo;

import sge.estados.Encendido;
import sge.dispositivo.DispositivoInteligente;
import sge.dispositivo.DispositivoEstandar;

public class FactoryDispositivos {

	public FactoryDispositivos(){
	}
	
	public DispositivoInteligente aireAcondicionado3500(){
		return new DispositivoInteligente(1,"Aire Acondicionado 3500", 1.613, new Encendido());
	}
	
	public DispositivoInteligente aireAcondicionado2200(){
		return new DispositivoInteligente(2,"Aire Acondicionado 2200", 1.013, new Encendido());
	}

	public DispositivoEstandar tvTubo21(){
		return new DispositivoEstandar(3, "TV Tubo 21P", 0.075);
	}
	
	public DispositivoEstandar tvTubo29_34(){
		return new DispositivoEstandar(4, "TV Tubo 29P a 34P", 0.175);
	}

	public DispositivoEstandar tvLCD40(){
		return new DispositivoEstandar(20, "TV LCD 40P", 0.18);
	}
	
	public DispositivoInteligente tvLED24(){
		return new DispositivoInteligente(19,"TV LED 24",0.04, new Encendido());
	}
	
	public DispositivoInteligente tvLED32(){
		return new DispositivoInteligente(18,"TV LED 32",0.055, new Encendido());
	}
	
	public DispositivoInteligente tvLED40(){
		return new DispositivoInteligente(17,"TV LED 40",0.08, new Encendido());
	}
	
	public DispositivoInteligente heladeraFreezer(){
		return new DispositivoInteligente(16,"Heladera con Freezer",0.09, new Encendido());
	}
	
	public DispositivoInteligente heladera(){
		return new DispositivoInteligente(15,"Heladera sin Freezer",0.075, new Encendido());
	}
	
	public DispositivoEstandar lavarropas5kgCalendadorDeAgua(){
		return new DispositivoEstandar(14, "Automatico de 5 kg con calentamiento de agua", 0.875);
	}
	
	public DispositivoInteligente lavarropas5k(){
		return new DispositivoInteligente(13,"Automatico de 5 kg",0.175, new Encendido());
	}
	
	public DispositivoEstandar lavarropasSemiAutomatico5kg(){
		return new DispositivoEstandar(12, "Semi-Automatico de 5 kg", 0.1275);
	}
	
	public DispositivoEstandar ventiladorDePie(){
		return new DispositivoEstandar(11, "Ventilador de Pie", 0.09);
	}
	
	public DispositivoInteligente ventiladorDeTecho(){
		return new DispositivoInteligente(10,"Ventilador de Techo",0.065, new Encendido());
	}
	
	public DispositivoInteligente lamparaAlogena40w(){
		return new DispositivoInteligente(9,"Lampara Alogena de 40w",0.04, new Encendido());	
	}
	
	public DispositivoInteligente lamparaAlogena60w(){
		return new DispositivoInteligente(8,"Lampara Alogena de 60w",0.06, new Encendido());	
	}
	
	public DispositivoInteligente lamparaAlogena100w(){
		return new DispositivoInteligente(7,"Lampara Alogena de 100w",0.015, new Encendido());
	}
	
	public DispositivoInteligente lamparaAlogena11w(){
		return new DispositivoInteligente(6,"Lampara Alogena de 11w",0.011, new Encendido());
	}
	
	public DispositivoInteligente lamparaAlogena15w(){
		return new DispositivoInteligente(5,"Lampara Alogena de 14w",0.015, new Encendido());	
	}
	
	public DispositivoInteligente lamparaAlogena20w(){
		return new DispositivoInteligente(4,"Lampara Alogena de 20w",0.02, new Encendido());	
	}
	
	public DispositivoEstandar pcDeEscritorio(){
		return new DispositivoEstandar(3, "PC de Escritorio", 0.4);	
	}
	
	public DispositivoEstandar microondas(){
		return new DispositivoEstandar(2,"Microondas convencional",0.64);
	}
	
	public DispositivoEstandar plancha(){
		return new DispositivoEstandar(1, "Plancha a Vapor", 0.75);
	}

}