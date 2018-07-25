package sge.modelos;

public class Transformadores {

	private int id;
	private float longitud;
	private float latitud;
	
	//una #Transformador pertenece a #ZonaGeografica
	private ZonaGeografica miZona;
	
	//Constructor
	public Transformadores(int Id) {
		this.id = Id;
	}
	
	//Setters & Getters
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
		
}
