package sge.Entidades;

import java.util.List;
import sge.Entidades.Transformador;
import sge.usuario.Cliente;

public class Zona {
	
	private int id;
	private String nombre;
	private double radio;
	private double latitud;
	private double longitud;
	private List<Transformador> transformadores;
	private List<Cliente> clientes;

	public Zona(int id, String nombre, double radio, double latitud, double longitud){
		this.id = id;
		this.nombre = nombre;
		this.radio = radio;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Zona() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<Transformador> getTransformadores() {
		return transformadores;
	}

	public void setTransformadores(List<Transformador> transformadores) {
		this.transformadores = transformadores;
	}

	public List<Cliente> getClientes() {
		return getClientesDeLaZona(clientes);
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void agregarTransformador (Transformador transformador) {
		this.transformadores.add(transformador);
	}
	
	public double getConsumoTotalDeLaZona(List<Cliente> clientes) {
		double consumoTotalDeLaZona = 0;
		
		for (Transformador transformador : this.transformadores) {
			consumoTotalDeLaZona += transformador.cantidadDeEnergiaSuministrada(this.clientes);
		}
		return consumoTotalDeLaZona;
	}

	private List<Cliente> getClientesDeLaZona(List<Cliente> clientes) {
		double ZonaRadio = this.radio;

		for (Cliente unCliente : clientes) {
			if (this.calcularDistanciaCliente(unCliente) > ZonaRadio){
				clientes.remove(unCliente);
				System.out.println ("El Cliente " + unCliente.getApellido() + " no pertenece a la Zona");
			}
		}
		return clientes;
	}

	public double calcularDistanciaCliente(Cliente unCliente){
		
		double ZonaCoordenadaX = this.longitud;
		double ZonaCoordenadaY = this.latitud;
		double DistanciaCliente = Math.sqrt( Math.pow(ZonaCoordenadaX - unCliente.getLongitud(), 2) + Math.pow(ZonaCoordenadaY - unCliente.getLatitud() , 2));
		//si la distancia del cliente al centro de la Zona es MAYOR al radio de la zona, el cliente no pertence a la misma
			
		return DistanciaCliente;

	}
	
	public double calcularDistanciaTransformador(Transformador unTransformador){
		
		double ZonaCoordenadaX = this.longitud;
		double ZonaCoordenadaY = this.latitud;
		double DistanciaTransformador = Math.sqrt( Math.pow(ZonaCoordenadaX - unTransformador.getLongitud(), 2) + Math.pow(ZonaCoordenadaY - unTransformador.getLatitud() , 2));
			
		return DistanciaTransformador;

	}	
	
	public void obtenerTransformadorMasCercano(Cliente cliente) {
		double minimaDistancia = 10000;
		Transformador unTransformador = null;
		for (Transformador transformador : this.transformadores) {
			double distanciaTransformador = this.calcularDistanciaTransformador(transformador);
			if( distanciaTransformador < minimaDistancia) {
				minimaDistancia = distanciaTransformador;
				unTransformador = transformador;
			}
		}
		this.conectarCercano(cliente, unTransformador.getId());
	}

	private void conectarCercano(Cliente cliente, int idTransformador) {
		cliente.setTransformadorId(idTransformador);
		
	}
	
}
