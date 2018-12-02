package Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoInteligente;
import Zona.Transformador;

@Entity
@Table(name = "Cliente")
@DiscriminatorValue("1")
public class Cliente extends Usuario {

	@Column(name="TipoDocumento")
	private String tipoDocumento;
	@Column(name="NumeroDocumento")
	private int numeroDocumento;
	@Column(name="Telefono")
	private int telefono;
	@Column(name="Categoria")
	private String categoria;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="DISP_CLIENTE_ID", referencedColumnName="id")
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	@Column(name="Consumo")
	private double consumo;
	@Column(name="ConsumoxPeriodo")
	private double ConsumoxPeriodo;
	@Column(name="Puntos")
	private int puntos = 0;
	@Column(name="Latitud")
	private double latitud;
	@Column(name="Longitud")
	private double longitud;
	@ManyToOne
	@JoinColumn(name = "transformador_id", referencedColumnName = "id")
	private Transformador transformador;
	@Transient
	private double ConsumoOptimo;
	
	public enum tipoDoc { DNI, CI, LE, LC }
	
	public Cliente() {
		super();
	}

	public Cliente(String usuario, String password, String nombre, String apellido, String domicilio, LocalDateTime fechaAlta, String tipoDoc, int numDoc, int telefono, String categoria) {
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.tipoDocumento = tipoDoc;
		this.numeroDocumento = numDoc;
		this.telefono = telefono;
		this.categoria = categoria;
	}
	
	public Cliente(String usuario, String password, String nombre, String apellido, String domicilio, String fechaAlta, String tipoDoc, int numDoc, int telefono, String categoria) {
		super(usuario, password, nombre, apellido, domicilio, fechaAlta);
		this.tipoDocumento = tipoDoc;
		this.numeroDocumento = numDoc;
		this.telefono = telefono;
		this.categoria = categoria;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public double getConsumoxPeriodo() {
		return ConsumoxPeriodo;
	}

	public void setConsumoxPeriodo(double consumoxPeriodo) {
		ConsumoxPeriodo = consumoxPeriodo;
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

	public Transformador getTransformador() {
		return transformador;
	}

	public void setTransformador(Transformador transformador) {
		this.transformador = transformador;
	}
	
	public double getConsumoOptimo() {
		return ConsumoOptimo;
	}

	public void setConsumoOptimo(double consumoOptimo) {
		ConsumoOptimo = consumoOptimo;
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
		return this.dispositivos.stream().mapToDouble(d -> d.getConsumoKwH()).sum()*24;
	}

	public void agregarDispositivo(Dispositivo dispositivo){
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

	public double calcularConsumoEntrePeriodos(LocalDateTime inicio, LocalDateTime fin) {
		double consumoTotal = 0;
		for (Dispositivo dispositivo : this.dispositivos) {
			consumoTotal = consumoTotal + dispositivo.consumoTotalComprendidoEntre(inicio, fin);
		}
		return consumoTotal;
	}

	public void removerDispositivo(Dispositivo dispositivo) {
		this.dispositivos.remove(dispositivo);
	}

	public List<Dispositivo> getDispositivosInteligentes() {
		
		List<Dispositivo> di = new ArrayList<>();
		
		di = this.dispositivos.stream().filter(d -> d.getTipoDispositivo().equals(new String("I"))).collect(Collectors.toList());
		return di;

	}

}