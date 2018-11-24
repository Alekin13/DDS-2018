package Server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Usuario.Cliente;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Spark;

public class Server {
	
	public static void main (String [ ] args) {
		// Spark configuration
		spark.debug.DebugScreen.enableDebugScreen();
		Spark.staticFileLocation("/public");
		Spark.port(8080);
		
		// useful initializations
		accesoServerBDD accesoBDD = new accesoServerBDD();

				
		// Testing connection
		Spark.get("/hello", (req, res) -> "Hello World");
		
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		
		Spark.get("/PaginaSGE", (req,res) -> {
			return new ModelAndView(null, "Login.html");
		},engine);	
		
		//Creating loggin: accessing 
		Spark.post("/PaginaSGE/Home", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			if (accesoBDD.controlLogin(nombreUsuario, password)) {
				return new ModelAndView(null, "Home.html");
			} else { return null; }
        },engine);
		
		Spark.get("/seleccionUsuario/UltimasMediciones", (req,res) -> 
		"UltimasMediciones");
		
		Spark.get("/seleccionUsuario/ConsumoPorPeriodo", (req,res) -> 
		"ConsumoPorPeriodo");
		
		Spark.get("/seleccionUsuario/EstadoPorDispositivo", (req,res) -> 
		"EstadoPorDispositivo");
		
		Spark.get("/seleccionUsuario/ReglasActivas", (req,res) -> 
		"ReglasActivas");
		
		Spark.get("/seleccionUsuario/AltaDispositivo", (req,res) -> 
		"AltaDispositivo");
		

		
		
		
		//prueba Gonzalo
		Spark.get("/AltaDispositivos", 
				(req,res) -> {return new ModelAndView(null, "AltaDispositivos.html");}, 
				engine);		
		
		
		
		
		
		
		
		
		}

}
