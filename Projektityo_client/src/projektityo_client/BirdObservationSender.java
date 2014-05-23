/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektityo_client;

import java.io.IOException;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author henri
 */
public class BirdObservationSender {

    public static int SOCKET = 7890;

    public static void sendBirdObservation(BirdObservation bo) throws IOException {
        Socket socket = new Socket("localhost", 7890);
        Writer out = new OutputStreamWriter(
                socket.getOutputStream(), "UTF-8");
        out.write(bo.toXML());
        out.flush();
        socket.shutdownOutput();
        /*
         try (Socket socket = new Socket("localhost", 7890)) {
         Writer out = new OutputStreamWriter(
         socket.getOutputStream(), "UTF-8");
         out.write(bo.toXML());
         out.flush();
         socket.shutdownOutput();
         } catch (IOException ioex) {
         ioex.printStackTrace();
         }
         */

    }

}


/*
try (Socket connection = new Socket("www.oreilly.com", 80)) {
Writer out = new OutputStreamWriter(
connection.getOutputStream(), "8859_1");
out.write("GET / HTTP 1.0\r\n\r\n");
out.flush();
connection.shutdownOutput();
// read the response...
} catch (IOException ex) {
ex.printStackTrace();
}
*/
