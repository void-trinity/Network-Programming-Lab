package Program12;

import java.io.*;
import java.net.*;
public class Program12Server {
    public static double operation(String operator) {
        System.out.println("Sending Result");
        switch (operator) {
            case "+": return (2+3);
            case "-": return (2-3);
            case "*": return (2*3);
            case "/": return (double) 2/3;
            default: return 0.0;
        }
    }
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(9999);
            socket = server.accept();
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            String message = fromClient.readLine();
            System.out.println("Connection Made");
            System.out.println("Addition: 2+3");
            toClient.writeBytes("" + operation("+") + "\n");
            System.out.println("Multiplication: 2*3");
            toClient.writeBytes("" + operation("*") + "\n");
            System.out.println("Subtraction: 2-3");
            toClient.writeBytes("" + operation("-") + "\n");
            System.out.println("Division: 2/3");
            toClient.writeBytes("" + operation("/") + "\n");
            System.out.println("Closing Connection");
            toClient.writeBytes("Bye");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
