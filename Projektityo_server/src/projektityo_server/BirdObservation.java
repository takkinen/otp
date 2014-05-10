/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo_server;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author henri
 */
public class BirdObservation {

    private final int observerID; // <observerID></observerID>
    private final Date date; // <date>2014-04-01</date>
    private final Time time; // <date>2014-04-01</date>
    //private final int latitudeE6;  // <latitudeE6>60.170833</latitudeE6>
    //private final int longitudeE6; // <longitudeE6>24.9375</longitudeE6>
    GeoPoint geoPoint;
    private final String species; 

    public BirdObservation(int anObserverID, Date aDate, Time aTime, GeoPoint aGeoPoint, String aSpecies) {
        observerID = anObserverID;
        date = aDate;
        time = aTime;
        geoPoint = aGeoPoint;
        species = aSpecies;
    }

    @Override
    public String toString() {
        return observerID + "\n"
                + date + "\n"
                + time + "\n"
                + geoPoint.toString() + "\n"
                + species + "\n";
    } // toString()

    public int getObserverID() {
        return observerID;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public String getSpecies() {
        return species;
    }
    
    public String toXML() {
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" + 
        "<birdobservation> \n" +
        "   <date>" + getDate() + "</date> \n" +
        "   <time>" + getTime() + "</time> \n" +
        "   <latitudeE6>" + getGeoPoint().getLatitudeE6() + "</latitudeE6> \n" +
        "   <longitudeE6>" + getGeoPoint().getLongitudeE6() + "</longitudeE6> \n" +
        "   <species>" + getSpecies() + "</species> \n" +
        "   <observerID>" + getObserverID() + "</observerID> \n" +
        "</birdobservation> \n\n" ;
        
        return result;
    }
    
} // class BirdObservation
