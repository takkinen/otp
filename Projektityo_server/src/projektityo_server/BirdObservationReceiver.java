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
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author henri
 */
public class BirdObservationReceiver implements Runnable {

    private static final int SERVER_SOCKET = 7890;
    private static boolean SERVICE_ON;
    private static Socket socketData;
    //private static Socket socketAdmin;
    private static ServerSocket serverSocketXML;
    //private static ServerSocket serverSocketShutDown;
    private static final String STOP_SERVICE = "shutdownnow";
    private String message; 

    public static void setSERVICE_ON(boolean aSERVICE_ON) {
        SERVICE_ON = aSERVICE_ON;
    }
    
    private void stopReceiving() {
        
        try {
            socketData.close();
            //socketAdmin.close();
            serverSocketXML.close();
            //serverSocketShutDown.close();
            
        } catch (IOException ex) {
            Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                        stopReceiving();
                        SERVICE_ON = false;
                    }
                    message += string; // lisätään luettu rivi ko. viestiin
                    System.out.println(string);
                    
                    // XMLBuilder-toiminnallisuus

                }
                xmlBuilder.addString(message);
                //xmlBuilder.xmlRecordReady();

                //System.out.println("-2-");
            } catch (IOException ex) {
                Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (XMLStreamException ex) {
                Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    
    
}
