package Server;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Controlador.ControladorAdministrador;
import Controlador.ControladorCliente;
import Controlador.ControladorDispositivo;
import Controlador.ControladorHome;
import Controlador.ControladorLogin;
import Controlador.ControladorReportes;
import Repositorio.RepositorioDispositivo;
import Repositorio.RepositorioTransformadores;
import Repositorio.RepositorioUsuarios;
import Spark.BooleanHelper;
import Spark.HandlebarsTemplateEngineBuilder;
import Spark.StringHelper;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder.create().withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.withHelper("isDispositivoInteligente", StringHelper.isDispositivoInteligente).build();

		Spark.staticFiles.location("/public");

		final String PERSISTENCE_UNIT_NAME = "db";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager manager = factory.createEntityManager();

		RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios(manager);
		RepositorioTransformadores repositorioTransformadores = new RepositorioTransformadores(manager);
		RepositorioDispositivo repositorioDispositivos = new RepositorioDispositivo(manager);
		
		ControladorHome homeController = new ControladorHome(repositorioTransformadores);
		ControladorLogin loginController = new ControladorLogin(repositorioUsuarios);
		ControladorAdministrador administradorController = new ControladorAdministrador(repositorioUsuarios);
		ControladorDispositivo dispositivoController = new ControladorDispositivo(repositorioDispositivos);
		ControladorReportes reportesController = new ControladorReportes(repositorioUsuarios, repositorioTransformadores);
		
		ControladorCliente clienteController = new ControladorCliente(repositorioUsuarios);
		
		Spark.get("/", homeController::home, engine);
		Spark.get("/mapa", homeController::mostrarMapa, engine);
		Spark.get("/mapa/transformador/:id/consumo", homeController::verConsumoTransformador);
		Spark.get("/login", loginController::show, engine);
		Spark.post("/login", loginController::handleLoginPost, engine);
		Spark.get("/logout", loginController::handleLogoutPost, engine);
		Spark.get("/administrador/dashboard", administradorController::dashboard, engine);
		Spark.get("/administrador/hogares-consumos", administradorController::listarHogaresYConsumos, engine);
		//Spark.get("/administrador/hogares-consumos/:id", administradorController::verConsumos, engine);
		Spark.get("/administrador/reportes/consumo-hogar-periodo", reportesController::formConsumoHogarPeriodo, engine);
		Spark.post("/administrador/reportes/consumo-hogar-periodo", reportesController::procesarConsumoHogarPeriodo, engine);
		Spark.get("/administrador/reportes/consumo-tipo-dispositivo-periodo", reportesController::formConsumoTipoDispositivoPeriodo, engine);
		//Spark.post("/administrador/reportes/consumo-tipo-dispositivo-periodo", reportesController::procesarConsumoTipoDispositivoPeriodo, engine);
		Spark.get("/administrador/reportes/consumo-transformador-periodo", reportesController::formConsumoTransformadorPeriodo, engine);
		Spark.post("/administrador/reportes/consumo-transformador-periodo", reportesController::procesarConsumoTransformadorPeriodo, engine);
		Spark.get("/administrador/dispositivos", dispositivoController::listarDispositivosMaestros, engine);
		//Spark.get("/administrador/dispositivos/nuevo", dispositivoController::nuevoDispositivoMaestro, engine);
		//Spark.post("/administrador/dispositivos", dispositivoController::crearDispositivoMaestro);
		Spark.get("/cliente/dashboard", clienteController::dashboard, engine);
		//Spark.get("/cliente/dispositivos", dispositivoController::listarDispositivosCliente, engine);
		//Spark.get("/cliente/dispositivos/nuevo", dispositivoController::nuevoDispositivoCliente, engine);
		//Spark.post("/cliente/dispositivos", dispositivoController::crearDispositivoCliente);
		//Spark.post("/cliente/dispositivos/:id/borrar", dispositivoController::borrarDispositivoCliente);
		Spark.get("/cliente/consulta-consumo-periodo", clienteController::formConsumoPeriodo, engine);
		Spark.post("/cliente/consulta-consumo-periodo", clienteController::procesarConsumoPeriodo, engine);
		//Spark.get("/cliente/carga-archivo-dispositivos", clienteController::formCargaArchivoDispositivos, engine);
		//Spark.post("/cliente/carga-archivo-dispositivos", clienteController::procesarCargaArchivoDispositivos);
		//Spark.get("/cliente/simplex", clienteController::formSimplex, engine);
		//Spark.post("/cliente/simplex", clienteController::procesarSimplex, engine);
		//Spark.get("/cliente/estado-hogar", clienteController::estadoHogar, engine);


	}

}
