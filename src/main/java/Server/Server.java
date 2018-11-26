package Server;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.math3.optim.PointValuePair;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoEstado;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoInteligente;
import Helper.EntityManagerHelper;
import Simplex.SimplexJob;
import Usuario.Cliente;
import Usuario.Usuario;
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
		//final Cliente incomingUser = new Cliente();
		
		// Testing connection
		Spark.get("/hello", (req, res) -> "Hello World");
		
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		
		Spark.get("/PaginaSGE", (req,res) -> {
			return new ModelAndView(null, "Login.html");
		},engine);	
		
		//Creating login: accessing 
		Spark.post("/PaginaSGE/Home", (req,res) -> {
			String nombreUsuario = req.queryParams("nombre");
			String password = req.queryParams("password");
			
			// Need to preserve user when logged in  
			if (accesoBDD.controlLogin(nombreUsuario, password)) {
				Usuario incomingUser = accesoBDD.gettingUserFromDB(nombreUsuario);
				return new ModelAndView(incomingUser, "Home.html");
			} else { 
				Spark.halt(401,"Didnt recognised user");
				return null; }
        },engine);

		
		Spark.get("/seleccionUsuario/EjecutarSimplex", (req,res) -> {
			Cliente incomingUser = accesoBDD.getSessionUser();
			SimplexJob ejecucionDelSimplexInstance = new SimplexJob(incomingUser);
			PointValuePair solucion = ejecucionDelSimplexInstance.ejecutarPeticion();
						
			return new ModelAndView(incomingUser, "EjecucionSimplexActual.html");
		}, engine);
		
		Spark.get("/ConsumoPorPeriodo", (req,res) -> {
			return new ModelAndView(null, "ConsumoPorPeriodo.html");
		},engine);	
		
		Spark.post("/ConsumoPorPeriodo", (req,res) -> {
			
			String fechaInicio = req.queryParams("datepicker");
			String fechaFin = req.queryParams("datepicker2");
			Cliente incomingUser = accesoBDD.getSessionUser();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date fechaInicio_ld = sdf.parse(fechaInicio);
			Date fechaFin_ld = sdf.parse(fechaFin);
			 
			for (Dispositivo dispositivo : incomingUser.getDispositivos()) {
				for (DispositivoEstado dEstado : dispositivo.getEstados()) {
					Date cambioEstadoDispositivo = 
							sdf.parse(dEstado.getFechaDeCambioDeEstado());
					 
					if ( cambioEstadoDispositivo.compareTo(fechaInicio_ld) > 0 &&
						 cambioEstadoDispositivo.compareTo(fechaInicio_ld) < 0 ) {
						 System.out.println("hola");
					}
				}
				
				
			}
			
			return new ModelAndView(null, "ConsumoPorPeriodo.html");
		}, engine);
		
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
