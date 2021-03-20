package university;

public class University {
	
	public static final int MAX_STUDENTS_UNIVERSITY = 1000;
	public static final int MAX_COURSES_UNIVERSITY = 50;
	public static final int STUDENT_ID_OFFSET = 10000;
	public static final int COURSE_CODE_OFFSET = 10;
	public static final int MAX_STUDENTS_IN_COURSE = 100;
	public static final int MAX_COURSES_PER_STUDENT = 50;
	
	private int last_student_id = STUDENT_ID_OFFSET;
	private int last_course_code = COURSE_CODE_OFFSET;
	
	private String name;
	private String rector;
	
	private Student[] students;
	private Course[] courses;
	
	
	public University(String name){
		
		this.name = name;
		this.students = new Student[MAX_STUDENTS_UNIVERSITY];
		this.courses = new Course[MAX_COURSES_UNIVERSITY];
	
	}
	

	public String getName(){

		return this.name;
	
	}
	

	public void setRector(String first, String last){
	
		this.rector = first + " " + last;
	
	}
	
	
	public String getRector(){
		
		return this.rector;
	
	}
	
	
	public int enroll(String first, String last){
		
		Student stud = new Student(first, last, this.last_student_id);
		this.students[last_student_id - STUDENT_ID_OFFSET] = stud;
		return last_student_id++;
	
	}
	
	
	public String student(int id){
		
		int idx = id - STUDENT_ID_OFFSET;
		
		if (id < STUDENT_ID_OFFSET ||id > this.last_student_id + STUDENT_ID_OFFSET) {
			return "Student id should not exceed " + (this.last_student_id - 1);	
		}
		else {
			return this.students[idx].toString();
		}
		
	}
	

	public int activate(String title, String teacher){
		
		Course c = new Course(last_course_code, title, teacher);
		this.courses[last_course_code - COURSE_CODE_OFFSET] = c;
		return last_course_code++;
	
	}
	
	
	public String course(int code){
		
		int idx = code - COURSE_CODE_OFFSET;
		if (code < COURSE_CODE_OFFSET ||code > this.last_course_code+ COURSE_CODE_OFFSET) { 
			return "Course code should not exceed " + (this.last_course_code - 1);	
		}
		else {
			return this.courses[idx].toString();
		}
		
	}
	
	
	public void register(int studentID, int courseCode){
		
		courses[courseCode-COURSE_CODE_OFFSET].addStudent(students[studentID-STUDENT_ID_OFFSET]);
		
	}
	
	
	public String listAttendees(int courseCode){
		
		Student[] students_list = new Student[MAX_STUDENTS_IN_COURSE];
		students_list = this.courses[courseCode-COURSE_CODE_OFFSET].getStudents();
		String final_list = "";
		
		for(Student stud: students_list) {
			if (stud != null) {
			final_list = final_list + stud.toString() + "\n";
			}
		}
		
		return final_list;

	}

	
	public String studyPlan(int studentID){

		Course[] courses_list = new Course[MAX_COURSES_PER_STUDENT];
		courses_list = this.students[studentID-STUDENT_ID_OFFSET].getCourses();
		String final_list = "";
		
		for(Course c: courses_list) {
			if (c != null) {
			final_list = final_list + c.toString() + "\n";
			}
		}
		
		return final_list;
	
	}

}
