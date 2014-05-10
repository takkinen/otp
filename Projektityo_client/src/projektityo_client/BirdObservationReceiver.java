/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektityo_client;

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
    private static boolean SERVICE_ON;
    private static Socket socket;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        System.out.println("BirdObservationReceiver:\n");
        SERVICE_ON = true;

        try {
            serverSocket = new ServerSocket(SERVER_SOCKET);
        } catch (IOException ex) {
            Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            SERVICE_ON = false;
        }
        
        // SERVICE_ON = true, if serverSocket exists.
        while (SERVICE_ON) {

            try {
                socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string;

                while ((string = in.readLine()) != null) {
                    System.out.println(string);

                }
            } catch (IOException ex) {
                Logger.getLogger(BirdObservationReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
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
