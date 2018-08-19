package sge.procEjecSimplex;

import static java.util.stream.Collectors.toList;

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
import sge.dispositivo.DispositivoInteligente;
import sge.simplexSolver.SimplexFacade;
import sge.usuario.*;

public class ProcesoEjecucionSimplex extends TimerTask {
	private long rangoEjecucionSegs = 0;
	private Cliente unUsuario;
	private Object listaCoeficientes;
	private boolean ejecucion = false;
	

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
		double[] listaSimplex;
		double z;
		PointValuePair variables;
		int inicio = 0;
		//int cantidad = this.unUsuario.getDispositivos().size();
		List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
		
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
		simplexFacade.crearFuncionEconomica(1,1,1,1,1,1,1,1);
		
		// Conseguimos todos los coheficientes.
		try {
			for(int i = 0; i <= this.unUsuario.getDispositivos().size(); ++i) {
				Dispositivo d = unUsuario.getDispositivos().get(i);
				listaCoeficientes.add(d.obtenerCoeficiente());
			}
		} catch (Exception e) {
			System.out.println("Error en la obtención de coheficientes, intente más tarde.");
		}
		
		// Armamos la lista de coheficientes que encesita el Simplex 
		listaSimplex = listaCoeficientes.stream().mapToDouble(d -> d).toArray(); 
		
		
		// Primer restricción: no consumir más que 440640 kWh por mes
		simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, listaSimplex);
		
		//Pero para las siguientes restricciones, hay que ir generandolas
		
		PointValuePair solucion = simplexFacade.resolver();
		
		z = solucion.getValue();
		variables = solucion;
		
		for (Dispositivo dispositivo : unUsuario.getDispositivos()){
			if (inicio < this.unUsuario.getDispositivos().size()){
				if (variables.getPoint()[inicio] <= dispositivo.getConsumoKwH()){ /* consumo */
					System.out.println(variables.getPoint()[inicio]);
					System.out.println(dispositivo.getConsumoKwH()); /* consumo */
					dispositivosSobrepasados.add(dispositivo);
				}
				inicio=inicio+1;
			}
		}
		return dispositivosSobrepasados;
	}
	
	
	public void setTerminarEjecucion(boolean dato) {
		ejecucion = dato;
	}
	
	
	public boolean terminarEjecucion() {
		return ejecucion;
	}
	
	
	public void ejecutarPorTiempo(long segundos) throws IOException {
		Timer t = new Timer();
		long milisegundos = segundos*1000;
		t.scheduleAtFixedRate((TimerTask) this.ejecutarPeticion(), 0, milisegundos);
	
		
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

	
