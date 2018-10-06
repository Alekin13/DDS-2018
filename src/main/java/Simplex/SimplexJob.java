package Simplex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import Dispositivo.Dispositivo;
import Usuario.*;

public class SimplexJob {

	private Cliente cliente;
	private TimerTask Job;

	public SimplexJob(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public PointValuePair ejecutarPeticion() throws FileNotFoundException, IOException {
	
		int inicio = 0;
		
		SimplexHelper helper = new SimplexHelper();
		
		List<Dispositivo> dispositivosSeleccionados = new ArrayList<Dispositivo>();
		List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
		
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
	
		dispositivosSeleccionados.addAll(helper.filtrarDispositivoHeladera(cliente));	
	
		helper.generarFuncionEconomica(dispositivosSeleccionados, simplexFacade);
		helper.setearLimiteConsumoMensual(dispositivosSeleccionados, simplexFacade);
		helper.setearRestriccionesConsumo(dispositivosSeleccionados, simplexFacade);
		
		PointValuePair solucion = simplexFacade.resolver();
	
		for (Dispositivo dispositivo : dispositivosSeleccionados){
			if (inicio < dispositivosSeleccionados.size()){
				if (solucion.getPoint()[inicio] <= dispositivo.getConsumoKwH()){ /* consumo */
					
					System.out.println("Deberia Consumir: " + solucion.getPoint()[inicio] + "kWh," + " pero esta consumiendo: " + dispositivo.getConsumoKwH() + "kWh.");
					dispositivosSobrepasados.add(dispositivo);
				}
				
				inicio = inicio + 1;
			}
		}
		
		System.out.println("El valor Optimo en horas que el usuario estara consumiendo: " + solucion.getValue());
		
		inicio = 0;
		for (Dispositivo dispositivo : dispositivosSeleccionados){
			if (inicio < dispositivosSeleccionados.size()){
					System.out.println("Las horas de uso de " + dispositivo.getNombreDispositivo() + " deberian ser: " + solucion.getPoint()[inicio]);
				inicio = inicio + 1;
			}
		}
		
		System.out.println("FIN ---------------------------------------------------------------------------------");

		return solucion;
	
	}
	
	
	public void comenzarEjecucion() {
	
		Timer timer = new Timer();
		this.Job = new TimerTask() {
	
			@Override
			public void run(){
				try{ejecutarPeticion();
				} 
			catch(IOException e){
				e.printStackTrace();
				}
			};
		};
	
		timer.schedule(Job, 3, 36000);
	}
	
}