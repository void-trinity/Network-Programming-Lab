package Program15;

import java.net.*;
import java.io.*;

public class Program15Server {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected to client");
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());

                ClientHandler t = new ClientHandler(socket, fromClient, toClient);
                t.start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ClientHandler extends Thread {
    final BufferedReader DIS;
    final DataOutputStream DOS;
    final Socket SOCKET;

    public ClientHandler(Socket s, BufferedReader dI, DataOutputStream dO) {
        this.SOCKET = s;
        this.DIS = dI;
        this.DOS = dO;
    }

    public double operation(String operator) {
        System.out.println("Sending Result");
        switch (operator) {
            case "+": return (2+3);
            case "-": return (2-3);
            case "*": return (2*3);
            case "/": return (double) 2/3;
            default: return 0.0;
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection Made");
            System.out.println("Addition: 2+3");
            this.DOS.writeBytes("" + operation("+") + "\n");
            System.out.println("Multiplication: 2*3");
            this.DOS.writeBytes("" + operation("*") + "\n");
            System.out.println("Subtraction: 2-3");
            this.DOS.writeBytes("" + operation("-") + "\n");
            System.out.println("Division: 2/3");
            this.DOS.writeBytes("" + operation("/") + "\n");
            System.out.println("Closing Connection");
            this.DOS.writeBytes("Bye");
            this.SOCKET.close();
            this.DIS.close();
            this.DOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}