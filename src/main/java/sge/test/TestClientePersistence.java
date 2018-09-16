/*package sge.test;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import sge.categoria.Categoria;
import java.util.Calendar;
import sge.usuario.Cliente;


public class TestClientePersistence {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
        transaction.begin();
        
       Cliente cliente = new Cliente("01_Gonzalo_Guini", "123456", "Gonzalo", "Guini", "Av. Rivadavia 5000", 22/04/2018, "DNI", 38993333, 1551515555, new Categoria());

       //Cliente(String usuario, String password, String nombre, String apellido, String domicilio, Calendar fechaAlta, String tipoDoc, int nroDoc, int telefono, Categoria categoria)
        
        entityManager.persist(cliente);

        transaction.commit();
	}

}

*/

// EJEMPLO
//Vehiculo nuevoVehiculo = new Vehiculo("Deconocida","Jue123");
//entityManager.persist(nuevoVehiculo);
//Robo unRobo = entityManager.find(Robo.class,new Long(1));
//unRobo.setVehiculo(nuevoVehiculo);
//entityManager.persist(unRobo);




    

        
        




 
