package sge.simplexSolver;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import sge.usuario.Cliente;

public class SimplexJob implements Job{

	Cliente cliente = new Cliente();
	int rangoDeEjecucion;
	

	public SimplexJob(Cliente unCliente, int segundos) {
		cliente = unCliente;
		rangoDeEjecucion = segundos;
	}
	
	
	public void execute() throws JobExecutionException{
		//Aca se ejecutaria el simplex
		
		ProcesoEjecucionSimplex funcionMejora = new ProcesoEjecucionSimplex(rangoDeEjecucion, cliente);

		try {
			 	
	        	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	        	// Scheduler will not execute jobs until it has been started
	        	scheduler.start();
				
				JobDetail jobDetalle = JobBuilder.newJob(SimplexJob.class).withIdentity("SimplexJob").build();

				Trigger trigger = TriggerBuilder
						.newTrigger()
						.withIdentity("SimplexJobTrigger")
						.withSchedule(
						    SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(rangoDeEjecucion).repeatForever())
						.build();
				
				scheduler.scheduleJob(jobDetalle,trigger);
				
				
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		
		System.out.println("ejecuto Simplex");
		
		try {
			funcionMejora.ejecutarPeticion();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
	
	

}
