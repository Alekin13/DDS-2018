package Helper;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstado;
import Usuario.Categoria;
import Usuario.Cliente;
import Estado.Estado;


public class EntityManagerHelper {
	private static EntityManagerFactory factory;
	private static ThreadLocal<EntityManager> threadLocal;
	
	static {
		try {
			EntityManagerHelper.factory = Persistence.createEntityManagerFactory("db");
			EntityManagerHelper.threadLocal = new ThreadLocal<>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public EntityManager entityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		EntityManager manager = EntityManagerHelper.threadLocal.get();
		if (manager == null || !manager.isOpen()) {
		    manager = EntityManagerHelper.factory.createEntityManager();
		    EntityManagerHelper.threadLocal.set(manager);
		}
		return manager;
	}
	
	public static void rollback(){
	    	EntityManager em = EntityManagerHelper.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			if(tx.isActive()){
				tx.rollback();
			}
	}
	 
	private void execute(String deNombre, Object unObjeto) {
		this.initTransaccion();
		try{
			Method unMetodo = this.entityManager().getClass().getMethod(deNombre, new Object().getClass());
			this.initTransaccion();
			unMetodo.invoke(this.entityManager(),unObjeto);
			this.commitTransaccion();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void initTransaccion() {
		if(!this.entityManager().getTransaction().isActive()) {
			this.entityManager().getTransaction().begin();
		}
	}
	
	private void commitTransaccion() {
		if(this.entityManager().getTransaction().isActive()) {
			this.entityManager().getTransaction().commit();
		}
	}
	
	public void agregar(Object unObjeto) {
		this.execute("persist", unObjeto);
	}
	
	public void modificar(Object unObjeto) {
		this.execute("merge", unObjeto);
	}
	
	public void eliminar(Object unObjeto) {
		this.execute("remove", unObjeto);
	}
	
	public <T> T buscar(Class<T> clase, int id) {
		T find = (T) this.entityManager().find(clase, id);
		return find;
	}
	
	@SuppressWarnings("unchecked")
	private <T> TypedQuery<T> generarQueryPara(Class<T> clase, ImmutablePair<Object, Object> ... pair){
		String condiciones =  " where ";
		for(int index = 0; index<pair.length; index++) {
			condiciones+=(pair[index].left.toString()+" =:"+pair[index].left.toString());
		}
		TypedQuery<T> query = this.entityManager().createQuery("from "+clase.getName()+condiciones, clase);
		for(int index = 0; index<pair.length; index++) {
			query.setParameter(pair[index].left.toString(), pair[index].right);
		}
		return query;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T buscar(Class<T> clase, ImmutablePair<Object, Object> ... pair) {
		TypedQuery<T> query = this.generarQueryPara(clase, pair);
		List<T> resultados = query.getResultList();
		return resultados.get(query.getFirstResult());
	}
	
	public <T> List<T> buscarTodos(Class<T> clase) {
		List<T> resultList = (List<T>) this.entityManager().createQuery("from "+clase.getName(), clase).getResultList();
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> buscarTodos(Class<T> clase, ImmutablePair<Object, Object> ... pair) {
		TypedQuery<T> query = this.generarQueryPara(clase, pair);
		return query.getResultList();
	}
	
	public void cerrarEntityManager() {
		EntityManager em = threadLocal.get();
		EntityManagerHelper.threadLocal.set(null);
		em.close();
    }
	
	public  void withTransaction(Runnable action) {
		withTransaction(() -> {
			action.run();
			return null;
		});
	}
	
    public  <A> A withTransaction(Supplier<A> action) {
    	this.initTransaccion();
    	try {
    		A result = action.get();
    		this.commitTransaccion();
			return result;
    	} catch(Throwable e) {
    		rollback();
    		throw e;
    	}
    }


    public void cargarUsuarioFromJson(String path) throws ParseException{
    		
		List<Cliente> clientes = new ArrayList<Cliente>();
    	
		try {
			clientes = JsonHelper.extraerClientesJson(path);
		} catch (IOException e) {
			System.out.println("Error en la carga de Clientes");
			e.printStackTrace();
		}
    	
		for (Cliente cliente : clientes) {
			System.out.println("Error en la carga de Clientes" + " " + cliente.getApellido());
			persistirCliente(cliente);;
		}
		
	}
	
	public void persistirCliente(Cliente cliente) {

		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
        transaction.begin();
    
        entityManager.persist(cliente);
        System.out.println("Transaccion Exitosa: " + cliente.getNombre());
        transaction.commit();
	
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
    		
	public void persistirCategoria(Categoria categoria) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
        transaction.begin();
    
        entityManager.persist(categoria);
        System.out.println("Transaccion Exitosa: " + categoria.getCategoria());
        transaction.commit();

	}
	

	public void cargarDispositivosFromJson(String path) throws ParseException{
    		
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
    	
		try {
			dispositivos = JsonHelper.extraerDispositivosJson(path);
		} catch (IOException e) {
			System.out.println("Error en la carga de DISPOSITIVOS");
			e.printStackTrace();
		}
    	
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		
		EntityTransaction transaccion = entityManager.getTransaction();
		for (Dispositivo dispositivo : dispositivos) {
			
			transaccion.begin();
			agregar(dispositivo);
			transaccion.commit();
			//persistirDispositivo(dispositivo);
		}
		
	}
    	
	public void persistirDispositivo(Dispositivo dispositivo) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaccion = entityManager.getTransaction();
		transaccion.begin();
		entityManager.persist(dispositivo);
		transaccion.commit();
	}
    	
	
	public void cargarEstadosFromJson(String path) throws ParseException{
		
		List<Estado> estados = new ArrayList<Estado>();
    	
		try {
			estados = JsonHelper.extraerEstadosJson(path);
		} catch (IOException e) {
			System.out.println("Error en la carga de ESTADOS");
			e.printStackTrace();
		}
    	
		for (Estado estado : estados) {
			persistirEstados(estado);
		}
		
	}
	
	public void persistirEstados(Estado estado) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaccion = entityManager.getTransaction();
		
		transaccion.begin();
		entityManager.persist(estado);
		
		transaccion.commit();
	}

	
	public void cargarDispositivoEstadoFromJson(String path) throws ParseException{
		
		List<DispositivoEstado> dispEstados = new ArrayList<DispositivoEstado>();
    	
		try {
			dispEstados = JsonHelper.extraerEstadosPorDispJson(path);
		} catch (IOException e) {
			System.out.println("Error en la carga de Estados por Dispositivos");
			e.printStackTrace();
		}
    	
		for (DispositivoEstado dispest : dispEstados) {
			persistirDispositivoEstado(dispest);
		}
		
	}
	
	public void persistirDispositivoEstado(DispositivoEstado de) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaccion = entityManager.getTransaction();
		
		transaccion.begin();
		entityManager.persist(de);
		
		transaccion.commit();
	}
}

