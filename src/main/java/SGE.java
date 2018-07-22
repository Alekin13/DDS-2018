import java.util.ArrayList;
import java.util.List;
import sge.dispositivo.DispositivoEstandar;
import sge.categoria.Categoria;
import sge.usuario.Administrador;
import sge.usuario.Cliente;
import sge.view.Presentacion;
import sge.actuador.Actuador;

public class SGE {

	private static SGE sge;
	private List<Cliente> clientes; 
	private List<Administrador> administradores; 
	private List<Categoria> categorias;
	private List<Actuador> actuadores;

	// El constructor es privado para que no puedan crear instancias fuera de esta clase
	private SGE() {
    }

	public static void main(String[] args) {
		
		/**Hace una demostracion por consola de los Datos que posee*/
		Presentacion.mostrarConsola();
		
		DispositivoEstandar dispositivo = new DispositivoEstandar();
		dispositivo.setNombreDispositivo("Heladera Patrick");
		System.out.println(dispositivo.getNombreDispositivo());
		
	}
	
	
	
	
}


public class SGE {
	
    

    // Acceso publico y estatico
    public static SGE getInstance() {
        if (sge == null) {
            sge = new SGE();
            sge.clientes = new ArrayList<Cliente>();
        	sge.administradores = new ArrayList<Administrador>();
        	sge.categorias = new ArrayList<Categoria>();
        	sge.actuadores = new ArrayList<Actuador>();
        }
        return sge;
    }
    
    
    public void agregarCliente(Cliente unCliente){
    	this.clientes.add(unCliente);
    }
    
    public void setearClientes(List<Cliente> clientes){
    	this.clientes=clientes;
    }
    
    public void agregarAdministrador(Administrador unAdministrador){
    	this.administradores.add(unAdministrador);
    }
    
    public void agregarCategoria(Categoria unaCategoria){
    	sge.categorias.add(unaCategoria);
    }
    
    public List<Administrador> getAdministradores() {
        return this.administradores;
    }
    
    public List<Cliente> getClientes() {
        return this.clientes;
    }
    
    public List<Categoria> getCategorias() {
        return this.categorias;
    }
    public int cantidadDeCategorias(){
    	return this.categorias.size();
    } 
    
	public void recategorizarClientes(){
		for (Cliente cliente : this.clientes){
			this.categorizar(cliente);
		}
	}
		
	public void categorizar(Cliente unCliente) {
		for(Categoria categoria : this.categorias)
		if(categoria.perteneceAcategoria(unCliente.consumoMensual()))
			unCliente.setCategoria(categoria);
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Actuador seleccionarActuador(String ID_Actuador) {
		 Actuador resultado = null;
		    for (Actuador actuador : this.getActuadores()) {
		        if (actuador.getID().equals(ID_Actuador)){
		        	resultado = actuador;
		            break;
		        }
		    }
		 return resultado;   	
	}
	
	public List<Actuador> getActuadores() {
		return this.actuadores;
	}
	
	public void setActuadores(List<Actuador> actuadores) {
		sge.actuadores = actuadores;
	}
	public void agregarActuador(Actuador actuador){
		sge.actuadores.add(actuador);
	}
	
}
