package sge.usuario;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import sge.categoria.Categoria;
import sge.dispositivo.Dispositivo;
import sge.dispositivo.DispositivoEstandar;
import sge.estados.Apagado;
import sge.estados.Encendido;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Cliente")
public class Cliente extends Usuario {

	@Id
	private int nroDoc; //El documento es unico y es numerico, clave candidata.
	
	private String tipoDoc;
	private int telefono;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy="Cliente")
	private List<Dispositivo> dispositivos;
	
	private double consumo;
	private int puntos;
	private double latitud; //Por ahora estan, despues ver si se calcula con una Api (Entrega Web)
	private double longitud; //Por ahora estan, despues ver si se calcula con una Api (Entrega Web)
	private int transformadorId;
	
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

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
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

	public int getTransformadorId() {
		return transformadorId;
	}

	public void setTransformadorId(int transformadorId) {
		this.transformadorId = transformadorId;
	}

	public boolean hayDispositivosEncendidos(List<Dispositivo> dispositivos) {
		if(this.cantidadDispositivosEncencidos(this.dispositivos) > 0)
			return true;
		else
			return false;
	}

	public int cantidadDispositivosEncencidos(List<Dispositivo> dispositivos) {
		List<Dispositivo> dispositivosEncendidos;
		
		dispositivosEncendidos = this.dispositivos.stream().filter(d -> d.getEstado().equals(new Encendido())).collect(Collectors.toList());
		return dispositivosEncendidos.stream().filter(d -> d.getTipoDispositivo().equals(new String("I"))).collect(Collectors.toList()).size();
	}

	public int cantidadDispositivosApagados(List<Dispositivo> dispositivos) {
		List<Dispositivo> dispositivosApagados;
		
		dispositivosApagados = this.dispositivos.stream().filter(d -> d.getEstado().equals(new Apagado())).collect(Collectors.toList());
		return dispositivosApagados.stream().filter(d -> d.getTipoDispositivo().equals(new String("I"))).collect(Collectors.toList()).size();
	}

	public int cantidadTotalDispositivos() {
		return this.dispositivos.size();
	}

	public void agregarDispositivo(Dispositivo unDispositivo) {
		//Aca hay que decodificar el nnuevo dispositivos
		// con FactoryDispositivos dispositivo = new FactoryDispositivos();
		// y crear el que corresponda 
		if (unDispositivo.esInteligente())
			this.sumarPuntosCliente(15);
		dispositivos.add(unDispositivo);
	}
	
	public void sumarPuntosCliente(int unaPuntuacion) {
		this.puntos += unaPuntuacion;
	}
	
	public void transformarDispositivoAInteligente(DispositivoEstandar unDispositivo) {
		this.sumarPuntosCliente(10);
		unDispositivo.convertirseAInteligente();
	}
	
	public double consumoCliente() {
		return this.dispositivos.stream().mapToDouble(d -> d.getConsumoKwH()).sum();
	}
	
}