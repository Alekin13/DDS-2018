package sge.transformador;

public class Transformador {

	private int id;
	private int zona;
	private Double latitud;
	private Double longitud;
	private Double consumo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getZona() {
		return zona;
	}
	
	public void setZona(int zona) {
		this.zona = zona;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	
}
