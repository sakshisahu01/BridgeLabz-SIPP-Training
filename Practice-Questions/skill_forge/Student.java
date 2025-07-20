package com.skill_forge;

public class Student extends User implements ICertifiable {
	private int grade;
	private int progress;

	public Student(int id, String name, String email) {
		super(id, name, email);
		this.progress = 0;
		this.grade = 0;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	@Override
	public String generateCertificate() {
		return "Certificate awarded to: " + getName() + "with a grade: " + grade; 
	}
	
}
