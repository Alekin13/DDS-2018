package Server;

import java.util.ArrayList;
import java.util.List;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Usuario.Cliente;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Spark;

public class Server {
	
	public static void main(String[] args) {
		spark.debug.DebugScreen.enableDebugScreen();
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		Spark.port(8080);

		Spark.get("/hello", (req, res) -> "Hello World");
		
		System.out.println("Hoooola");
		
		Cliente unCliente = new Cliente();
		List<Dispositivo> dispositivos = new ArrayList<>();
		DispositivoFactory fabricaDeDispositivos = new DispositivoFactory();
		DispositivoInteligente dispositivo = fabricaDeDispositivos.aireAcondicionado2200();
		
		dispositivos.add(dispositivo);
		
		
		unCliente.setDispositivos(dispositivos);
		
		Spark.get("/elUSuario", (req,res) -> {
			return unCliente.getDispositivos();
			
		});
		
		//HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		Spark.get("/formulario/access", (req,res) -> {  
						
			return new ModelAndView(null, "Login.html");                     
		}, engine);
		
		
		Spark.post("/usuario", (req,res) -> {
			req.queryParams("nombre");
			req.queryParams("password");
			
			res.redirect("/home");
			return null;
		});	
	}
}
