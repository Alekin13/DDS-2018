package sge.simplexSolver;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import sge.dispositivo.*;
import sge.simplexSolver.SimplexFacade;

public class SimplexHelper {
	
	public List<Dispositivo> obtenerResultados(double z, PointValuePair variables, List<Dispositivo> dispositivos){
	
		
	List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
	int inicio = 0;
	int cantidad = dispositivos.size();
		
	SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
	simplexFacade.crearFuncionEconomica(1,1,1,1,1,1,1,1);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, 0.06, 0.75, 0.64, 0.1275, 0.4, 0.08, .011, 1.013);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 0, 1);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 360,0, 0, 0, 0, 0, 0, 0, 1);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 1, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 0, 0, 1, 0);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 1, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 0, 1, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 60, 0, 0, 0, 0, 1, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 1, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 6, 0, 0, 0, 1, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 30, 0, 0, 0, 1, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 3, 0, 0, 1, 0, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 15, 0, 0, 1, 0, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 3, 0, 1, 0, 0, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 30, 0, 1, 0, 0, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.GEQ, 120, 1, 0, 0, 0, 0, 0, 0, 0);
	simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 1, 0, 0, 0, 0, 0, 0, 0);
	PointValuePair solucion = simplexFacade.resolver();
	
	z = solucion.getValue();
	variables = solucion;
	
	for (Dispositivo dispositivo : dispositivos){
		if (inicio < cantidad){
			if (variables.getPoint()[inicio] <= dispositivo.getConsumoKwh()){ /* consumo */
				System.out.println(variables.getPoint()[inicio]);
				System.out.println(dispositivo.getConsumoKwh()); /* consumo */
				dispositivosSobrepasados.add(dispositivo);
			}
			inicio=inicio+1;
		}
	}
	return dispositivosSobrepasados;
	}
	
	/*public List<Dispositivo> comparacionVariables(PointValuePair variables, List<Dispositivo> dispositivos){
		
	}*/
	
	
}

