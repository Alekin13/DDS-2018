package Dispositivo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "DispositivoMaestro")
@Table(name = "DispositivoMaestro")
public class DispositivoMaestro {
		
		@Id
		@GeneratedValue
		@Column(name="idMaestro")
		private int id;
		@Column(name="equipoConcreto")
		private String equipoConcreto;
		@Column(name="nombreDispositivo")
		private String nombreDispositivo;
		@Column(name="tipoDispositivo")
		private String tipoDispositivo;
		@Column(name="bajoConsumo")
		private String bajoConsumo;
		@Column(name="consumoKwH")
		private double consumoKwH;
		@Column(name="usoMensualMinHs")
		private double usoMensualMinHs;
		@Column(name="usoMensualMaxHs")
		private double usoMensualMaxHs;	
		
		public DispositivoMaestro(){
			
		}

		public DispositivoMaestro(String equipoConcreto, String nombreDispositivo, String tipoDispositivo, String bajoConsumo, double consumoKwH, double usoMensualMinHs, double usoMensualMaxHs){
			this.setEquipoConcreto(equipoConcreto);
			this.setNombreDispositivo(nombreDispositivo);
			this.setTipoDispositivo(tipoDispositivo);
			this.setBajoConsumo(bajoConsumo);
			this.setConsumoKwH(consumoKwH);
			this.setUsoMensualMaxHs(usoMensualMaxHs);
			this.setUsoMensualMinHs(usoMensualMinHs);
		};

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEquipoConcreto() {
			return equipoConcreto;
		}

		public void setEquipoConcreto(String equipoConcreto) {
			this.equipoConcreto = equipoConcreto;
		}

		public String getNombreDispositivo() {
			return nombreDispositivo;
		}

		public void setNombreDispositivo(String nombreDispositivo) {
			this.nombreDispositivo = nombreDispositivo;
		}

		public String getTipoDispositivo() {
			return tipoDispositivo;
		}

		public void setTipoDispositivo(String tipoDispositivo) {
			this.tipoDispositivo = tipoDispositivo;
		}

		public String getBajoConsumo() {
			return bajoConsumo;
		}

		public void setBajoConsumo(String bajoConsumo) {
			this.bajoConsumo = bajoConsumo;
		}

		public double getConsumoKwH() {
			return consumoKwH;
		}

		public void setConsumoKwH(double consumoKwH) {
			this.consumoKwH = consumoKwH;
		}

		public double getUsoMensualMinHs() {
			return usoMensualMinHs;
		}

		public void setUsoMensualMinHs(double usoMensualMinHs) {
			this.usoMensualMinHs = usoMensualMinHs;
		}

		public double getUsoMensualMaxHs() {
			return usoMensualMaxHs;
		}

		public void setUsoMensualMaxHs(double usoMensualMaxHs) {
			this.usoMensualMaxHs = usoMensualMaxHs;
		}
		
		public DispositivoMaestro aireAcondicionado3500(){
			return new DispositivoMaestro("Aire Acondicionado", "3500 Frigorias", "I", "NO", 1.613, 90, 360);
		}
		
		public DispositivoMaestro aireAcondicionado2200(){
			return new DispositivoMaestro("Aire Acondicionado", "2200 Frigorias", "I", "SI", 1.013, 90, 360);
		}

		public DispositivoMaestro tvTubo21(){
			return new DispositivoMaestro("Televisor", "Tubo Fluorescente de 21", "E", "NO", 0.075, 90, 360);
		}

		public DispositivoMaestro tvTubo29_34(){
			return new DispositivoMaestro("Televisor", "Tubo 29P a 34P", "E", "NO", 0.175, 90, 360);
		}

		public DispositivoMaestro tvLCD40(){
			return new DispositivoMaestro("Televisor", "LCD de 40", "E", "NO", 0.18, 90, 360);
		}

		public DispositivoMaestro tvLED24(){
			return new DispositivoMaestro("Televisor", "LED de 24", "I", "SI", 0.04, 90, 360);
		}

		public DispositivoMaestro tvLED32(){
			return new DispositivoMaestro("Televisor", "LED de 32P", "I", "SI", 0.055, 90, 360);
		}
		
		public DispositivoMaestro tvLED40(){
			return new DispositivoMaestro("Televisor", "LED de 40P", "I", "SI", 0.08, 90, 360);
		}
		
		public DispositivoMaestro heladeraFreezer(){
			return new DispositivoMaestro("Heladera", "C/ Freezer", "I", "SI", 0.09, 720, 720);
		}

		public DispositivoMaestro heladera(){
			return new DispositivoMaestro("Heladera", "S/ Freezer", "I", "SI", 0.075, 720, 720);
		}
		
		public DispositivoMaestro lavarropas5kgCalendadorDeAgua(){
			return new DispositivoMaestro("Lavarropas",  "Automatico de 5kg con Calentamiento de Agua", "E", "NO", 0.875, 6, 30);
		}
		
		public DispositivoMaestro lavarropas5k(){
			return new DispositivoMaestro("Lavarropas", "Automatico de 5 kg", "I", "SI", 0.175, 6, 30);
		}

		public DispositivoMaestro lavarropasSemiAutomatico5kg(){
			return new DispositivoMaestro("Lavarropas","Semi-automatico de 5 kg","E", "SI", 0.1275, 6, 30);
		}
		
		public DispositivoMaestro ventiladorDePie(){
			return new DispositivoMaestro("Ventilador","De Pie","E", "SI", 0.09, 120, 360);
		}
		
		public DispositivoMaestro ventiladorDeTecho(){
			return new DispositivoMaestro("Ventilador","De Techo","I", "SI",0.09,120, 360);
		}
		
		public DispositivoMaestro lamparaAlogena40w(){
			return new DispositivoMaestro("Lampara","Halogenas de 40W","I", "NO",0.04,90, 360);	
		}
		
		public DispositivoMaestro lamparaAlogena60w(){
			return new DispositivoMaestro("Lampara","Halogenas de 60W","I", "NO",0.06,90, 360);	
		}
		
		public DispositivoMaestro lamparaAlogena100w(){
			return new DispositivoMaestro("Lampara","Halogenas de 100W","I", "NO",0.015,90, 360);
		}

		public DispositivoMaestro lamparaAlogena11w(){
			return new DispositivoMaestro("Lampara","De 11W","I", "SI",0.011,90, 360);
		}
		
		public DispositivoMaestro lamparaAlogena15w(){
			return new DispositivoMaestro("Lampara","De 15W","I", "SI",0.015,90, 360);	
		}
		
		public DispositivoMaestro lamparaAlogena20w(){
			return new DispositivoMaestro("Lampara","De 20W","I", "SI",0.02,90, 360);	
		}
		
		public DispositivoMaestro pcDeEscritorio(){
			return new DispositivoMaestro("PC","De escritorio","I", "SI",0.4,60, 360);	
		}
		
		public DispositivoMaestro microondas(){
			return new DispositivoMaestro("Microondas","Convencional","E", "SI",0.64,3, 15);
		}
		
		public DispositivoMaestro plancha(){
			return new DispositivoMaestro("Plancha", "A Vapor", "E", "SI", 0.75, 3, 30);
		}

}
