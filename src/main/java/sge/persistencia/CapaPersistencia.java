package sge.persistencia;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import sge.persistencia.HibernateUtils;
import sge.usuario.Cliente;
import sge.Entidades.Categoria;
import sge.mappers.JsonHelper;

public class CapaPersistencia {

	public void cargarUsuarioFromJson(String path) throws ParseException{
		
		List<Cliente> clientes = new ArrayList<Cliente>();
    	
		try {
			clientes = JsonHelper.extraerClientesJson(path);
		} catch (IOException e) {
			System.out.println("Error en la carga de Clientes");
			e.printStackTrace();
		}
    	
		for (Cliente cliente : clientes) {
			System.out.println("Error en la carga de Clientes" + cliente.getCategoria() + " " + cliente.getApellido());
			cliente.setCategoria(new Categoria((long) 2,"R2",0,0));
			persistirCliente(cliente);;
		}
		
	}
	
	public Long persistirCliente(Cliente cliente) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        System.out.println("Transaccion Exitosa: " + cliente.getNombre());
        return cliente.getId();
	}
	
	public void cargarCategoriasFromJson(String path) throws ParseException{
		
		List<Categoria> categorias = new ArrayList<Categoria>();
    	
		try {
			categorias = JsonHelper.extraerCategoriasJson(path);
		} catch (IOException e) {
			System.out.println("Error en la carga de Categorias");
			e.printStackTrace();
		}
    	
		for (Categoria categoria : categorias) {
			persistirCategoria(categoria);
		}
		
	}
		
	public String persistirCategoria(Categoria categoria) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(categoria);
        session.getTransaction().commit();
        return categoria.getCategoria();		
	}
	

}
