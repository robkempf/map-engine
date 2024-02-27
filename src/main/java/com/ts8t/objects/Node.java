package com.ts8t.objects;

import java.util.HashSet;
import java.util.Set;

import com.ts8t.abstracts.EarthNode;

/**
 * @author  Rob Kempf
 * <p>
 * A Node is a Location on a road, often at an intersection.
 * Each Node knows the a set of links that begin or end there.
 * All Nodes are Locations, but not all Locations are Nodes.
 */

public class Node extends Location {
    /**
     * Using a long integer for an earthKey lays the foundation for planet-wide unique Nodes. 
     * It permits an AreaMap to reference more than (2^63)-1 Nodes, enough to cover 
     * the entire Earth's dry-land surface (196.9 square miles) with 18,086 Nodes for 
     * every square meter - more than enough. Alternatively, if we continue with positive 
     * int integers, we will be stuck with a maximum of 2 billion (2,147,483,647) 
     * globally unique nodes. World population is 7.4 billion. There are already 
     * almost four times as many people walking around as there are (positive) int(s).
     */

    /** Node has a long earthKey as returned by the EarthNode class */
    private long earthKey = 0; // zero when not set

    /** Node keeps the int id imported from the OSM XML file */
    private int osmId = 0; // zero when not set

    /** Set of links where this Node == begin */
    private final Set<Link> outboundLinks = new HashSet<Link>();
//    
//    /** Set of links where this Node == end */
//    private final Set<Link> inboundLinks = new HashSet<Link>();

    public Node (AreaMap areaMap, int osmId, double latitude, double longitude) {
        super(latitude, longitude);
        setEarthKey (EarthNode.getKey(osmId));
    }

    public Node (AreaMap areaMap, int osmId, double latitude, double longitude, double elevation) {
        super(latitude, longitude, elevation);
        setEarthKey (EarthNode.getKey(osmId));
    }

    /**
     * @param earthKey is set if unique, otherwise stays at zero
     */
    private synchronized void setEarthKey (long earthKey) {
        this.earthKey = earthKey;
    }
    
    
    /** 
     * @return long
     */
    public long getEarthKey() {
        return earthKey;
    }
    
    public int getOsmId() {
        return osmId;
    }
    
    protected boolean addLink (Link link) {
        if (this == link.getBegin()) {
            return outboundLinks.add(link);
        }
//        if (this == link.getEnd()) {
//            return inboundLinks.add(link);
//        }
        return false;
    }

//    public boolean isInboundLink (Link link) {
//        return inboundLinks.contains(link);
//    }
    
    public boolean isOutboundLink (Link link) {
        return outboundLinks.contains(link);
    }

//    public int numberOfInbound() {
//        return inboundLinks.size();
//    }
    
    public int numberOfOutbound() {
        return outboundLinks.size();
    }
    
//    public boolean isInboundNode (Node that) {
//        for (Link link : inboundLinks) {
//            if (that == link.getBegin()) {
//                return true;
//            }
//        }
//        return false;
//    }
    
    public boolean isOutboundNode (Node that) {
        for (Link link : outboundLinks) {
            if (that == link.getEnd()) {
                return true;
            }
        }
        return false;
    }
        
//    public Set<Link> getInboundLinks() {
//        return inboundLinks;
//    }
 
    public Set<Link> getOutboundLinks() {
        return outboundLinks;
    }
        
    @Override
    public synchronized boolean setElevation (double elevation) {
        if (!elevationIsDefined) {
            this.elevation   = elevation;
            elevationIsDefined = true;
            recalculateDistances();
            return true;
        } else {
            return false;
        }
    }
        
    private void recalculateDistances() { // when elevation is changed
//        for(Link link : inboundLinks) {
//            link.recalculateStraightLineDistance();
//        }
        for(Link link : outboundLinks) {
            link.recalculateStraightLineDistance();
        }
    }
}