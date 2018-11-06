package Server;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Helper.EntityManagerHelper;

public class accesoServerBDD {

	public void controlLogin(String nombreUsuario, String password) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
				
		javax.persistence.Query query = entityManager.createQuery("SELECT * FROM USUARIOS WHERE usuario =:nombreUsuario");
		
		System.out.println(query);
	}
	
}
