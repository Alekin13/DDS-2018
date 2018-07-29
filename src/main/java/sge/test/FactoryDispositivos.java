package sge.test;

import sge.dispositivo.DispositivoInteligente;
import sge.dispositivo.DispositivoEstandar;

public class FactoryDispositivos {

	FactoryDispositivos(){
	}
	
	public DispositivoInteligente aireAcondicionado3500(){
		return new DispositivoInteligente(24,"Aire acondicionado 3500",1.613,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente aireAcondicionado2200(){
		return new DispositivoInteligente(23,"Aire acondicionado 2200",1.013,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoEstandar tvTubo21(){
		return new DispositivoEstandar(22, "TV Tubo 21", 0.075, "E", 0, 0);
	}
	
	public DispositivoEstandar tvTubo29_34(){
		return new DispositivoEstandar(21, "TV Tubo 29 a 34", 0.175, "E", 0, 0);
	}
	
	public DispositivoEstandar tvLCD40(){
		return new DispositivoEstandar(20, "TV LCD 40", 0.18, "E", 0, 0);
	}
	
	public DispositivoInteligente tvLED24(){
		return new DispositivoInteligente(19,"TV LED 24",0.04,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente tvLED32(){
		return new DispositivoInteligente(18,"TV LED 32",0.055,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente tvLED40(){
		return new DispositivoInteligente(17,"TV LED 40",0.08,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente heladeraFreezer(){
		return new DispositivoInteligente(16,"Heladera con freezer",0.09,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente heladera(){
		return new DispositivoInteligente(15,"Heladera sin freezer",0.075,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoEstandar lavarropas5kgCalendadorDeAgua(){
		return new DispositivoEstandar(14, "Automático de 5 kg con calentamiento de agua", 0.875, "E", 0, 0);
	}
	
	public DispositivoInteligente lavarropas5k(){
		return new DispositivoInteligente(13,"Automático de 5 kg",0.175,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoEstandar lavarropasSemiAutomatico5kg(){
		return new DispositivoEstandar(12, "Semi-automático de 5 kg", 0.1275, "E", 0, 0);
	}
	
	public DispositivoEstandar ventiladorDePie(){
		return new DispositivoEstandar(11, "Ventilador de pie", 0.09, "E", 0, 0);
	}
	
	public DispositivoInteligente ventiladorDeTecho(){
		return new DispositivoInteligente(10,"Ventilador de techo",0.065,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente lamparaAlogena40w(){
		return new DispositivoInteligente(9,"Lampara Alogena de 40w",0.04,null,0, 0, null, 0, null, null);	
	}
	
	public DispositivoInteligente lamparaAlogena60w(){
		return new DispositivoInteligente(8,"Lampara Alogena de 60w",0.06,null,0, 0, null, 0, null, null);	
	}
	
	public DispositivoInteligente lamparaAlogena100w(){
		return new DispositivoInteligente(7,"Lampara Alogena de 100w",0.015,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente lamparaAlogena11w(){
		return new DispositivoInteligente(6,"Lampara Alogena de 11w",0.011,null,0, 0, null, 0, null, null);
	}
	
	public DispositivoInteligente lamparaAlogena15w(){
		return new DispositivoInteligente(5,"Lampara Alogena de 14w",0.015,null,0, 0, null, 0, null, null);	
	}
	
	public DispositivoInteligente lamparaAlogena20w(){
		return new DispositivoInteligente(4,"Lampara Alogena de 20w",0.02,null,0, 0, null, 0, null, null);	
	}
	
	public DispositivoEstandar pcDeEscritorio(){
		return new DispositivoEstandar(3, "PC de Escritorio", 0.4, "E", 0, 0);	
	}
	
	public DispositivoEstandar microondas(){
		return new DispositivoEstandar(2,"Microondas convencional",0.64, "E", 0, 0);
	}
	
	public DispositivoEstandar plancha(){
		return new DispositivoEstandar(1, "Plancha a Vapor", 0.75, "E", 0, 0);
	}
	
}



