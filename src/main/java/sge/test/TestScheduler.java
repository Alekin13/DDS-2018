package sge.test;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import sge.simplexSolver.SimplexJob;

public class TestScheduler {
	 
	 public static void main(String[] args) {
		
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
	        
	}
}
