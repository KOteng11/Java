public class Student
{
	private String name;
	private double average;
	
	// constructor initializes instance variables
	public Student(String name, double average)
	{
		this.name = name;
		// validate that average is > 0.0 and <= 100.0 otherwise,
		// keep instance variable average's default value (0.0);
		if (average > 0.0 && average <= 100)
			this.average = average;
	}
	
	// Set student name
	public void setName(String name)
	{
		this.name = name;
	}
	
	// Get student name
	public String getName()
	{
		return name;
	}
	
	// Set student average
	public void setAverage(double average)
	{
		// validate that average is > 0.0 and <= 100.0 otherwise,
		// keep instance variable average's default value (0.0);		
		if (average > 0.0 && average <= 100)
			this.average = average;
	}
	
	// Get student average
	public double getAverage()
	{
		return average;
	}
	
	// determines and return the Student's letter grade
	public String getLetterGrade()
	{
		String letterGrade = "";	// initialized to empty String
		
		if (average >= 90.0)
			letterGrade = "A";
		else if (average >= 80.0)
			letterGrade = "B";
		else if (average >= 70.0)
			letterGrade = "C";
		else if (average >= 60.0)
			letterGrade = "D";
		else
			letterGrade = "F";
		
		return letterGrade;

	}
}