import java.util.StringTokenizer;
import java.io.*;
public class Program7 {
	public static void main(String[] args) throws IOException {
		try {
			FileReader file = new FileReader("C:\\Users\\CSE\\eclipse-workspace\\78NPLab\\src\\urls.txt");
			BufferedReader reader = new BufferedReader(file);
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int count = 0;
			while(st.hasMoreTokens())
			{
				count = 0;
				for(String s: st.nextToken().split("\\?")[1].split("\\=")) {
					if(count == 0)
						System.out.println("Key: " + s);
					else
						System.out.println("Value: " + s);
					count = 1-count;
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
