/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stax;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kone3
 */
public class TimeSteeler implements Runnable {
    long timeout;
    
    public TimeSteeler(long timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            wait(timeout);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeSteeler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
