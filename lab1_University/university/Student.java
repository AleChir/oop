package university;

public class Student {
	
	private String first;
	private String last;
	private int id;
	private Course[] courses;
	private int course_idx = 0;
	

	public Student(String first, String last, int id) {

		this.first = first;
		this.last = last;
		this.id = id;
		this.courses = new Course[University.MAX_COURSES_PER_STUDENT];
	
	}


	public int getId() {
	
		return id;
	
	}

	
	public void addCourse(Course course) {
	
		courses[course_idx++] = course;
	
	}

	
	@Override
	public String toString() {
	
		return this.id + " " + this.first + " " + this.last;
	
	}


	public Course[] getCourses() {
	
		return courses;
	
	}
	
}
