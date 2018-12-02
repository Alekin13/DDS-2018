package Server;

import org.apache.commons.lang3.tuple.ImmutablePair;
import Helper.EntityManagerHelper;
import Usuario.Administrador;
import Usuario.Cliente;
import Usuario.Usuario;
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
		
		
		//EntityManagerHelper dbhelper = new EntityManagerHelper();
		Cliente unCliente = new Cliente();
		unCliente.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unCliente.getUsuario()));
		
		//initialize variable to maintain inside session
		sessionUser = (Cliente) user;
				
		if (sessionUser == null) {
			Spark.halt(401,"Usuario inexistente !!!");
		}
			
		//System.out.println(user.getUsuario());
		//System.out.println(user.getPassword());
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
	
	public Cliente gettingUserFromDB() {

		return sessionUser;
		
		
	}
	
	public Administrador gettingAdminFromDB() {
		
		return adminLogueado;
		
		
	}
	
}
