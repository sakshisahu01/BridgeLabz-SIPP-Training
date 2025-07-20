package com.job_execution_system;

public class CleanUpJob implements IExecutable {

	@Override
	public void execute() {
		System.out.println("Cleaning up temporary files...");

	}

}
