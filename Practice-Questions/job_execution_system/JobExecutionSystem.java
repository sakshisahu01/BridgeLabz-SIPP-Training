package com.job_execution_system;

public class JobExecutionSystem {
	public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();

        scheduler.addJob(new DataSyncJob());
        scheduler.addJob(new EmailAlertJob());
        scheduler.addJob(new CleanUpJob());

        scheduler.runJobs();
    }
}
