import java.util.Scanner;
import java.io.*;

public class Program6 {
	public static void main(String[] args) throws IOException {
		try {
			FileReader file = new FileReader("C:\\Users\\CSE\\eclipse-workspace\\78NPLab\\src\\Program6.txt");
			BufferedReader reader = new BufferedReader(file);
			Scanner sc = new Scanner(reader.readLine());
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
			
			reader.close();
			sc.close();
			System.out.printf("String Count: %d, Int Count: %d, Float Count: %d, Bool Count: %d", stringCount, intCount, floatCount, boolCount);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//BufferedReader reader = new BufferedReader(new FileReader(filePath + "/src/ProgramCount"));
	}
}
