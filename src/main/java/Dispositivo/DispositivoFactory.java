package Dispositivo;

public class DispositivoFactory {

	public DispositivoFactory(){
	}
	
	public DispositivoInteligente aireAcondicionado3500(){
		return new DispositivoInteligente("Aire Acondicionado", "3500 Frigorias", "I", "NO", 1.613, 90, 360, "E");
	}
	
	public DispositivoInteligente aireAcondicionado2200(){
		return new DispositivoInteligente("Aire Acondicionado", "2200 Frigorias", "I", "SI", 1.013, 90, 360, "E");
	}

	public DispositivoEstandar tvTubo21(){
		return new DispositivoEstandar("Televisor", "Tubo Fluorescente de 21", "E", "NO", 0.075, 90, 360);
	}

	public DispositivoEstandar tvTubo29_34(){
		return new DispositivoEstandar("Televisor", "Tubo 29P a 34P", "E", "NO", 0.175, 90, 360);
	}

	public DispositivoEstandar tvLCD40(){
		return new DispositivoEstandar("Televisor", "LCD de 40", "E", "NO", 0.18, 90, 360);
	}

	public DispositivoInteligente tvLED24(){
		return new DispositivoInteligente("Televisor", "LED de 24", "I", "SI", 0.04, 90, 360, "E");
	}

	public DispositivoInteligente tvLED32(){
		return new DispositivoInteligente("Televisor", "LED de 32P", "I", "SI", 0.055, 90, 360, "E");
	}
	
	public DispositivoInteligente tvLED40(){
		return new DispositivoInteligente("Televisor", "LED de 40P", "I", "SI", 0.08, 90, 360, "E");
	}
	
	public DispositivoInteligente heladeraFreezer(){
		return new DispositivoInteligente("Heladera", "C/ Freezer", "I", "SI", 0.09, 720, 720, "E");
	}

	public DispositivoInteligente heladera(){
		return new DispositivoInteligente("Heladera", "S/ Freezer", "I", "SI", 0.075, 720, 720, "E");
	}
	
	public DispositivoEstandar lavarropas5kgCalendadorDeAgua(){
		return new DispositivoEstandar("Lavarropas",  "Automatico de 5kg con Calentamiento de Agua", "E", "NO", 0.875, 6, 30);
	}
	
	public DispositivoInteligente lavarropas5k(){
		return new DispositivoInteligente("Lavarropas", "Automatico de 5 kg", "I", "SI", 0.175, 6, 30, "E");
	}

	public DispositivoEstandar lavarropasSemiAutomatico5kg(){
		return new DispositivoEstandar("Lavarropas","Semi-automatico de 5 kg","E", "SI", 0.1275, 6, 30);
	}
	
	public DispositivoEstandar ventiladorDePie(){
		return new DispositivoEstandar("Ventilador","De Pie","E", "SI", 0.09, 120, 360);
	}
	
	public DispositivoInteligente ventiladorDeTecho(){
		return new DispositivoInteligente("Ventilador","De Techo","I", "SI",0.09,120, 360, "E");
	}
	
	public DispositivoInteligente lamparaAlogena40w(){
		return new DispositivoInteligente("Lampara","Halogenas de 40W","I", "NO",0.04,90, 360, "E");	
	}
	
	public DispositivoInteligente lamparaAlogena60w(){
		return new DispositivoInteligente("Lampara","Halogenas de 60W","I", "NO",0.06,90, 360, "E");	
	}
	
	public DispositivoInteligente lamparaAlogena100w(){
		return new DispositivoInteligente("Lampara","Halogenas de 100W","I", "NO",0.015,90, 360, "E");
	}

	public DispositivoInteligente lamparaAlogena11w(){
		return new DispositivoInteligente("Lampara","De 11W","I", "SI",0.011,90, 360,"E");
	}
	
	public DispositivoInteligente lamparaAlogena15w(){
		return new DispositivoInteligente("Lampara","De 15W","I", "SI",0.015,90, 360, "E");	
	}
	
	public DispositivoInteligente lamparaAlogena20w(){
		return new DispositivoInteligente("Lampara","De 20W","I", "SI",0.02,90, 360, "E");	
	}
	
	public DispositivoEstandar pcDeEscritorio(){
		return new DispositivoEstandar("PC","De escritorio","I", "SI",0.4,60, 360);	
	}
	
	public DispositivoEstandar microondas(){
		return new DispositivoEstandar("Microondas","Convencional","E", "SI",0.64,3, 15);
	}
	
	public DispositivoEstandar plancha(){
		return new DispositivoEstandar("Plancha", "A Vapor", "E", "SI", 0.75, 3, 30);
	}
	
}