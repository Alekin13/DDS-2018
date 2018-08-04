package sge.procEjecSimplex;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import com.mchange.v1.util.ArrayUtils;

import sge.dispositivo.Dispositivo;
import sge.simplexSolver.SimplexFacade;
import sge.usuario.*;

public class ProcesoEjecucionSimplex {
	private long rangoEjecucionSegs = 0;
	private Cliente unUsuario;
	
	public ProcesoEjecucionSimplex(long unRangoDeEjecucion, Usuario unUsuario) {
		rangoEjecucionSegs = unRangoDeEjecucion;
		unUsuario = unUsuario;
	}

	public long getRangoEjecucionSegs() {
		return rangoEjecucionSegs;
	}

	public void setRangoEjecucionSegs(long rangoEjecucionSegs) {
		this.rangoEjecucionSegs = rangoEjecucionSegs;
	}
	
	public List<Dispositivo> ejecutarPeticion() {
		List<Double> listaCoeficientes;
		double[] listaSimplex;
		double z;
		PointValuePair variables;
		int inicio = 0;
		int cantidad = unUsuario.getDispositivos().size();
		List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
		
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
		simplexFacade.crearFuncionEconomica(1,1,1,1,1,1,1,1);
		
		listaCoeficientes = unUsuario.getDispositivos().stream().map(d -> d.obtenerCoeficiente()).collect(Collectors.toList());
		
		listaSimplex = listaCoeficientes.stream().mapToDouble(d -> d).toArray(); 
		
		simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, listaSimplex);
		
		PointValuePair solucion = simplexFacade.resolver();
		
		z = solucion.getValue();
		variables = solucion;
		
		for (Dispositivo dispositivo : unUsuario.getDispositivos()){
			if (inicio < cantidad){
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
		
		
	
}
