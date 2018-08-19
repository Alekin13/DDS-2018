package sge.dispositivo;

public class EstandarToInteligenteAdapter extends DispositivoInteligente {

	private DispositivoEstandar dispositivoAConvertir;

	public EstandarToInteligenteAdapter(DispositivoEstandar dispositivoEstandar) {
		this.dispositivoAConvertir = dispositivoEstandar;
	}

	public EstandarToInteligenteAdapter(int idDispositivo, String nombreDispositivo, double consumoKwH,
			String tipoDispositivo, double idFabricante, double idAdaptador) {
		
		this.setIdDispositivo(idDispositivo);
		this.setNombreDispositivo(nombreDispositivo);
		this.setConsumoKwH(consumoKwH);
		this.setTipoDispositivo("A");
		this.setIdFabricante(idFabricante);
		this.setIdAdaptador(idAdaptador);
		
	}
	
	
	
	

}

