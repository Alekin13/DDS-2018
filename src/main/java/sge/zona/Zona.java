package sge.zona;
import java.util.List;
import sge.transformador.Transformador;

public class Zona {
	
	private String nombre;
	private int id;
	private List<Transformador> transformadores;
	private double radio;
	private double latitud;
	private double longitud;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Transformador> getTransformadores() {
		return transformadores;
	}
	
	public void setTransformadores(List<Transformador> transformadores) {
		this.transformadores = transformadores;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public void agregarTransformador (Transformador transformador) {
		this.transformadores.add(transformador);
	}
	
	public Double getConsumo() {
		Double consumo = 0.0;
		for (Transformador transformador : transformadores) {
			consumo += transformador.getConsumo();
		}
		
		return consumo;
	}
}
