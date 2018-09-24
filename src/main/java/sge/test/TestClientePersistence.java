package sge.test;

//import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import sge.Entidades.Categoria;
import sge.usuario.Cliente;
import java.util.Calendar;


public class TestClientePersistence {
	
	public static void main(String[] args) {
/*		
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
        transaction.begin();
        
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, 2018);
        fecha.set(Calendar.MONTH, 9);
        fecha.set(Calendar.DAY_OF_MONTH, 16);
        Categoria r2 = new Categoria("R2", 35.32,  0.644);
                            //Cliente(String usu, String pass, String nom, String ape, String calle, Calendar fAlta, String TDoc, int NDoc, int tel, Categoria cat)
        Cliente cliente = new Cliente("01_Gonzalo_Guini", "123456", "Gonzalo", "Guini", "Av. Rivadavia 5000", fecha, "DNI", 38993333, 1551515555, r2);
        
        entityManager.persist(cliente);
        transaction.commit();
	}
*/
	


// EJEMPLO
//Vehiculo nuevoVehiculo = new Vehiculo("Deconocida","Jue123");
//entityManager.persist(nuevoVehiculo);
//Robo unRobo = entityManager.find(Robo.class,new Long(1));
//unRobo.setVehiculo(nuevoVehiculo);
//entityManager.persist(unRobo);

	}
}


    

        
        




 
