package sge.usuario;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import sge.categoria.Categoria;
import sge.dispositivo.Dispositivo;
import sge.estados.Encendido;

public class Cliente extends Usuario {

	private String tipoDoc;
	private int nroDoc;
	private int telefono;
	private Categoria categoria;
	private List<Dispositivo> dispositivos;
	private Float consumo;

	public Cliente() {
		super();
	}
	
	public Cliente(String usuario, String password, String nombre, String apellido, String domicilio,
			Calendar fechaAlta, String tipoDoc, int nroDoc, int telefono, Categoria categoria) {
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.telefono = telefono;
		this.categoria = categoria;
	}
	
	public enum tipoDoc { DNI, CI, LE, LC }

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public int getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}	

	public Float getConsumo() {
		return consumo;
	}

	public void setConsumo(Float consumo) {
		this.consumo = consumo;
	}

	public boolean hayDispositivosEncendidos(List<Dispositivo> dispositivos) {
		if(this.cantidadDispositivosEncencidos(this.dispositivos) > 0)
			return true;
		else
			return false;
	}

	public int cantidadDispositivosEncencidos(List<Dispositivo> dispositivos) {
		return this.dispositivos.stream().filter(unDispositivo -> unDispositivo.getClass().equals(new Encendido())).collect(Collectors.toList()).size();
	}

	public int cantidadDispositivosApagados(List<Dispositivo> dispositivos) {
		int dispositivosApagados = 0;
		dispositivosApagados = this.cantidadTotalDispositivos() - cantidadDispositivosEncencidos(dispositivos);
		return dispositivosApagados;
	}

	public int cantidadTotalDispositivos() {
		return this.dispositivos.size();
	}


	
	

	
	
	
	
	
	
	
	
	
	//no chequeado
	
	private int puntaje;
	private double latitud;
	private double longitud;
	private int transformadorId;
	//Tengo duda en que si se da de alta empieza en R1 o ya viene con la categoria
		
		


	public Cliente(String valorUsuario, String valorPassword, String valorNombre, String valorApellido, String valorDomicilio,
			Calendar valorFechaAlta, String valorTipoDoc, int valorNroDoc, int valorTelefono, Categoria valorCategoria,
			List<Dispositivo> valorDispositivos, int valorPuntaje ,Float valorConsumoMensual, double valorLatitud, double valorLongitud) {

		super(valorUsuario, valorPassword, valorNombre, valorApellido, valorDomicilio, valorFechaAlta);
		this.tipoDoc = valorTipoDoc;
		this.nroDoc = valorNroDoc;
		this.telefono = valorTelefono;
		this.categoria = valorCategoria;
		this.dispositivos = valorDispositivos;
		this.puntaje = valorPuntaje;
		this.consumo = valorConsumoMensual;
		this.latitud = valorLatitud;
		this.longitud = valorLongitud;

	}

	
		
	
	
	
	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}




	
	
//	public void categoria( String categoria, double cargoFijo, double cargoVariable  ) {
//		this.categoria = new Categoria();
//		this.categoria.setearCategoria( categoria, cargoFijo, cargoVariable);
//	}
	

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

	public double consumoCliente() {
		return this.dispositivos.stream().mapToDouble(d -> d.getConsumoKwH()).sum();
	}
	
	public void agregarDispositivo(Dispositivo unDispositivo) {
		if (unDispositivo.esInteligente()) { puntuarUsuario(15); }
		dispositivos.add(unDispositivo);
	}
	
	public void puntuarUsuario(int unaPuntuacion) {
		this.puntaje = this.puntaje + unaPuntuacion;
	}
	
	public void transformarDispositivoAInteligente(Dispositivo unDispositivo) {
		puntuarUsuario(10);
		unDispositivo.convertirseAInteligente();
	}

	public Object consumoMensual() {
	
		return null;
	}

	public int getTransformadorId() {
		return transformadorId;
	}

	public void setTransformadorId(int transformadorId) {
		this.transformadorId = transformadorId;
	}
	
}