package Server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Helper.EntityManagerHelper;
import Usuario.Administrador;
import Usuario.Cliente;
import Usuario.Usuario;

public class accesoServerBDD {
	// Session incoming user
	Cliente sessionUser = new Cliente();
	Administrador adminLogueado = new Administrador();
	
	public Cliente getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(Cliente sessionUser) {
		this.sessionUser = sessionUser;
	}

	public Boolean controlLogin(String nombreUsuario, String password) {
		
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		Cliente unCliente = new Cliente();
		unCliente.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unCliente.getUsuario()));
		
		//initialize variable to maintain inside session
		sessionUser = (Cliente) user;
				
		//System.out.println(user.getUsuario());
		//System.out.println(user.getPassword());
		if ( user.getPassword().equals(password)) {
			return true;			
		} else return false;
		
		
	}
	
	public Boolean controlLoginAdmin(String nombreUsuario, String password) {
		
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		Administrador unAdmin = new Administrador();
		unAdmin.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unAdmin.getUsuario()));
		
		//initialize variable to maintain inside session
		adminLogueado = (Administrador) user;
				
		if ( user.getPassword().equals(password)) {
			return true;			
		} else return false;
		
		
	}
	
	public Cliente gettingUserFromDB(String nombreUsuario) {
		
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		Cliente unCliente = new Cliente();
		unCliente.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unCliente.getUsuario()));
		return (Cliente) user;
		
		
	}
	
	public Administrador gettingAdminFromDB(String nombreUsuario) {
		
		
//		EntityManagerHelper dbhelper = new EntityManagerHelper();
//		Administrador admin = new Administrador();
//		admin.setUsuario(nombreUsuario);
//		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",admin.getUsuario()));
//		return (Cliente) user;
		
		return adminLogueado;
		
		
	}
	
}
