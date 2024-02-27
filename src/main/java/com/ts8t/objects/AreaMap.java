package com.ts8t.objects;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.ts8t.abstracts.MapFile;
import com.ts8t.attributes.RoutePurpose;
import com.ts8t.locations.ChargingDepot;

/**
 * @author  Rob Kempf
 * <p>
 * An AreaMap is a set of nodes that know how to link together.
 * It also contains points of interest at other Locations. 
 * AreaMap can be constructed from an OpenStreetMap XML file.
 * https://wiki.openstreetmap.org/wiki/Elements
 */

public class AreaMap {
    /*
     * A tree to node structure for AreaMap provides the fastest lookup access
     * from earthKeys to nodes. The trade-off is slower puts during construction
     * and the need to synchronize puts because TreeMap is NOT ThreadSafe.
     */
    private final Map<Long,Node>    tree           = new TreeMap<Long,Node>();
    /*
     * TODO define Comparator consistent with fast Link access, see
     *      https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
     */
    
    public final Set<ChargingDepot> chargingDepots = new HashSet<ChargingDepot>();
    public final Set<Location>      repairGarages  = new HashSet<Location>();
    public final Set<Location>      parkingGarages = new HashSet<Location>();
    public final Set<Location>      gasStations    = new HashSet<Location>();
    public final Set<Location>      restaurants    = new HashSet<Location>();
    public final Set<Location>      hotels         = new HashSet<Location>();
 
    public AreaMap (String osmXmlFile) throws Exception {
        if (MapFile.add(osmXmlFile, this)) {
            System.out.println("Added OSM data from file without Node id collisions.");
        } else {
            System.out.println("Node id collisions occurred when adding OSM data from file.");
        }
    }
   
    
    /** 
     * @param earthKey
     * @return boolean
     */
    public boolean containsEarthKey(long earthKey) {
        return tree.containsKey(earthKey);
    }

    public boolean containsNode(Node node) {
        return tree.containsValue(node);
    }

    /**
     * Make sure all new nodes in this AreaMap have a unique earthKey (ThreadSafe)
     * @param  node is new node for AreaMap
     * @return true if unique, then node added to AreaMap, even if earthKey is zero (undefined)
     *         false if earthKey already exists in the AreaMap, then node NOT added to AreaMap
     */
    public synchronized boolean addUniqueNode (Node node) {
        if (tree.putIfAbsent(node.getEarthKey(), node) == null) {
            return true;
        }
        return false;
    }
  
    public long findBestNodeFromOrigin (Location origin, RoutePurpose goal) {
        if (tree.size() == 0) {
            return 0;
        }
        // TODO return result of tree search algorithm, returns zero for now
        return 0;
    }

    public long findBestNodeToDestination (Location destination, RoutePurpose goal) {
        if (tree.size() == 0) {
            return 0;
        }
        // TODO return result of tree search algorithm, returns zero for now
        return 0;
    }
}