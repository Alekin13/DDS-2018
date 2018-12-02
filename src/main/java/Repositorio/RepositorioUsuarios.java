package Repositorio;

import java.util.List;
import javax.persistence.EntityManager;
import Usuario.Cliente;
import Usuario.Usuario;

public class RepositorioUsuarios{

	private EntityManager entityManager;

	public RepositorioUsuarios(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Usuario buscarPorUsuario(String usuario) {
		Usuario user = (Usuario) entityManager.createQuery("SELECT u FROM Usuario u WHERE usuario = :usuario")
				.setParameter("usuario", usuario).getSingleResult();
		return user;
	}
	
	public Cliente buscarClientePorUsuario(String usuario) {
		Cliente cliente = entityManager.createQuery("SELECT c FROM Cliente c WHERE usuario = :usuario", Cliente.class)
				.setParameter("nombreUsuario", usuario).getSingleResult();
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