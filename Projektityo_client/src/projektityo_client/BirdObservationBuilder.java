/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo_client;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author henri
 */
public class BirdObservationBuilder {
    
    private GeoPoint geoPoint;
    private int observerID = 0000000000;
    private String species;
    private Date date;
    private Time time;
    DataHandler dataHandler;
    
    public BirdObservationBuilder() {}
    
    public void defineCurrentGeoPoint() {
        //
        geoPoint = DataHandler.getGeoPoint();
    }
    
    public void setCurrentObserverID(int id) {
        observerID = id;
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
    
    public void setCurrentDate() {
        date = new Date(System.currentTimeMillis());
    }
    
    public void setCurrentTime() {
        time = new Time(System.currentTimeMillis());
    }
    
    public void createBirdObservation() {
        if (geoPoint == null) { return; }
        if (observerID <= 0) { return; }
        if (date == null) { return; }
        if (time == null) { return; }
        if (species.length() > 0) {
            BirdObservation birdObservation = new BirdObservation(observerID, date, time, geoPoint, species);
            BirdObservationSender.sendBirdObservation(birdObservation);
            System.out.println(birdObservation.toXML());
            
        }
    }
    
    /*
    public int getCurrentObserverID() {
        return observerID;
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
    */
    
    
    
    
    
}
