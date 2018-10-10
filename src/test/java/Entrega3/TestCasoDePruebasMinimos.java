package Entrega3;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Helper.EntityManagerHelper;
import Usuario.Cliente;

public class TestCasoDePruebasMinimos {

	@Test
	public void casoPrueba1(){
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Query query = entityManager.createQuery("FROM Cliente WHERE apellido = :id");

		Cliente alejandro = new Cliente("Alekin", "123456", "Alejandro", "Mattioli", "Av. Rivadavia 5000", LocalDateTime.now(), "DNI", 38993333, 1551515555, "R1");
		dbhelper.persistirCliente(alejandro);
		
		System.out.println(alejandro.getLatitud() + " ; " + alejandro.getLongitud());
		
		query.setParameter("id", alejandro.getApellido());
		List list = query.getResultList();
		
		Cliente ale2 = (Cliente) list.get((new Long(0)).intValue());
		alejandro.setLatitud(20.59);
		alejandro.setLongitud(14.59);		
		dbhelper.modificar(alejandro);

		System.out.println(ale2.getLatitud() + " ; " + ale2.getLongitud());
		
	}
	
}