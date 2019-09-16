package Program16;

import java.net.*;
import java.io.*;

public class Program16Server {
    public static void main(String args[]) {
        DatagramPacket datagramPacket = null;
        DatagramSocket datagramSocket = null;
        byte[] receiveData = new byte[65536];
        try {
            datagramSocket = new DatagramSocket(6666);
            while(true) {
                    datagramPacket = new DatagramPacket(receiveData, receiveData.length);
                    datagramSocket.receive(datagramPacket);
                    ClientHandler clientHandler = new ClientHandler(datagramSocket, datagramPacket);
                    clientHandler.start();
                }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class ClientHandler extends Thread {
    final DatagramSocket DATAGRAMSOCKET;
    final DatagramPacket DATAGRAMPACKET;

    public ClientHandler(DatagramSocket ds, DatagramPacket dp) {
        this.DATAGRAMSOCKET = ds;
        this.DATAGRAMPACKET = dp;
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
        DatagramPacket sendPacket;
        byte[] sendData;
        try {
            InetAddress clientAddress = this.DATAGRAMPACKET.getAddress();
            int clientPort = this.DATAGRAMPACKET.getPort();
            System.out.println("Addition: 2+3");
            sendData = (operation("+") + "").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            this.DATAGRAMSOCKET.send(sendPacket);
            System.out.println("Multiplication: 2*3");
            sendData = (operation("*") + "").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            this.DATAGRAMSOCKET.send(sendPacket);
            System.out.println("Subtraction: 2-3");
            sendData = (operation("-") + "").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            this.DATAGRAMSOCKET.send(sendPacket);
            System.out.println("Division: 2/3");
            sendData = (operation("/") + "").getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            this.DATAGRAMSOCKET.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}