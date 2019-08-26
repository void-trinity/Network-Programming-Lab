import java.util.StringTokenizer;
import java.io.*;
public class Program8 {
    public static void main(String[] args) throws IOException {
        try {
            FileReader file = new FileReader("/home/trinity/IdeaProjects/NP Lab/src/urls.txt");
            BufferedReader reader = new BufferedReader(file);
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int count = 0;
            while(st.hasMoreTokens())
            {
                count++;
                for(String s: st.nextToken().split("\\?")[1].split("\\&")) {
                    System.out.printf("%s\n", s);
                }
            }
            System.out.printf("Count of urls = %d", count);
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
