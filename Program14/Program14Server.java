package Program14;

import java.io.*;
import java.net.*;

public class Program14Server {
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
            System.out.println("Addition: 2+3");
            sendData = (operation("+")+"").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            datagramSocket.send(sendPacket);
            System.out.println("Multiplication: 2*3");
            sendData = (operation("*")+"").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            datagramSocket.send(sendPacket);
            System.out.println("Subtraction: 2-3");
            sendData = (operation("-")+"").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            datagramSocket.send(sendPacket);
            System.out.println("Division: 2/3");
            sendData = (operation("/")+"").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            datagramSocket.send(sendPacket);
        } catch(SocketException e) {
            e.printStackTrace();
        } catch(
                IOException e) {
            e.printStackTrace();
        }
    }
}
