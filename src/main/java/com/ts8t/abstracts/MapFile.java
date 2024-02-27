package com.ts8t.abstracts;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ts8t.objects.AreaMap;

/**
 * @author  Rob Kempf
 * <p>
 * Provides static functions for AreaMap file operations
 */

public abstract class MapFile {
    
    /**
     * adds data from OSM XML file to AreaMap using SAX XML Parser
     * OSM file structure, see https://wiki.openstreetmap.org/wiki/Elements
     * 
     * @param osmXmlFile - input OSM XML file for an AreaMap
     * @param areaMap    - AreaMap where OSM data will be added
     * @return success   - false if there are Node collisions, true if not
     * @throws Exception - throws exception if file read error
     */
    public static boolean add(String osmXmlFile, AreaMap areaMap) throws Exception {

        try {
            SAXParserFactory   factory = SAXParserFactory.newInstance();
            SAXParser        saxParser = factory.newSAXParser();
            
            DefaultHandler     handler = new DefaultHandler() {
                
                // TODO need to enhance to capture more detail from OSM XML format
                
                boolean isNode = false;
                boolean isLat = false;
                boolean isLon = false;
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("node")) {
                        isNode = true;
                    }
                    if (qName.equalsIgnoreCase("lat")) {
                        isLat = true;
                    }
                    if (qName.equalsIgnoreCase("lon")) {
                        isLon = true;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element :" + qName);
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (isNode) {
                        System.out.print("node : " + new String(ch, start, length) + "' ");
                        isNode = false;
                    }
                    if (isLat) {
                        System.out.println("lat : " + new String(ch, start, length));
                        isLat = false;
                    }
                    if (isLon) {
                        System.out.println("lon : " + new String(ch, start, length));
                        isLon = false;
                    }
                }

            };

            // this is where the parsing happens ...
            saxParser.parse(osmXmlFile, handler);

        } catch (Exception e) {
        e.printStackTrace();
        }
        
        return true;
    }
}
