package Program13;

import java.io.IOException;
import java.net.*;

public class Program13Server {
    public static void main(String args[]) {
        DatagramPacket datagramPacket = null;
        DatagramPacket sendPacket = null;
        DatagramSocket datagramSocket = null;
        byte[] receiveData = new byte[65536];
        byte[] sendData = new byte[65536];
        try {
            datagramSocket = new DatagramSocket(6666);
            datagramPacket = new DatagramPacket(receiveData, receiveData.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("Received: " + datagramPacket.getData());
            InetAddress clientAddress = datagramPacket.getAddress();
            int clientPort = datagramPacket.getPort();
            String sentence = "Hello World from Server";
            sendData = sentence.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            datagramSocket.send(sendPacket);
        } catch(SocketException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
