/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.util.StreamReaderDelegate;

/**
 *
 * @author henri
 */
public class BirdObservationReceiver {
    
    public static void main(String[] args) {
        
        
        try (ServerSocket serverSocket = new ServerSocket(7890);
                Socket socket = serverSocket.accept()) {
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
