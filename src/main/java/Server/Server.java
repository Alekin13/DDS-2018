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
		
		Spark.get("/hello", (req, res) -> "Hello World");
		
		
//		System.out.println("Hoooola");
//		
//		Cliente unCliente = new Cliente();
//		List<Dispositivo> dispositivos = new ArrayList<>();
//		DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
//		DispositivoInteligente dispositivo = fabricaDeDispositivos.aireAcondicionado2200();
//		
//		dispositivos.add(dispositivo);
//		
//		
//		unCliente.setDispositivos(dispositivos);
//		
//		Spark.get("/elUSuario", (req,res) -> {
//			return unCliente.getDispositivos();
//			
//		});
		
//		//HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
//		Spark.get("/loginaccess", (req,res) -> {  
//			return new ModelAndView(null, "Login.html");                     
//		}, engine);
		
		
		Spark.get("/loginaccess", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			accesoBDD.controlLogin(nombreUsuario, password);
			
			
<<<<<<< HEAD
			//System.out.println(query);
=======
	//		System.out.println(query);
>>>>>>> 71f19ee9398bd53bf47bbca4ead7af7e49fdd4df
			
			
			//res.redirect("/home");
			return new ModelAndView(null, "Login.html"); 
			
		}, engine);	
	}
}
