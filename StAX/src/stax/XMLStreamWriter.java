/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kone3
 */
public class XMLStreamWriter {

    public static void main(String[] args) {

        String string = "<birdobservation>\n"
                + "    <date>2014-04-04</date>\n"
                + "    <time>10:11:22</time>\n"
                + "    <latitudeE6>60135476</latitudeE6>\n"
                + "    <longitudeE6>24948736</longitudeE6>\n"
                + "    <species>crow</species>\n"
                + "    <observerID>349283</observerID>\n"
                + "</birdobservation>";

        try (
                Socket socket = new Socket("localhost", 6543);
                OutputStream out = socket.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));) {

            for (int i = 0; i < 1; i++) { // yksi kerta
                bufferedWriter.write(string);
                bufferedWriter.flush();
                System.out.println(string);
                //TimeSteeler timesteeler = new TimeSteeler(100000);
            }

        } catch (IOException ex) {
            Logger.getLogger(XMLStreamWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
