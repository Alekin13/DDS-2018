package Repositorio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dispositivo.DispositivoEstandar;
import Usuario.Cliente;
import Usuario.Usuario;

public class RepositorioUsuarios{

	private static RepositorioUsuarios instance = null;
	public static RepositorioUsuarios instancia = new RepositorioUsuarios();
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
	private EntityManager entityManager;

	public RepositorioUsuarios() {
	}

	public RepositorioUsuarios(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public static RepositorioUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuarios();
		} 
			return instance;
	}

	public Usuario buscarPorUsuario(String usuario) {

		List<Usuario> users = entityManager.createQuery("SELECT u FROM Usuario u WHERE usuario = :usuario")
				.setParameter("usuario", usuario).getResultList();
		Usuario user = users.get(0);
		
		return user;
	}
	
	public Cliente buscarClientePorUsuario(String usuario) {
		
		List<Cliente> clientes = entityManager.createQuery("SELECT c FROM Cliente c WHERE usuario = :usuario", Cliente.class)
				.setParameter("nombreUsuario", usuario).getResultList();
		Cliente cliente = clientes.get(0);
		return cliente;
	}	
	
	public Cliente buscarClientePorId(int id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		return cliente;
	}
	
	public List<Cliente> listarClientes() {
		List<Cliente> lista = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
		return lista;
	}


}