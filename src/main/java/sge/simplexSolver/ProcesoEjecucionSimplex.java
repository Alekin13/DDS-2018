package sge.simplexSolver;

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
import sge.helperClass.*;
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
	
	
	public PointValuePair ejecutarPeticion() throws FileNotFoundException, IOException {
		SGEHelperClass helper = new SGEHelperClass();
		List<Dispositivo> dispositivosSeleccionados = new ArrayList<Dispositivo>();
		
		int inicio = 0;
		List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();

		this.comenzarEjecucion();
		
		dispositivosSeleccionados = helper.filtrarDispositivoHeladera(unUsuario);
		
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
	
		helper.generarFuncionEconomica(dispositivosSeleccionados, simplexFacade);
					
		helper.setearLimiteConsumoMensual(dispositivosSeleccionados, simplexFacade);
		
		helper.setearRestriccionesConsumo(dispositivosSeleccionados, simplexFacade);
		
		PointValuePair solucion = simplexFacade.resolver();
		
		for (Dispositivo dispositivo : dispositivosSeleccionados){
			if (inicio < dispositivosSeleccionados.size()){
				if (solucion.getPoint()[inicio] <= dispositivo.getConsumoKwH()){ /* consumo */
					
					System.out.println("Debería consumir: " + solucion.getPoint()[inicio] + "kWh," 
						+ " pero está consumiendo: " + dispositivo.getConsumoKwH() + "kWh.");
					dispositivosSobrepasados.add(dispositivo);
				}
				inicio=inicio+1;
			}
		}
		
		System.out.println("El valor óptimo en horas que el usuario estará consumiendo: " + solucion.getValue());
		
		inicio = 0;
		for (Dispositivo dispositivo : dispositivosSeleccionados){
			if (inicio < dispositivosSeleccionados.size()){
					System.out.println("Las horas de uso de " + dispositivo.getPropiedad() + " deberían ser: "
							+ solucion.getPoint()[inicio]);
				inicio=inicio+1;
			}
		}
		this.setTerminarEjecucion();	
		return solucion;
	}
	
	
	public void setTerminarEjecucion() {
		enEjecucion = false;
	}
	
	public void comenzarEjecucion() {
		enEjecucion = true;
	}
	
	public boolean devolverEstado() {
		return enEjecucion;
	}
	
}

	
