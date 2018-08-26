package sge.simplexSolver;

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

public class SimplexJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//Aca se ejecutaria el simplex
		
		
		 try {
	        	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
				scheduler.start();
				
				JobDetail jobDetalle = JobBuilder.newJob(SimplexJob.class).withIdentity("SimplexJob").build();

				Trigger trigger = TriggerBuilder
						.newTrigger()
						.withIdentity("SimplexJobTrigger")
						.withSchedule(
						    SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(20).repeatForever())
						.build();
				
				scheduler.scheduleJob(jobDetalle,trigger);
				
				
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		
		System.out.println("ejecuto Simplex");
		
	}

}
