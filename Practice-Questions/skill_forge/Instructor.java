package com.skill_forge;

public class Instructor extends User {

	public Instructor(int id, String name, String email) {
		super(id, name, email);
	}
	
	public void uploadCourse(Course course) {
		System.out.println("Course uploaded" + course.getTitle());
	}
	
}
