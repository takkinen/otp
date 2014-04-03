/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stax;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author kone3
 */
public class BirdObservation {
    private final Date date;
    private final Time time;
    private final int latitudeE6;
    private final int longitudeE6;
    private final String species;
    private final int observerID;

    public BirdObservation(Date date, Time time, int latitudeE6, int longitudeE6, String species, int observerID) {
        this.date = date;
        this.time = time;
        this.latitudeE6 = latitudeE6;
        this.longitudeE6 = longitudeE6;
        this.species = species;
        this.observerID = observerID;
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

    public int getObserverID() {
        return observerID;
    }
    
    
    
}

/*
<birdobservation>
    <date>2014-04-04</date>
    <time>10:11:22</time>
    <latitudeE6>60135476</latitudeE6>
    <longitudeE6>24948736</longitudeE6>
    <species>crow</species>
    <observerID>349283</observerID>
</birdobservation>
*/
