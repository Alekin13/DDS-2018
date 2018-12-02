package Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Dispositivo.Dispositivo;
import Dispositivo.DispositivoMaestro;
import Repositorio.RepositorioDispositivo;
import Repositorio.RepositorioUsuarios;
import Spark.SessionHelper;
import Usuario.Cliente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorDispositivo {

	private RepositorioDispositivo repositorioDispositivo;

	public ControladorDispositivo(RepositorioDispositivo repositorioDispositivos) {
		this.repositorioDispositivo = repositorioDispositivos;
	}
	
	public static ModelAndView show(Request req, Response res){
		
	    String username = req.session().attribute("username");
		
	    if(username==null)	
			 return new ModelAndView(null,"/error.hbs");			
		
		Cliente cliente= (Cliente) RepositorioUsuarios.getInstance().buscarPorUsuario(username);
		Map<String, List<Dispositivo>> model = new HashMap<>();
		List<Dispositivo> dispositivos = cliente.getDispositivosInteligentes();
		model.put("dispositivos",dispositivos);
		return new ModelAndView(model,"/dispositivos.hbs");
		
	}
	
	public static ModelAndView showInteligente(Request req, Response res){
		
		if(req.session().attribute("username")==null)	
			return new ModelAndView(null,"/error.hbs");
		
		Map<String, List<Dispositivo>> model = new HashMap<>();
		String username = req.session().attribute("username");
		Cliente cliente = (Cliente) RepositorioUsuarios.instancia.buscarPorUsuario(username);
		
		List<Dispositivo> dispositivosInteligentes = cliente.getDispositivosInteligentes();
		model.put("dispositivosInteligente", dispositivosInteligentes);
		
		return new ModelAndView(model, "/dispositivos.hbs");
		
	}
	
	public ModelAndView listarDispositivosMaestros(Request request, Response response) {
		SessionHelper.ensureUserIsLoggedIn(request, response);

		Map<String, List<DispositivoMaestro>> model = new HashMap<>();
		List<DispositivoMaestro> dispositivos = this.repositorioDispositivo.listarMaestros();

		model.put("dispositivos", dispositivos);
		return new ModelAndView(model, "administrador/listar_dispositivos_maestros.hbs");
	}

}
