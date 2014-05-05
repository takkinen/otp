/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo;

/**
 *
 * @author henri
 */
public class BirdObservationBuilder {
    
    private int latit;
    private int longit;
    
    public BirdObservationBuilder() {}
    
    public void setCurrentGeoPoint(int latit, int longit) {
        
    }
    
    public GeoPoint getCurrentGeoPoint() {
        // Get coordinates
        
        int latit = 24965714;
        int longit = 64812394;
        try {
        GeoPoint gp = new GeoPoint(latit, longit);
        return gp;
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        return null;
    }
    
    
    
}
