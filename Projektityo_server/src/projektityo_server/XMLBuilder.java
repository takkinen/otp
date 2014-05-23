/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektityo_server;

import java.io.StringReader;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.xml.sax.XMLReader;

/**
 *
 * @author henri
 */
public class XMLBuilder {

    private int observerID = 0; // <observerID></observerID>
    private Date date = null; // <date>2014-04-01</date>
    private Time time = null; // <date>2014-04-01</date>
    private int latitudeE6 = 0;  // <latitudeE6>60.170833</latitudeE6>
    private int longitudeE6 = 0; // <longitudeE6>24.9375</longitudeE6>
    private String species = ""; // toteutetaan tietokantaa hyväksi käyttäen.
    private BirdObservation birdObservation;
    private String currentElement = "";
    private String currentTagContent = "";
    private final EntityManagerFactory emf;

    public XMLBuilder() {
        emf = Persistence.createEntityManagerFactory("Projektityo_serverPU"); 
    }

    public void addString(String string) throws XMLStreamException, Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        // /home/henri/NetBeansProjects/otp/XMLReader/XML-file/BirdObservation.xml
        //XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("BirdObservation.xml"));
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(string));

        while (xmlStreamReader.hasNext()) {
            System.out.println("0");

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
            }

        }

        //BirdObservation birdObservation1 = new BirdObservation(observerID, date, time, latitudeE6, longitudeE6, species);
        //System.out.println(birdObservation1.toString());
        
        /**
         * Olion tallettaminen entiteettien avulla 
         */
        
        
        BirdObservation_1 birdObservation_1 = new BirdObservation_1(latitudeE6, date, time, latitudeE6, longitudeE6, species, observerID);
        BirdObservation_1JpaController birdObservation_1JpaController = new BirdObservation_1JpaController(emf);
        birdObservation_1JpaController.create(birdObservation_1);
        System.out.println(birdObservation_1.toString());
        

    }

}
