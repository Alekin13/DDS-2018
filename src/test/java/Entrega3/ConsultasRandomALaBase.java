package Entrega3;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstandar;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Usuario.Cliente;
import Usuario.Usuario;

public class ConsultasRandomALaBase {
	
	@Test
	public void casoPruebaConsulta(){
		
		EntityManager em = PerThreadEntityManagers.getEntityManager();
		String tel = "1551515555";
		int telefono = Integer.parseInt(tel);
		Query query = em.createQuery("FROM Usuario WHERE telefonoContacto = :tel");
		query.setParameter("tel", telefono);
		List list = query.getResultList();
		
		//List<Cliente> list = em.createQuery("SELECT c FROM Cliente c WHERE c.tel LIKE :tel").setParameter("tel", tel).getResultList();
		
		Cliente c = (Cliente) list.get(0);
		
		System.out.println(c.getUsuario());
	}
	
}