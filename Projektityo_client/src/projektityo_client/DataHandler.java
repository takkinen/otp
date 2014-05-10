/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo_client;

/**
 *
 * @author henri
 */
public class DataHandler {
    
    public static int getObservatorID() {
        // TODO
        return 1234567890;
    }
    
    public static GeoPoint getGeoPoint() {
        try {
            GeoPoint geoPoint = new GeoPoint(23156789, 62493658);
            return geoPoint;
        } catch (Exception ex) {
            //
        }
        return null;
        
    }
    
    
}
