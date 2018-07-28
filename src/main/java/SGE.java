import java.util.List;
import sge.categoria.Categoria;
import sge.usuario.Administrador;
import sge.usuario.Cliente;
import sge.actuador.CommandActuadores;

public class SGE {

	public static void main(String[] args){
	
	}
	
	private static SGE sge;
	private List<Cliente> clientes; 
	private List<Administrador> administradores; 
	private List<Categoria> categorias;
	private List<CommandActuadores> actuadores;

	// El constructor es privado para que no puedan crear instancias fuera de esta clase
	private SGE() {
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<CommandActuadores> getActuadores() {
		return actuadores;
	}

	public void setActuadores(List<CommandActuadores> actuadores) {
		this.actuadores = actuadores;
	}

    public void agregarCliente(Cliente unCliente){
    	this.clientes.add(unCliente);
    }
    
    public void agregarAdministrador(Administrador unAdministrador){
    	this.administradores.add(unAdministrador);
    }
    
    public void agregarCategoria(Categoria unaCategoria){
    	sge.categorias.add(unaCategoria);
    }

	public void agregarActuador(CommandActuadores actuador){
		sge.actuadores.add(actuador);
	}

	public void recategorizarClientes(){
		for (Cliente cliente : this.clientes){
			this.categorizar(cliente);
		}
	}

	public void categorizar(Cliente unCliente) {
		for(Categoria categoria : this.categorias)
			categoria.definirCategoriaCliente(unCliente);
	}

}