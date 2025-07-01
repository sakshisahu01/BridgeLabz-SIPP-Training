package Inheritance;

class Course{
	String course_name;
	int duration;
	
	Course(String course_name, int duration){
		this.course_name=course_name;
		this.duration=duration;
		
	}
	void displayinfo() {
		System.out.println("course_name" + course_name);
		System.out.println("the duration"+duration);
		
		
	}
}
class OnlineCourse extends Course{
	String platform;
	int recorded;
	
	OnlineCourse(String course_name, int duration, String platform, int recorded){
		super(course_name, duration);
		this.platform=platform;
		this.recorded=recorded;
		
	}
	void displayinfo() {
		System.out.println("platform" + platform);
		System.out.println("recorded"+recorded);
	}
	
	
}
class PaidOnlineCourse extends OnlineCourse{
	int fee;
	int discount;
	
	PaidOnlineCourse(String couse_name, int duration, String platform, int recorded, int fee, int discount){
		super(couse_name,duration,platform,recorded);
		this.fee=fee;
		this.duration=duration;
	}
	void displayinfo() {
		System.out.println("fee"+ fee);
		System.out.println("duration" + duration);
	}

}
public class EducationCourseHiearchy {
    public static void main(String[] args) {
        PaidOnlineCourse pos=new PaidOnlineCourse("Java", 4, "GeeksForGeeks", 15, 3000, 10);
        pos.displayinfo();
        
    }
	
    
    
}	


