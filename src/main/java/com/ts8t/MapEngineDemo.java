package com.ts8t;

import com.ts8t.objects.AreaMap;

/**
 * @author  Rob Kempf
 * <p>
 * In summary, these are the five (5) basic object classes use by the Map Engine: <p>
 * 
 * Location is any point on earth: latitude, longitude and elevation.<p>
 * 
 * Node is a Location on a road with a set of links that begin or end there.<p>
 * 
 * Link connects only two Nodes along a road in only one direction.<p>
 * 
 * Route describes how to get from origin to destination.<p>
 * 
 * AreaMap contains all roads and notable locations in an area.
 */

public class MapEngineDemo {

    /**
     * A demonstration of an AreaMap drawn from an OSM XML file
     * 
     * @param args String osmFile.xml
     * @throws Exception throws exception when file not found
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("started ...");
        long t1, t2, elapsedMilliseconds;
        t1 = System.currentTimeMillis();
        
        try {
            final AreaMap areaMap = new AreaMap("data/osm_munich_small.xml");
            
            if (areaMap != null) ; // placeholder to prevent ide warning

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        t2 = System.currentTimeMillis();
        elapsedMilliseconds = (t2 - t1);
        System.out.println("elapsed milliseconds = " + elapsedMilliseconds);

    }
}
