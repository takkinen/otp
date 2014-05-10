/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektityo_server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 *
 * @author henri
 * Luokka BirdObservationReceiver-ohjelman sammuttamiseen määrämuotoisen String-
 * merkkijonon avulla.
 */
public class StopServer {

    private static int SOCKET = 7890;
    private static final String stopService = "shutdownnow";

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", SOCKET)) {
            Writer out = new OutputStreamWriter(
                    socket.getOutputStream(), "UTF-8");
            out.write(stopService);
            out.flush();
            socket.shutdownOutput();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

    }

}
