/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spatialinformationsender;
import java.util.Random;

/**
 *
 * @author henri
 */



public class SpatialPoint {
	private double latitude;
	private double longitude;
	
	//public Point() { }
	
	
	public SpatialPoint(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}
	
	public SpatialPoint() { latitude = 0.0; longitude = 0.0; }
	
	public void setSpatialPoint(double lat, double lon) throws Exception {
            if (!(verify(lat,lon))) { //check that coordinate is sensible
                throw new Exception("Not a coordinate!");
            }
                    
		if (verify(lat,lon)) {
			latitude = lat;
			longitude = lon;
		}
	}
	
	private boolean verify(double lat, double lon) {
		if (Math.abs(lat)>90) return false;
		return Math.abs(lon) <= 180;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public String toXML() {
		
		String geopointxml = String.format("<geo:Point>\n<geo:lat>" +
		"%9.4f</geo:lat>\n<geo:long>%9.4f</geo:long>\n</geo:Point>\n",latitude, longitude);
		
		return geopointxml;
	}
	/*
	 * Should return a new Point Object
	 */
	public SpatialPoint randomSpatialPoint() {
		Random generator = new Random();
		latitude = (generator.nextDouble()*90.0); // pohjoinen pallonpuolisko
		longitude = (generator.nextDouble()*180.0); // itäistä pituutta
		return this;		
	}
	
	public SpatialPoint randomSpatialPoint(double startLat, double endLat, double startLon, double endLon) {
		Random generator = new Random();
		latitude = ((endLat - startLat)*generator.nextGaussian()/2) + startLat;
		longitude = ((endLon - startLon)*generator.nextGaussian()/2) + startLon;
		return this;
	}

	
	
/*	
	public String toString() {
		return "";
	}
	*/
	
}

class PointTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpatialPoint spatialPoint = new SpatialPoint();
		System.out.println("************************************");
		
		for (int i=0;i<200;i++) {
			spatialPoint = spatialPoint.randomSpatialPoint();
			System.out.print(spatialPoint.toXML());
			System.out.println();
		}
		
		
		

	}

}

