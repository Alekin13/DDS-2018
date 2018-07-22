package sge.simplexSolver;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimplexJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//Acá se ejecutaria el simplex
		
		System.out.println("ejecuto Simplex");
		
	}

}
