import java.util.Scanner;
public class Program3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("My name  1  2   3.56 is   Siddharth true");
		int intCount = 0, stringCount = 0, floatCount = 0, boolCount = 0;
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				intCount++;
			}
			else if(sc.hasNextDouble()) {
				floatCount++;
			}
			else if(sc.hasNextBoolean()) {
				boolCount++;
			}
			else {
				stringCount++;
			}
			sc.next();
		}
		sc.close();
		System.out.printf("String Count: %d, Int Count: %d, Float Count: %d, Bool Count: %d", stringCount, intCount, floatCount, boolCount);
	}
}
