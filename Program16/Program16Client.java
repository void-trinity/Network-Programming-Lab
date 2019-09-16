package Program16;

import java.io.IOException;
import java.net.*;

public class Program16Client {
    public static void main(String args[]) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            String sentence = "Hello World From Client";
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6666);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            int count = 1;
            while(count < 5) {
                clientSocket.receive(receivePacket);
                String message = new String(receivePacket.getData()).trim();
                System.out.println("FROM SERVER: " + message);
                count++;
            }
            clientSocket.close();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}