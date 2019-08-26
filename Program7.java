import java.util.StringTokenizer;
import java.io.*;
class Program7 {
    public static void main(String args[]) {
        try {
            FileReader file = new FileReader("/home/trinity/IdeaProjects/NP Lab/src/urls.txt");
            BufferedReader reader = new BufferedReader(file);
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int count = 0;
            while(st.hasMoreTokens())
            {
                count++;
                String s = new String(st.nextToken());
                int queIndex = s.indexOf('?');
                if(queIndex != -1) {
                    String queryString = s.substring(queIndex+1);
                    while(queryString.indexOf('&') != -1) {
                        String query = queryString.substring(0, queryString.indexOf('&'));
                        System.out.printf("%s\n", query);
                        queryString = queryString.substring(queryString.indexOf('&')+1);
                    }
                    System.out.printf("%s\n", queryString);
                }
            }
            System.out.printf("Count of urls = %d", count);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
