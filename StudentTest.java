public class StudentTest
{
	public static void main(String[] args)
	{
		Student student1 = new Student("Kingsley", 90.8);
		Student student2 = new Student("Oteng", 70.6);
		
		System.out.printf("%s's letter grade is: %s%n", student1.getName(), student1.getLetterGrade());
		System.out.printf("%s's letter grade is: %s%n", student2.getName(), student2.getLetterGrade());
	}
}