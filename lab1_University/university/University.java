package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
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
	
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		
		this.name = name;
		this.students = new Student[MAX_STUDENTS_UNIVERSITY];
		this.courses = new Course[MAX_COURSES_UNIVERSITY];
	
	}
	
	/**
	 * Getter for the name of the university
	 * 
	 * @return name of university
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		this.rector = first + " " + last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return name of the rector
	 */
	public String getRector(){
		
		return this.rector;
	}
	
	/**
	 * Enrol a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * 
	 * @return unique ID of the newly enrolled student
	 */
	public int enroll(String first, String last){
		
		Student stud = new Student(first, last, this.last_student_id);
		this.students[last_student_id - STUDENT_ID_OFFSET] = stud;
		return last_student_id++;
	
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the ID of the student
	 * 
	 * @return information about the student
	 */
	public String student(int id){
		
		int idx = id - STUDENT_ID_OFFSET;
		
		if (id < STUDENT_ID_OFFSET ||id > this.last_student_id + STUDENT_ID_OFFSET) { //ERROR!!!!!!!!!!!!
			
			return "Student id should not exceed " + (this.last_student_id - 1);	
		}
		else {
			return this.students[idx].toString();
		}
		
	}
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * 
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		
		Course c = new Course(last_course_code, title, teacher);
		this.courses[last_course_code - COURSE_CODE_OFFSET] = c;
		return last_course_code++;
	}
	
	/**
	 * Retrieve the information for a given course.
	 * 
	 * The course information is formatted as a string containing 
	 * code, title, and teacher separated by commas, 
	 * e.g., {@code "10,Object Oriented Programming,James Gosling"}.
	 * 
	 * @param code unique code of the course
	 * 
	 * @return information about the course
	 */
	public String course(int code){
		int idx = code - COURSE_CODE_OFFSET;
		
		if (code < COURSE_CODE_OFFSET ||code > this.last_course_code+ COURSE_CODE_OFFSET) { 
			
			return "Course code should not exceed " + (this.last_course_code - 1);	
		}
		else {
			return this.courses[idx].toString();
		}
		
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		
		courses[courseCode-COURSE_CODE_OFFSET].addStudent(students[studentID-STUDENT_ID_OFFSET]);
		
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
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
		//comment
	}

	/**
	 * Retrieves the study plan for a student.
	 * 
	 * The study plan is reported as a string having
	 * one course per line (i.e. separated by '\n').
	 * The courses are formatted as describe in method {@link #course}
	 * 
	 * @param studentID id of the student
	 * 
	 * @return the list of courses the student is registered for
	 */
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
