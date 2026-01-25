import java.security.SecureRandom;

abstract class Person
{
	private String name;
	private int age;
	private String course;
	
	public Person(String name, int age, String course)
	{
		this.name = name;
		this.age = age;
		this.course = course;
	}
	
	// set the person's name
	public void setName(String name){this.name = name;}
	
	// get the person's name
	public String getName(){return name;}
	
	// set the person's age
	public void setAge(int age){this.age = age;}
	
	// get the person's age
	public int getAge(){return age;}
	
	// set the person's course
	public void setCourse(String course){this.course = course;}
	
	// get the person's course
	public String getCourse(){return course;}
	
	
	// Abstract method displayInfo
	public abstract void displayInfo();
}

class Student extends Person
{
	private int studentId;

	public Student(String name, int age, String course)
	{
		super(name, age, course);
		
		SecureRandom rand = new SecureRandom();
		studentId = 100 + rand.nextInt(999999);
	}
	
	// get the student's id
	public int getStudentId(){return studentId;}
	
	@Override
	public void displayInfo()
	{
		System.out.printf("Student ID: %d%nStudent name: %s%nAge: %d%nCourse Studying: %s%n", 
			studentId, super.getName(), super.getAge(), super.getCourse());
	}
}

class Teacher extends Person
{
	private double salary;
	
	public Teacher(String name, int age, String course, double salary)
	{
		super(name, age, course);
		this.salary = salary;
	}
	
	@Override
	public void displayInfo()
	{
		System.out.printf("Student name: %s%nAge: %d%nCourse: %s%nSalary: ", 
			super.getName(), super.getAge(), super.getCourse(), salary);
	}
}

public class PersonTest
{
	public static void main(String[] args)
	{
		Student student1 = new Student("Kinglsey", 29, "Java Programming");
		student1.displayInfo();
		
		Teacher teacher1 = new Teacher("Oteng", 30, "Mathematics", 50000);
		teacher1.displayInfo();
	}
}