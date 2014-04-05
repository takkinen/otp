/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlreader;

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
    private final int latitudeE6;  // <latitudeE6>60.170833</latitudeE6>
    private final int longitudeE6; // <longitudeE6>24.9375</longitudeE6>
    private final String species; // toteutetaan tietokantaa hyväksi käyttäen.

    public BirdObservation(int observerID, Date date, Time time, int latitudeE6, int longitudeE6, String species) {
        this.observerID = observerID;
        this.date = date;
        this.time = time;
        this.latitudeE6 = latitudeE6;
        this.longitudeE6 = longitudeE6;
        this.species = species;
    }

    @Override
    public String toString() {
        return observerID + "\n"
                + date + "\n"
                + time + "\n"
                + latitudeE6 + "\n"
                + longitudeE6 + "\n"
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

    public int getLatitudeE6() {
        return latitudeE6;
    }

    public int getLongitudeE6() {
        return longitudeE6;
    }

    public String getSpecies() {
        return species;
    }
} // class BirdObservation
