package com.job_execution_system;

import java.util.LinkedList;
import java.util.Queue;

public class JobScheduler {
	private Queue<IExecutable> jobQueue;
	
	public JobScheduler() {
		this.jobQueue = new LinkedList<>();
	}
	
	public void addJob(IExecutable job) {
		jobQueue.add(job);
	}
	
	public void runJobs() {
        while (!jobQueue.isEmpty()) {
            IExecutable job = jobQueue.poll();
            job.execute(); // Polymorphic behavior
        }
    }
}
