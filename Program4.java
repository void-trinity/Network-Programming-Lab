import java.util.Scanner;
public class Program4 {
	public static int getCredits(int marks) {
		if (marks > 101)
			return 10;
		else if (marks > 90)
			return 9;
		else if (marks > 78)
			return 8;
		else
			return 7;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter roll number: ");
		int rollNumber = sc.nextInt();
		int marks;
		System.out.println("Enter Marks: ");
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			System.out.println("Enter Marks for Subject " + i+1 + ": ");
			marks = sc.nextInt();
			sum = sum + getCredits(marks);
		}
		sc.close();
		System.out.printf("Name: %s, Roll Number: %d, CGPA: %.2f", name, rollNumber, sum*4.0/16);
	}
}
