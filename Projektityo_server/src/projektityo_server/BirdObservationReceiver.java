/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektityo_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henri
 */
public class BirdObservationReceiver {

    private static final int SERVER_SOCKET = 7890;
    //private static final int SHUTDOWN_SOCKET = 53947;
    private static boolean SERVICE_ON;
    private static Socket socketData;
    private static Socket socketAdmin;
    private static ServerSocket serverSocketXML;
    private static ServerSocket serverSocketShutDown;
    private static final String STOP_SERVICE = "shutdownnow";

    public static void main(String[] args) {
        System.out.println("BirdObservationReceiver:\n");
        SERVICE_ON = true;
        XMLBuilder xmlBuilder = new XMLBuilder();

        try {
            serverSocketXML = new ServerSocket(SERVER_SOCKET);
            System.out.println("ServerSocket alustettu.");
        } catch (IOException ex) {
            Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            SERVICE_ON = false;
        }

        /*
         try {
         serverSocketShutDown = new ServerSocket(SHUTDOWN_SOCKET);
         System.out.println("ShutDownSocket alustettu.");
         } catch (IOException ex) {
         Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
        // SERVICE_ON = true, if serverSocketXML exists.
        while (SERVICE_ON) {

            try {
                socketData = serverSocketXML.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socketData.getInputStream()));
                String message = "";
                String string;

                while ((string = in.readLine()) != null) {
                    if (string.equals(STOP_SERVICE)) {
                        SERVICE_ON = false;
                    }
                    message += string; // lisätään luettu rivi ko. viestiin
                    System.out.println(string);
                    xmlBuilder.addString(string);
                    // XMLBuilder-toiminnallisuus

                }
                //xmlBuilder.xmlRecordReady();

                //System.out.println("-2-");
            } catch (IOException ex) {
                Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }

            // tarkistetaan, ettei tarvitse sammuttaa palvelua
            /*
             try {
             socketAdmin = serverSocketShutDown.accept();
             System.out.println("-1-");
             BufferedReader in = new BufferedReader(new InputStreamReader(socketAdmin.getInputStream()));
             String string;
             while ((string = in.readLine()) != null) {
             System.out.println(string);
             if (string.equals(STOP_SERVICE)) {
             SERVICE_ON = false;
             }

             }
             } catch (IOException ex) {
             Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
             }
             */
        }
    }
}

/*
 ServerSocket server = new ServerSocket(port);
 while (true) {
 try (Socket connection = server.accept()) {
 Writer out = new OutputStreamWriter(connection.getOutputStream());
 Date now = new Date();
 out.write(now.toString() +"\r\n");
 out.flush();
 } catch (IOException ex) {
 // problem with one client; don't shut down the server
 Using ServerSockets
 www.it-ebooks.info
 |
 285
 System.err.println(ex.getMessage());
 }
 }

 */
