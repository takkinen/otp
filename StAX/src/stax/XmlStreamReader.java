/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Luokan ja muuttujien nimeäminen järkevämmäksi! Nyt luokan nimi ja muuttuja miltei samat.
 */
package stax;

import com.sun.media.sound.AudioFloatInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author kone3
 */
public class XmlStreamReader {

    private final XMLInputFactory xmlInputFactory;
    private XMLStreamReader xmlStreamReader;

    public XmlStreamReader() throws XMLStreamException {
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    public XmlStreamReader(InputStream inputStream) throws XMLStreamException {
        xmlInputFactory = XMLInputFactory.newInstance();
        xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
    }

    public XmlStreamReader(Reader reader) throws XMLStreamException {
        xmlInputFactory = XMLInputFactory.newInstance();
        xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
    }

    public void readXML() throws XMLStreamException, InterruptedException {

        //XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        //assert (xmlStreamReader.getEventType() == XMLEvent.START_DOCUMENT);
        
        //while (xmlStreamReader.hasNext()) {
        while (true) {
            if (!xmlStreamReader.hasNext()) continue;
            int eventType = xmlStreamReader.next();
            switch (eventType) {
                case XMLEvent.ATTRIBUTE:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.CDATA:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.CHARACTERS:
                    testXMLEvent(eventType, "Characters: " + xmlStreamReader.getText());
                    break;
                case XMLEvent.COMMENT:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.DTD:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.END_DOCUMENT:
                    testXMLEvent(eventType, "End Document. ");
                    break;
                case XMLEvent.END_ELEMENT:
                    testXMLEvent(eventType, "End Element " + xmlStreamReader.getLocalName());
                    break;
                case XMLEvent.ENTITY_DECLARATION:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.ENTITY_REFERENCE:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.NAMESPACE:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.NOTATION_DECLARATION:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.PROCESSING_INSTRUCTION:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.SPACE:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.START_DOCUMENT:
                    testXMLEvent(eventType);
                    break;
                case XMLEvent.START_ELEMENT:
                    testXMLEvent(eventType, "Start Element. " + xmlStreamReader.getLocalName());
                    break;

            }

        }

    }

    public void testXMLEvent(int xmlevent) {
        System.out.println(xmlevent);
    }
    public void testXMLEvent(int xmlevent, String string) {
        System.out.println(xmlevent + ": " + string);
    }

}

class TestXmlStreamReader {

    public static void main(String[] args) throws XMLStreamException, IOException, InterruptedException {
        /*
         InputStream inputStream = ClassLoader.getSystemResourceAsStream("BirdObservation.xml");
         XmlStreamReader xmlStreamReader;
         xmlStreamReader = new XmlStreamReader(inputStream);
         xmlStreamReader.readXML();
         */
        Reader reader;
        XmlStreamReader xmlStreamReader;
        try (
                ServerSocket serverSocket = new ServerSocket(6543);
                Socket clientSocket = serverSocket.accept();
                Reader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
            )
            {
                xmlStreamReader = new XmlStreamReader(in);
                xmlStreamReader.readXML();
            }
            catch (IOException ex) {
            Logger.getLogger(TestXmlStreamReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }
