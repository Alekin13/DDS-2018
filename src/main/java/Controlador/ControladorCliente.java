package Controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import Usuario.Cliente;
import Repositorio.RepositorioUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorCliente {

	private RepositorioUsuarios repositorioUsuarios;

	public ControladorCliente(RepositorioUsuarios repositorioUsuarios) {
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public ModelAndView dashboard(Request request, Response response) {
		return new ModelAndView(null, "cliente/dashboard.hbs");
	}

	public ModelAndView formConsumoPeriodo(Request request, Response response) {
		return new ModelAndView(null, "cliente/consulta-consumo-periodo.hbs");
	}

	public ModelAndView procesarConsumoPeriodo(Request request, Response response) {
		String inicioParam = request.queryParams("inicio");
		String finParam = request.queryParams("fin");

		int userId = request.session().attribute("userId");
		Cliente cliente = repositorioUsuarios.buscarClientePorId(userId);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime inicio = LocalDateTime.parse(inicioParam, formatter);
		LocalDateTime fin = LocalDateTime.parse(finParam, formatter);

		double consumo = cliente.calcularConsumoEntrePeriodos(inicio, fin);

		Map<String, String> model = new HashMap<>();
		model.put("periodo_inicio", inicioParam);
		model.put("periodo_fin", finParam);
		model.put("consumo", String.valueOf(consumo));

		return new ModelAndView(model, "cliente/consulta-consumo-periodo-resultado.hbs");
	}

//	public ModelAndView formCargaArchivoDispositivos(Request request, Response response) {
//		return new ModelAndView(model, "cliente/carga-archivo-dispositivos.hbs");
//	}

//	public ModelAndView formSimplex(Request request, Response response) {
//		return new ModelAndView(null, "cliente/simplex.hbs");
//	}

//	public ModelAndView procesarSimplex(Request request, Response response) {
//		return new ModelAndView(model, "cliente/simplex-resultado.hbs");
//	}

//	public ModelAndView estadoHogar(Request request, Response response) {
//		return new ModelAndView(model, "cliente/estado-hogar.hbs");
//	}
}