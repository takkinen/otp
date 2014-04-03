/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stax;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author kone3
 */
public class LocalPortScanner {
    public static void main(String[] args) {
        int serverports = 0;
        for (int port = 1; port<65536; port++) {
            try {
                ServerSocket serrverSocket = new ServerSocket(port);
            } catch (IOException ioex) {
                System.out.println("There is a server on port " + port + ".");
                serverports++;
            }
        }
        System.out.println("Count of serverports: " + serverports);
    }
    
    
}
