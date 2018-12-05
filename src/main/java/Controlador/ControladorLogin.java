package Controlador;

import java.util.HashMap;
import java.util.Map;

import Repositorio.RepositorioUsuarios;
import Usuario.Administrador;
import Usuario.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorLogin {

	private RepositorioUsuarios usuarios;
	
	public ControladorLogin(RepositorioUsuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	public ModelAndView show(Request req, Response res) {
		return new ModelAndView(null, "home/login.hbs");
	}
	
	public ModelAndView handleLoginPost(Request req, Response res) {
		
		Map<String, Object> model = new HashMap<>();

		String user  = req.queryParams("inputUsuario");
		String password = req.queryParams("inputPassword");

		if (user.isEmpty() || password.isEmpty()) {
			model.put("authenticationFailed", true);
			return new ModelAndView(model, "home/login.hbs");
		}

		Usuario usuario = usuarios.buscarPorUsuario(user);

		if (usuario == null) {
			model.put("authenticationFailed", true);
			return new ModelAndView(model, "home/login.hbs");
		}

		if (!usuario.getPassword().equals(password)) {
			model.put("authenticationFailed", true);
			return new ModelAndView(model, "home/login.hbs");
		}

		req.session().attribute("currentUser", user);
		req.session().attribute("userId", usuario.getId());

		if (usuario instanceof Administrador) {
			res.redirect("/administrador/dashboard");
		}

		res.redirect("/cliente/dashboard");

		return null;
	}

	public ModelAndView handleLogoutPost(Request request, Response response) {
		request.session().removeAttribute("currentUser");
		request.session().removeAttribute("userId");
		request.session().attribute("loggedOut", true);
		response.redirect("/login");
		return null;
	};
}