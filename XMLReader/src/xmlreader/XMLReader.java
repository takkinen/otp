/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;

import java.sql.Date;
import java.sql.Time;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

/**
 *
 * @author henri
 */
public class XMLReader {

    /**
     * @param xsr
     * @return
     * @throws javax.xml.stream.XMLStreamException
     */
    public static BirdObservation readObservationXML(XMLStreamReader xsr) throws XMLStreamException {

        int observerID = 0; // <observerID></observerID>
        Date date = null; // <date>2014-04-01</date>
        Time time = null; // <date>2014-04-01</date>
        int latitudeE6 = 0;  // <latitudeE6>60.170833</latitudeE6>
        int longitudeE6 = 0; // <longitudeE6>24.9375</longitudeE6>
        String species = ""; // toteutetaan tietokantaa hyväksi käyttäen.

        BirdObservation birdObservation;
        String currentElement = "";
        String currentTagContent = "";

        while (xsr.hasNext()) {
            int event = xsr.next();

            if (event == XMLStreamConstants.START_ELEMENT) {
                currentTagContent = "";
                currentElement = xsr.getLocalName();
                break;
            }

            if (event == XMLStreamConstants.END_ELEMENT) {
                //
                if ("birdobservation".equals(xsr.getLocalName())) {
                    continue;
                }
                if ("observerID".equals(xsr.getLocalName())) {
                    observerID = Integer.getInteger(currentTagContent);
                    break;
                }
                if ("date".equals(xsr.getLocalName())) {
                    date = Date.valueOf(currentTagContent);
                    break;
                }
                if ("time".equals(xsr.getLocalName())) {
                    time = Time.valueOf(currentTagContent);
                    break;
                }
                if ("latitudeE6".equals(xsr.getLocalName())) {
                    latitudeE6 = Integer.getInteger(currentTagContent);
                    break;
                }
                if ("longitudeE6".equals(xsr.getLocalName())) {
                    longitudeE6 = Integer.getInteger(currentTagContent);
                    break;
                }
                if ("species".equals(xsr.getLocalName())) {
                    species = currentTagContent;
                    break;
                }
            }

            if (event == XMLStreamConstants.CHARACTERS) {
                currentTagContent = xsr.getText().trim();
                break;
            }

            if (event == XMLStreamConstants.END_DOCUMENT) {
                continue;
            }

        }

        return new BirdObservation(observerID, date, time, latitudeE6, longitudeE6, species);

    } // while

    /**
     * @param args the command line arguments
     * @throws javax.xml.stream.XMLStreamException
     */
    public static void main(String[] args) throws XMLStreamException {
        // TODO code application logic here

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        // /home/henri/NetBeansProjects/otp/XMLReader/XML-file/BirdObservation.xml
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("BirdObservation.xml"));

        int observerID = 0; // <observerID></observerID>
        Date date = null; // <date>2014-04-01</date>
        Time time = null; // <date>2014-04-01</date>
        int latitudeE6 = 0;  // <latitudeE6>60.170833</latitudeE6>
        int longitudeE6 = 0; // <longitudeE6>24.9375</longitudeE6>
        String species = ""; // toteutetaan tietokantaa hyväksi käyttäen.
        BirdObservation birdObservation;
        String currentElement = "";  // TURHA????
        String currentTagContent = "";

        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();

            if (event == XMLStreamConstants.START_DOCUMENT) {
                System.out.println("1");
                System.out.println("Starting document:");
                System.out.println(xmlStreamReader.getLocalName() + "\n");
                continue;
            }

            if (event == XMLStreamConstants.END_DOCUMENT) {
                System.out.println("2");
                continue;
            }

            if (event == XMLStreamConstants.START_ELEMENT) {
                currentElement = xmlStreamReader.getLocalName();
                System.out.println("3");
                //System.out.println(xmlStreamReader.getElementText());
                //System.out.println(xmlStreamReader.getText());
                System.out.println(xmlStreamReader.getLocalName());
                continue;
            }

            if (event == XMLStreamConstants.END_ELEMENT) {

                System.out.println("4");

                if ("birdobservation".equals(xmlStreamReader.getLocalName())) {
                    System.out.println(currentTagContent);
                    //continue;
                    break; // toteutetaan myöhemmin tapaus, virrassa useampi entiteetti
                }
                if ("observerID".equals(xmlStreamReader.getLocalName())) {
                    observerID = Integer.parseInt(currentTagContent);
                    System.out.println(currentTagContent);
                    continue;
                }
                if ("date".equals(xmlStreamReader.getLocalName())) {
                    System.out.println(currentTagContent);
                    date = Date.valueOf(currentTagContent);
                    continue;
                }
                if ("time".equals(xmlStreamReader.getLocalName())) {
                    System.out.println(currentTagContent);
                    time = Time.valueOf(currentTagContent);
                    continue;
                }
                if ("latitudeE6".equals(xmlStreamReader.getLocalName())) {
                    
                    System.out.println(currentTagContent);
                    latitudeE6 = Integer.parseInt(currentTagContent);
                    continue;
                }
                if ("longitudeE6".equals(xmlStreamReader.getLocalName())) {
                    System.out.println(currentTagContent);
                    
                    longitudeE6 = Integer.parseInt(currentTagContent);
                    continue;
                }
                if ("species".equals(xmlStreamReader.getLocalName())) {
                    System.out.println(currentTagContent);
                    species = currentTagContent;
                    continue;
                }

                continue;
            }

            if (event == XMLStreamConstants.CHARACTERS) {
                currentTagContent = xmlStreamReader.getText().trim();
                System.out.println("5");
                continue;
            }

        }
        
        BirdObservation birdObservation1 = new BirdObservation(observerID, date, time, latitudeE6, longitudeE6, species);
        System.out.println(birdObservation1.toString());

    }

}
