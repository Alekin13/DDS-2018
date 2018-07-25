package sge.modelos;

import java.util.List;

import sge.transformador.Transformador;

public class ZonaGeografica {
	
	private int Id;
	private String nombre;
	private float longitudCentro;
	private float latitudCentro;
	private int radio;
	
	//una #ZonaGeografica encierra uno o mas #Transformadores
	private List<Transformadores> transformadores;


}
