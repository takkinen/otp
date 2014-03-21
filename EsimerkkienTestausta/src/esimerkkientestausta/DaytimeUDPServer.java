/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkkientestausta;

/**
 *
 * Elliotte Rusty Harold
 * Java Network Programming, 4th Edition
 */
import java.net.*;
import java.util.Date;
import java.util.logging.*;
import java.io.*;

public class DaytimeUDPServer {

    private final static int PORT = 13;
    private final static Logger audit = Logger.getLogger("requests");
    private final static Logger errors = Logger.getLogger("errors");

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);
                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("US-ASCII");
                    DatagramPacket response = new DatagramPacket(data, data.length,
                            request.getAddress(), request.getPort());
                    socket.send(response);
                    audit.info(daytime + " " + request.getAddress());
                    //* Tämän voi tehdä näinkin..  */
                    //audit.log(Level.INFO, "{0} {1}", new Object[]{daytime, request.getAddress()});
                } catch (IOException | RuntimeException ex) {
                    errors.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (IOException ex) {
            errors.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
