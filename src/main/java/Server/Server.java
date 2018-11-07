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
		Spark.staticFileLocation("/public");
		
		accesoServerBDD accesoBDD = new accesoServerBDD();
		

		spark.debug.DebugScreen.enableDebugScreen();
		
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		
		Spark.port(8080);
		
		// Testing connection
		Spark.get("/hello", (req, res) -> "Hello World");

		
		Spark.get("/PaginaSGE", (req,res) -> {
			return new ModelAndView(null, "Login.html");

		},engine);	
		
		Spark.post("/loginaccess", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			if (accesoBDD.controlLogin(nombreUsuario, password)) {
				
			}
			
			return null;
			
			
		});
		
		//res.redirect("/home" );

		
		
		}
	

}
