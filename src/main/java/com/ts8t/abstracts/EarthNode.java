package com.ts8t.abstracts;

import com.ts8t.objects.Node;

/**
 * @author  Rob Kempf
 * <p>
 * Functions handling a 64-bit key uniquely identifying a single Node on Earth
 */

public abstract class EarthNode {

    /**
     * @param node is the Node object for EarthNode key lookup or assignment
     * @return earthNode key is a Node key unique among all nodes on Earth
     */
    public static long getKey(Node node) {
        /** TODO decide what to assign and how keep unique on a global basis
         * For now, just pull in the OSM node id.
         */
        return node.getEarthKey();
    }

    /**
     * @param osmId is a node id from OSM for generating EarthNode key
     * @return earthNode key is a Node key unique among all nodes on Earth
     */
    public static long getKey(int osmId) {
        /** TODO decide what to assign and how keep unique on a global basis
         * For now, just pull in the OSM node id.
         */
        return osmId;
    }

}
