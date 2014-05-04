/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektityo;

/**
 *
 * @author henri Luokan nimi, konstruktori, metodit ja niiden nimet on lainattu
 * luokasta GeoPoint, joka löytyy paketista com.google.android.maps.GeoPoint.
 * Metodien toteutus on oma.
 *
 */
public class GeoPoint {

    private final int latitudeE6;
    private final int longitudeE6;

    public GeoPoint(int latit, int longit) throws Exception {
        if ((latit / 1000000 >= -90) & (latit / 1000000 <= 90) & (longit / 1000000 >= -180) & (longit / 1000000 <= 180)) {
            latitudeE6 = latit;
            longitudeE6 = longit;
        } else {
            throw new Exception("Illegal values for a GeoPoint.");
        }

    }

    @Override
    public boolean equals(Object object) {
        //return this.equals(object);
        if (this.hashCode() == object.hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.latitudeE6;
        hash = 83 * hash + this.longitudeE6;
        return hash;
    }

    public int getLatitudeE6() {
        return latitudeE6;
    }

    public int getLongitudeE6() {
        return longitudeE6;
    }

    public String toString() {
        return "LatitudeE6: " + latitudeE6 + ", LongitudeE6: " + longitudeE6;
        //return super.toString();
    }
}

class TestGeoPoint {

    public static void main(String[] args) {
        try {
            GeoPoint geoPoint1 = new GeoPoint(23512456, 62514876);
            GeoPoint geoPoint2 = new GeoPoint(23512456, 62514876);
            GeoPoint geoPoint3 = new GeoPoint(23512416, 62514976);

            System.out.println("geoPoint1: " + geoPoint1.toString() + "\n");
            System.out.println("geoPoint2: " + geoPoint2.toString() + "\n");
            System.out.println("geoPoint3: " + geoPoint3.toString() + "\n");

            System.out.println("geoPoint1 = geopint2: " + geoPoint1.equals(geoPoint2));
            System.out.println("geoPoint1 = geopint3: " + geoPoint1.equals(geoPoint3));
            System.out.println("geoPoint2 = geopint3: " + geoPoint2.equals(geoPoint3));
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }

    }
}
