package sge.procEjecSimplex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import sge.dispositivo.Dispositivo;
import sge.simplexSolver.SimplexFacade;
import sge.usuario.*;

public class ProcesoEjecucionSimplex {
	private long rangoEjecucionSegs = 0;
	private Cliente unUsuario;
	private boolean enEjecucion = false;
	

	public ProcesoEjecucionSimplex(Cliente unUsuario) {
		this.unUsuario = unUsuario;
	}
	
	
	public ProcesoEjecucionSimplex(long unRangoDeEjecucion, Cliente unUsuario) {
		this.rangoEjecucionSegs = unRangoDeEjecucion;
		this.unUsuario = unUsuario;
	}
	

	public long getRangoEjecucionSegs() {
		return rangoEjecucionSegs;
	}
	

	public void setRangoEjecucionSegs(long rangoEjecucionSegs) {
		this.rangoEjecucionSegs = rangoEjecucionSegs;
	}
	
	
	public List<Dispositivo> ejecutarPeticion() throws FileNotFoundException, IOException {
		List<Double> listaCoeficientes = new ArrayList<Double>();
		List<Double> auxiliarParaRestr = new ArrayList<Double>();
		List<Double> funcionEconomica = new ArrayList<Double>();
		
		// usamos list<Double> porque no tiene límites, luego lo trasformamos a lo que necesitan las funciones
		
		double[] listaCoeficientesDouble;
		double[] auxiliarParaRestrDouble;
		double[] funcionEconomicaDouble = null;
		int inicio = 0;
		List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
		
		enEjecucion = true;
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
		
		/* Para tener ya generada la lista con ceros,
		 * me refiero a lo que viene luego del 90 
		 * simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 0, 1);
		 * generemos una lista por la cantidad de dispositivos, lista con todos ceros
		 * y luego vamos seteando el 1 segun posición de nuestro dispositivo*/
		try {
			for(int i = 0; i < this.unUsuario.getDispositivos().size(); ++i) {
				auxiliarParaRestr.add((double) 0);
			}
		} catch (Exception e) {
			System.out.println("Error al inicializar variables función económica.");
		}
				
		// Seteo de variables Xn para funcion economica
		// sería esta parte en el test: simplexFacade.crearFuncionEconomica(1,1,1,1,1,1,1,1);
		try {
			for(int i = 0; i < this.unUsuario.getDispositivos().size(); ++i) {
				funcionEconomica.add((double) 1);
			}
		} catch (Exception e) {
			System.out.println("Error al inicializar variables función económica.");
		}
		
		funcionEconomicaDouble = funcionEconomica.stream().mapToDouble(f -> f).toArray();
		simplexFacade.crearFuncionEconomica(funcionEconomicaDouble);
		
		// Conseguimos todos los coeficientes.
		// serían todos los números que vienen luego de 440640
		// simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, 0.06, 0.75, 0.64, 0.1275, 0.4, 0.08, .011, 1.013);
		try {
			for(int i = 0; i < this.unUsuario.getDispositivos().size(); ++i) {
				Dispositivo d = unUsuario.getDispositivos().get(i);
				listaCoeficientes.add(d.obtenerCoeficiente());
			}
		} catch (Exception e) {
			System.out.println("Error en la obtención de coeficientes, intente más tarde.");
		}
		

		listaCoeficientesDouble = listaCoeficientes.stream().mapToDouble(d -> d).toArray(); 
		// Primer restricción: no consumir más que 440640 kWh por mes
		simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, listaCoeficientesDouble);
		
		//Pero para las siguientes restricciones, hay que ir generandolas
		try {
			for(int i = 0; i < this.unUsuario.getDispositivos().size(); ++i) {
				Dispositivo d = unUsuario.getDispositivos().get(i);
				auxiliarParaRestr.set(i, (double)1);
				if(i !=0) {
					auxiliarParaRestr.set((i-1), (double)0);
				}
				auxiliarParaRestrDouble = auxiliarParaRestr.stream().mapToDouble(f -> f).toArray();
				
				simplexFacade.agregarRestriccion(Relationship.GEQ, d.obtenerUsoMensualMinHS(), auxiliarParaRestrDouble);
				simplexFacade.agregarRestriccion(Relationship.LEQ, d.obtenerUsoMensualMaxHS(), auxiliarParaRestrDouble);
			}
		} catch (Exception e) {
			System.out.println("Error en la obtención de restricciones de uso, intente más tarde.");
		}
		
		
		PointValuePair solucion = simplexFacade.resolver();
		
		for (Dispositivo dispositivo : unUsuario.getDispositivos()){
			System.out.println(solucion.getPoint()[inicio]);
			if (inicio < this.unUsuario.getDispositivos().size()){
				if (solucion.getPoint()[inicio] <= dispositivo.getConsumoKwH()){ /* consumo */
					
					System.out.println("Debería consumir: " + solucion.getPoint()[inicio] + "kWh," 
						+ " pero está consumiendo: " + dispositivo.getConsumoKwH() + "kWh.");
					dispositivosSobrepasados.add(dispositivo);
				}
				inicio=inicio+1;
			}
		}
		return dispositivosSobrepasados;
	}
	
	
	public void setTerminarEjecucion(boolean dato) {
		enEjecucion = false;
	}
	
	
	public boolean devolverEstado() {
		return enEjecucion;
	}
	
	
	public void ejecutarPorTiempo(long segundos) throws IOException {
		Timer t = new Timer();
		long milisegundos = segundos*1000;
		t.scheduleAtFixedRate((TimerTask) this.ejecutarPeticion(), 0, milisegundos);
	}

}

	
