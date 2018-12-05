package Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Repositorio.RepositorioUsuarios;
import Spark.SessionHelper;
import Usuario.Cliente;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorAdministrador {

	private RepositorioUsuarios repositorioUsuarios;

	public ControladorAdministrador(RepositorioUsuarios repositorioUsuarios) {
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public ModelAndView dashboard(Request request, Response response) {
		SessionHelper.ensureUserIsLoggedIn(request, response);

		return new ModelAndView(null, "administrador/dashboard.hbs");
	}

//	public ModelAndView listarHogaresYConsumos(Request request, Response response) {
//		Map<String, List<Cliente>> model = new HashMap<>();
//		List<Cliente> clientes = repositorioUsuarios.listarClientes();

//		model.put("clientes", clientes);

//		return new ModelAndView(model, "administrador/hogares_y_consumos.hbs");
//	}

//	public ModelAndView verConsumos(Request request, Response response) {
//		return new ModelAndView(model, "administrador/ver_consumos.hbs");
//	}

}