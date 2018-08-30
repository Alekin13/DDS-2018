package sge.dispositivo;

public class EstandarToInteligenteAdapter extends DispositivoInteligente {

	public EstandarToInteligenteAdapter(int idDispositivo, String nombreDispositivo, double consumoKwH,
			String tipoDispositivo) {
		
		this.setIdDispositivo(idDispositivo);
		this.setNombreDispositivo(nombreDispositivo);
		this.setConsumoKwH(consumoKwH);
		this.setTipoDispositivo("A");
		this.setIdAdaptador(idDispositivo);
		
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

