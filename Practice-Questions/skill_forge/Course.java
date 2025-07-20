package com.skill_forge;

public class Course {
	private String title;
	private String instructor;
	private int rating;
	private int[] modules;

	public Course() {
		this.title = "Untitled Course";
		this.instructor = "Unknown Instructor";
		this.rating = 0;
		this.modules = new int[] { 1, 2, 3, 4, 5 }; // default module IDs or sizes
	}

	public Course(String title, String instructor, int rating, int[] modules) {
		super();
		this.title = title;
		this.instructor = instructor;
		setRating(rating);
		this.modules = modules;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if (rating >= 0 && rating <= 5) {
			this.rating = rating;
		} else {
			System.out.println("Invalid Rating the rating should be between 0 to 5");
		}
	}

	public String getTitle() {
		return title;
	}

	public String getInstructor() {
		return instructor;
	}

	public int[] getModules() {
		return modules;
	}
//	
//	public String[] getReviews() {
//		return reviews.clone();
//	}

	// Polymorphic method (can be overridden)
	public String generateCertificate() {
		return "Certificate of Completion for course: " + title;
	}

}
