package university;


public class Course {
	
	private String name;
	private int code;
	private String professor;
	private Student[] students;
	private int numStudents = 0;
	

	public Course(int code, String name, String professor) {	
	
		this.name = name;
		this.code = code;
		this.professor = professor;
		this.students = new Student[University.MAX_STUDENTS_IN_COURSE];
	
	}
	

	public String getName() {
	
		return name;
	
	}
	
	
	public String getProfessor() {
	
		return professor;
	
	}
	

	public void addStudent(Student student) {
	
		student.addCourse(this);
		this.students[numStudents++] = student;
	
	}
	

	@Override
	public String toString() {
	
		return code + ", " + name + ", " + professor;
	
	}

	public Student[] getStudents() {
	
		return students;
	
	}

	public int getNumStudents() {
	
		return numStudents;
	
	}

}
