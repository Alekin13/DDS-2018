package Server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Helper.EntityManagerHelper;
import Usuario.Cliente;
import Usuario.Usuario;

public class accesoServerBDD {

	public Boolean controlLogin(String nombreUsuario, String password) {
		
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		Cliente unCliente = new Cliente();
		unCliente.setUsuario(nombreUsuario);
		Usuario user = dbhelper.buscar(Usuario.class, new ImmutablePair<>("usuario",unCliente.getUsuario()));
		System.out.println(user.getUsuario());
		System.out.println(user.getPassword());
		if ( user.getPassword().equals(password)) {
			return true;			
		} else return false;
		
		
	}
	
}
