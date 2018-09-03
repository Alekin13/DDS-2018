package sge.simplexSolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import sge.dispositivo.Dispositivo;
import sge.helperClass.*;
import sge.usuario.*;

public class SimplexJob {
	private int rangoEjecucionSegs = 0;
	private Cliente unUsuario;
	private boolean enEjecucion = false;
	private TimerTask Job;
	

	public SimplexJob(Cliente unUsuario) {
		this.unUsuario = unUsuario;

	}
	
	public SimplexJob(int unRangoDeEjecucion, Cliente unUsuario) {
		this.rangoEjecucionSegs = unRangoDeEjecucion;
		this.unUsuario = unUsuario;
	}
	
	public long getRangoEjecucionSegs() {
		return rangoEjecucionSegs;
	}

	public void setRangoEjecucionSegs(int rangoEjecucionSegs) {
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
					
					System.out.println("Deberia consumir: " + solucion.getPoint()[inicio] + "kWh," 
						+ " pero esta consumiendo: " + dispositivo.getConsumoKwH() + "kWh.");
					dispositivosSobrepasados.add(dispositivo);
				}
				inicio=inicio+1;
			}
		}
		
		System.out.println("El valor optimo en horas que el usuario estara consumiendo: " + solucion.getValue());
		
		inicio = 0;
		for (Dispositivo dispositivo : dispositivosSeleccionados){
			if (inicio < dispositivosSeleccionados.size()){
					System.out.println("Las horas de uso de " + dispositivo.getPropiedad() + " deberian ser: "
							+ solucion.getPoint()[inicio]);
				inicio=inicio+1;
			}
		}
		System.out.println("FIN --------------");
		//this.setTerminarEjecucion();	
		return solucion;
	}
	
	
	public void setTerminarEjecucion() {
		enEjecucion = false;
	}
	
	public void comenzarEjecucion() {
		enEjecucion = true;
		Timer timer = new Timer();
		this.Job = new TimerTask() {

		@Override
		public void run() {
			try {
				ejecutarPeticion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		};
		};
		timer.schedule(Job, 3, 36000);
		
	}
	
	public boolean devolverEstado() {
		return enEjecucion;
	}
	
}