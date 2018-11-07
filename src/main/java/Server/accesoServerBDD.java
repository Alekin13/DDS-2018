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
		//EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
		//EntityManager entityManager = entityManagerHelper.entityManager();		
		
		//EntityTransaction transaccion = entityManager.getTransaction();
		//Usuario resultadoUsuarioQuery = entityManagerHelper.buscar(Usuario.class, new ImmutablePair<>("usuario",nombreUsuario));
		
		//Usuario resultadoUsuarioQuery  = (Usuario) entityManagerHelper.entityManager().createNativeQuery("select * from USUARIOS where usuario= '" +nombreUsuario+ "'");
		
		//List result = entityManagerHelper.entityManager().createNativeQuery("select u.* from USUARIOS u where usuario = " + '"' + nombreUsuario + '"').getResultList();
		
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Query query = entityManager.createQuery("FROM Cliente");
		//query.setParameter("nombreUsuario", nombreUsuario);
		List list = query.getResultList();
		
		
		Cliente resultado = (Cliente) list.get(0);
		
		//if (resultado.getPassword() == password) {
		if ( resultado.getPassword() == password) {
			return true;			
		} else return false;
		
		//System.out.println(query);
	}
	
}
