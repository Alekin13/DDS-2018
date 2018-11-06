package Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Helper.EntityManagerHelper;

public class accesoServerBDD {

	public void controlLogin(String nombreUsuario, String password) {
		EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
		EntityManager entityManager = entityManagerHelper.entityManager();		
//		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		
		//EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		
		EntityTransaction transaccion = entityManager.getTransaction();
		javax.persistence.Query query = entityManager.createQuery("SELECT * FROM USUARIOS WHERE usuario =:nombreUsuario");
		
		System.out.println(query);
	}
	
}
