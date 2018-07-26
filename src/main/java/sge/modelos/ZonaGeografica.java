package sge.modelos;

import java.util.List;

import sge.transformador.Transformador;

public class ZonaGeografica {
	
	private int id;
	private String nombre;
	private float longitudCentro;
	private float latitudCentro;
	private int radio;
	
	//una #ZonaGeografica encierra uno o mas #Transformadores
	private List<Transformadores> transformadores;

	//Constructor
	public ZonaGeografica(int Id) {
		this.id = Id;
	}
	
	//Setters & Getters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLongitudCentro(float longitudCentro) {
		this.longitudCentro = longitudCentro;
	}
	
	public void setLatitudCentro(float latitudCentro) {
		this.latitudCentro = latitudCentro;
	}
	
	public void setRadio(int radio) {
		this.radio = radio;
	}
}
