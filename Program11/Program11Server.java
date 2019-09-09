package Program11;

import java.io.*;
import java.net.*;
public class Program11Server {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(9999);
            socket = server.accept();
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            String message = fromClient.readLine();
            System.out.println("Message Received: " + message);
            toClient.writeBytes(message);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
