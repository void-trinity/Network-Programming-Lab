package Program12;

import java.io.*;
import java.net.*;
public class Program12Client {
    public static void main(String args[]) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 9999);
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = "Hello World!\n";
            toServer.writeBytes(message);
            String receivedMessage = fromServer.readLine();
            System.out.println("Received Message: " + receivedMessage);
            while(true) {
                message = fromServer.readLine();
                if(message.trim().equals("Bye"))
                    break;
                System.out.println(message);
            }
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
