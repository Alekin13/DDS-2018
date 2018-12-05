package Server;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;

import Dispositivo.DispositivoMaestro;
import Helper.EntityManagerHelper;
import Usuario.Administrador;
import Usuario.Cliente;
import Usuario.Usuario;
import Zona.Zona;
import spark.Spark;

public class accesoServerBDD {
	// Session incoming user
	Cliente sessionUser = new Cliente();
	Administrador adminLogueado = new Administrador();
	EntityManagerHelper dbhelper = new EntityManagerHelper();
	
	public Cliente getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(Cliente sessionUser) {
		this.sessionUser = sessionUser;
	}

	public Boolean controlLogin(String nombreUsuario, String password) {
		Cliente unCliente = new Cliente();
		unCliente.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unCliente.getUsuario()));
		
		//initialize variable to maintain inside session
		sessionUser = (Cliente) user;
				
		if (sessionUser == null) {
			Spark.halt(401,"Usuario inexistente !!!");
		}
			
		if ( user.getPassword().equals(password)) {
			return true;			
		} else return false;
		
		
	}
	
	public Boolean controlLoginAdmin(String nombreUsuario, String password) {
		
		
		//EntityManagerHelper dbhelper = new EntityManagerHelper();
		Administrador unAdmin = new Administrador();
		unAdmin.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unAdmin.getUsuario()));
		
		//initialize variable to maintain inside session
		adminLogueado = (Administrador) user;
				
		
		if (adminLogueado == null) {
			Spark.halt(401,"Usuario inexistente !!!");
		}
			
		if ( user.getPassword().equals(password)) {
			return true;			
		} else return false;
	}
	
	public Date sumarRestarMeses(Date fecha, int cantmeses) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.MONTH,cantmeses);
		return calendario.getTime();
	}
	
	public List<DispositivoMaestro> obtenerDispHabilitados(){
		return dbhelper.buscarTodos(DispositivoMaestro.class);		
	}
	
	public List<Usuario> obtenerTodosLosUsuarios(){
		return dbhelper.buscarTodos(Usuario.class);		
	}
	
	public Cliente gettingUserFromDB() {
		return sessionUser;
	}
	
	public Administrador gettingAdminFromDB() {
		return adminLogueado;
	}

	public void CerrarSesionUsuario() {
		this.sessionUser = null;
	}
	
	public void CerrarSesionAmin() {
		this.adminLogueado = null;
	}
}
