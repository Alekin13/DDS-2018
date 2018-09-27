package sge.dispositivo;

public class EstandarToInteligenteAdapter extends DispositivoInteligente {

	public EstandarToInteligenteAdapter(Long idDispositivo, String nombreDispositivo, double consumoKwH,
			String tipoDispositivo) {
		
		this.setIdDispositivo(idDispositivo);
		this.setNombreDispositivo(nombreDispositivo);
		this.setConsumoKwH(consumoKwH);
		this.setTipoDispositivo("A");
		
		this.encenderDispositivo();
		
	}

}

