package Server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Helper.EntityManagerHelper;
import Usuario.Cliente;
import Usuario.Usuario;

public class accesoServerBDD {

	public Boolean controlLogin(String nombreUsuario, String password) {
		EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
		EntityManager entityManager = entityManagerHelper.entityManager();		
		
		EntityTransaction transaccion = entityManager.getTransaction();
		//Usuario resultadoUsuarioQuery = entityManagerHelper.buscar(Usuario.class, new ImmutablePair<>("usuario",nombreUsuario));
		
		//Usuario resultadoUsuarioQuery  = (Usuario) entityManagerHelper.entityManager().createNativeQuery("select * from USUARIOS where usuario= '" +nombreUsuario+ "'");
		
		List<Usuario> result = (List<Usuario>) entityManagerHelper.entityManager().createNativeQuery("select u.* from USUARIOS u where usuario = " + '"' + nombreUsuario + '"' , Usuario.class).getResultList();
		
		Usuario resultado = result.get(0);
		
		if (resultado.getPassword() == password) {
			return true;			
		} else return false;
		
		//System.out.println(query);
	}
	
}
