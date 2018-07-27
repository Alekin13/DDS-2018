package sge.dispositivo;


public class EstandarToInteligenteAdapter extends DispositivoInteligente {

	private DispositivoEstandar dispositivoAConvertir;
	public boolean registrado = false;
	public double KwhConsumido;
	
	
//	public void DispositivoInteligenteAdapter(DispositivoEstandar dispositivo, String sAdaptador ) {
//		this.setDispositivoAConvertir(dispositivo);
//		this.setAdaptador(sAdaptador);
//		this.setRegistrado(true);
//	}
//	
//	public DispositivoEstandar getDispositivoAConvertir() {
//		return dispositivoAConvertir;
//	}
//
//	public void setDispositivoAConvertir(DispositivoEstandar dispositivoAConvertir) {
//		this.dispositivoAConvertir = dispositivoAConvertir;
//	}
//		
//	public void setConsumo(double consumo) {
//		consumo = dispositivoAConvertir.getConsumoKwh();	
//	}
	
	public EstandarToInteligenteAdapter(DispositivoEstandar dispositivoAAdaptar) {
		this.dispositivoAConvertir = dispositivoAAdaptar;
	}
		
}

