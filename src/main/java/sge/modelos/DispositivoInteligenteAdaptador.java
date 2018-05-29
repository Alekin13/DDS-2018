package sge.modelos;

public class DispositivoInteligenteAdaptador extends DispositivoInteligente {

	private DispositivoEstandar dispositivoAConvertir;

	public void DispositivoInteligenteAdapter(DispositivoEstandar dispositivo, String sAdaptador ) {
		this.setDispositivoAConvertir(dispositivo);
		this.setAdaptador(sAdaptador);
		this.modoAhorroEnergia = false;
		this.setRegistrado(true);
	}
	
	public DispositivoEstandar getDispositivoAConvertir() {
		return dispositivoAConvertir;
	}

	public void setDispositivoAConvertir(DispositivoEstandar dispositivoAConvertir) {
		this.dispositivoAConvertir = dispositivoAConvertir;
	}
		
	public void setConsumo(double consumo) {
		consumo = dispositivoAConvertir.getConsumoKwh();	
	}
    
}

