package Dispositivo;

import javax.persistence.*;

@Entity(name = "DispositivoEstandar")
@Table(name = "Dispositivo_Estandar")
@DiscriminatorValue("1")
public class DispositivoEstandar extends Dispositivo{

	@Column(name="DispHsUsoEstimada")
	private double HsUsoEstimada; 
	
	public DispositivoEstandar(){
		super();
	}
	
	public DispositivoEstandar(String equipoConcreto, String nombreDispositivo, String tipoDispositivo, String bajoConsumo, double consumoKwH, double usoMensualMinHs, double usoMensualMaxHs){
		super(equipoConcreto, nombreDispositivo, "E", bajoConsumo, consumoKwH, usoMensualMaxHs, usoMensualMaxHs, "N/A");
	}

	public void convertirseAInteligente() {
		DispositivoEstandar dispositivoEstandar = this;
		DispositivoAdaptador dispositivo = new DispositivoAdaptador(dispositivoEstandar);
		System.out.println("Se ha Adaptado el siguiente dispositivo: " + dispositivo.getNombreDispositivo());
	}

	public double getHsUsoEstimada() {
		return HsUsoEstimada;
	}

	public void setHsUsoEstimada(double hsUsoEstimada) {
		HsUsoEstimada = hsUsoEstimada;
	}

	@Override
	public void setCambioEstado(String estado) {
			
	}
	
}