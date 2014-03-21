/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkkientestausta;

/**
 * Original code by:
 * Elliotte Rusty Harold
 * Java Network Programming, 4th Edition
 */
import java.io.*;
import java.net.*;

public class DaytimeUDPClient {

    private final static int PORT = 5000;
    // private static final String HOSTNAME = "time.nist.gov";
    private static final String HOSTNAME = "HP-MicroServer.wetcoat";

    public static void main(String[] args) {
        System.out.println("Lähteekö ohjelma käyntiin...");
        for (int i=0;i<5;i++) {
        try (DatagramSocket socket = new DatagramSocket(0)) {
            socket.setSoTimeout(5000);
            
            InetAddress host = InetAddress.getByName(HOSTNAME);
            System.out.println(host.toString());
            
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
            System.out.println(request.toString());
            
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            System.out.println(response.toString());
            
            long starttime = System.nanoTime();
            socket.send(request);
            System.out.println("Request send.");
            
            socket.receive(response);
            System.out.println("Request received");
            long takentime = System.nanoTime() - starttime;
            System.out.println("It took " + takentime/1000000 + "ms to get the answer");
            
            String result = new String(response.getData(), 0, response.getLength(),
                    "US-ASCII");
            System.out.println(result);
        } catch (IOException ex) {
            System.err.println("Jokin meni pieleen..");
        }
        }
    }
}

/*  -J-Djava.net.preferIPv4Stack=true
* https://www.java.net/node/703177
* jos ongelmia. 
*/