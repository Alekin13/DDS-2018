package Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.*;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstandar;

@Entity
@DiscriminatorValue("CLIENTES")
public class Cliente extends Usuario {

	@OneToOne
	@JoinColumn(name="id")
	private Usuario usuario;
	@Column(name="tipoDocumento")
	private String tipoDoc;
	@Column(name="numeroDocumento")
	private int nroDoc;
	@Column(name="telefonoContacto")
	private int telefono;
	@Column(name="categoria")
	private String categoria;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="ClienteDispositivo", referencedColumnName="id") // Clave Foranea
	private List<Dispositivo> dispositivos = new ArrayList<>();
	@Column(name="consumo")
	private double consumo;
	@Column(name="puntos")
	private int puntos;
	@Column(name="latitud")
	private double latitud;
	@Column(name="longitud")
	private double longitud;
	@Column(name="idTransformador")
	private int idTransformador;
	
	public Cliente(String usuario, String password, String nombre, String apellido, String domicilio, LocalDateTime fechaAlta, String tipoDoc, int unNumDoc, int telefono, String categoria) {
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.tipoDoc = tipoDoc;
		this.nroDoc = unNumDoc;
		this.telefono = telefono;
		this.categoria = categoria;
	}
	
	public Cliente() {
	
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}	

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public boolean hayDispositivosEncendidos(List<Dispositivo> dispositivos) {
		if(this.cantidadDispositivosEncencidos(this.dispositivos) > 0)
			return true;
		else
			return false;
	}

	public int cantidadDispositivosEncencidos(List<Dispositivo> dispositivos) {
		List<Dispositivo> dispositivosEncendidos;
		
		dispositivosEncendidos = this.dispositivos.stream().filter(d -> d.getEstado().estaEncendido()).collect(Collectors.toList());
		return dispositivosEncendidos.stream().filter(d -> d.getTipoDispositivo().equals(new String("I"))).collect(Collectors.toList()).size();
	}

	public int cantidadDispositivosApagados(List<Dispositivo> dispositivos) {
		List<Dispositivo> dispositivosApagados;
		
		dispositivosApagados = this.dispositivos.stream().filter(d -> d.getEstado().estaApagado()).collect(Collectors.toList());
		return dispositivosApagados.stream().filter(d -> d.getTipoDispositivo().equals(new String("I"))).collect(Collectors.toList()).size();
	}

	public int cantidadTotalDispositivos() {
		return this.dispositivos.size();
	}

	public double consumoCliente() {
		return this.dispositivos.stream().mapToDouble(d -> d.getConsumoKwH()).sum();
	}
	
	public void addDispositivo(Dispositivo dispositivo){
		this.dispositivos.add(dispositivo);
		if(dispositivo.esInteligente())
			sumarPuntos(15);
	}
	
	
	public void adaptarDispositivo(DispositivoEstandar dispositivo){
		dispositivo.convertirseAInteligente();
		sumarPuntos(10);
	}
	
	private void sumarPuntos(int puntos) {
		this.setPuntos(puntos);		
	}

	public void hsUsoEstimadaDispositivoEstandar(DispositivoEstandar dispositivo, double hsUsoEstimada){
		dispositivo.setHsUsoEstimada(hsUsoEstimada);
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos += puntos;
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

	public int getIdTransformador() {
		return idTransformador;
	}

	public void setIdTransformador(int idTransformador) {
		this.idTransformador = idTransformador;
	}
	
}