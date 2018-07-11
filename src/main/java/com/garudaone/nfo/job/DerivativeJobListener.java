package com.garudaone.nfo.job;

import org.joda.time.DateTime;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import java.util.List;

public class DerivativeJobListener implements JobExecutionListener {

    private DateTime startTime, endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = new DateTime();
        System.out.println("Derivative Job started at " + startTime);

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = new DateTime();
        System.out.println("Derivative Job completed at " + endTime);
        System.out.println("Total time taken in milliseconds is " + (endTime.getMillis() - startTime.getMillis() ));

        if(jobExecution.getStatus() == BatchStatus.COMPLETED)
            System.out.println("Job Completed Successfully..");
        if(jobExecution.getStatus() == BatchStatus.FAILED)
        {
            System.out.println("Job Failed with the following exception ");
            List<Throwable> exceptionlist = jobExecution.getAllFailureExceptions();
            for(Throwable th : exceptionlist)
                System.out.println("Exception : " + th.getLocalizedMessage());
        }
    }
}
