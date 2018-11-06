package Dispositivo;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.*;

import Estado.Estado;
import Helper.EntityManagerHelper;
import SensorActuador.CommandActuadores;
import SensorActuador.Sensor;

@Entity
public class DispositivoInteligente extends Dispositivo {

		@ManyToOne
		private Sensor sensor;
		@ManyToOne
		private CommandActuadores actuador;
		@Column(name="DISP_VALOR_INHERENTE")
		private double valorInherente;

		
		public DispositivoInteligente() {
		
		}

		public DispositivoInteligente(String equipoConcreto, String nombreDispositivo, String tipoDispositivo, String bajoConsumo, double consumoKwH, double usoMensualMinHs, double usoMensualMaxHs, String estado){
			super(equipoConcreto, nombreDispositivo, "I", bajoConsumo, consumoKwH, usoMensualMinHs, usoMensualMaxHs, estado);
		}
		
		public double getValorInherente() {
			return valorInherente;
		}

		public void setValorInherente(double valorInherente) {
			this.valorInherente = valorInherente;
		}

		public Sensor getSensor() {
			return sensor;
		}

		public void setSensor(Sensor sensor) {
			this.sensor = sensor;
		}

		public CommandActuadores getActuador() {
			return actuador;
		}

		public void setActuador(CommandActuadores actuador) {
			this.actuador = actuador;
		}

		public String getNombreDispositivo() {
			return super.getNombreDispositivo();
		}

		public void setNombreDispositivo(String nombreDispositivo) {
			super.setNombreDispositivo(nombreDispositivo);
		}

		public double getConsumoKwH() {
			return super.getConsumoKwH();
		}
		
		public void setConsumoKwH(double consumoKwH) {
			super.setConsumoKwH(consumoKwH);
		}
		
		public String getTipoDispositivo() {
			return super.getTipoDispositivo();
		}
		
		public void setTipoDispositivo(String tipoDispositivo) {
			super.setTipoDispositivo(tipoDispositivo);
		}
		
		public Estado getEstado() {
			return super.getEstado();
		}

		public void setEstado(String estado) {
			super.setEstado(estado);
		}

		public String estadoDelDispositivo() {
			if(this.getEstado().estaEncendido())
				return "ENCENDIDO";
			else if(this.getEstado().estaApagado())
				return "APAGADO";
			else
				return "MODOAHORRO";
		}
		
		public boolean estaEncendido(Dispositivo unDispositivo) {
			return (this.estadoDelDispositivo()=="ENCENDIDO");
		}
		
		public boolean estaApagado(Dispositivo unDispositivo) {
			return (this.estadoDelDispositivo()=="APAGADO");
		}
		
		public double consumoUltimasNHoras(double NHoras) {
			return this.getConsumoKwH() * NHoras;
		}
		
		public double calcularConsumo(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
			return (Duration.between(fechaDesde, fechaHasta).toMinutes() * this.getConsumoKwH());
		}
		
		public void apagarDispositivo() {
			if(this.estaApagado(this))
				this.setEstado("A");
		}
		
		public void encenderDispositivo() {
			if(!this.estaEncendido(this))
				this.setEstado("E");
		}
		
		public void activaAhorroEnergia(){
			if(this.getEstado().estaEncendido())
				this.setEstado("M");
		}

		public void apagarAhorroEnergia() {
			if(this.getEstado().estaEnModoAhorro())
				this.encenderDispositivo();
		}
		
		public boolean esInteligente() {
			return true;
		}
		
		public void convertirseAInteligente(){
			System.out.println("Este dispositivo ya es Inteligente. No se puede Adaptar.");
		}

		@Override
		public void setCambioEstado(String estado) {
			EntityManagerHelper persistenciaDispositivo = new EntityManagerHelper();
			DispositivoEstado nuevoEstado = new DispositivoEstado(); 
			LocalDateTime now = LocalDateTime.now();
			String clave = super.getEstado().getClave();
			nuevoEstado.setEstadoAnterior(super.getEstado().getDescripcion());
			
			if(estado == "E") {
				this.setEstado("E");
			} else if(estado == "A") {
				this.setEstado("A");
			} else if (estado == "M") {
				this.setEstado("M");
			}
			
			nuevoEstado.setIdDispositivo(this.getId());
			nuevoEstado.setEstadoActual(this.getEstado().getDescripcion());
			nuevoEstado.setHoraDeCambioDeEstado(now);
			nuevoEstado.setConsumoEstadoPasado(this.calcularConsumo(super.getFHUltimoCambioEstado().minusHours(2),now));
							
			System.out.println(this.getEstado().getClave() + " == " + estado);
			
			if(estado != clave){
				persistenciaDispositivo.agregar(nuevoEstado);	
			}
	
		}

}