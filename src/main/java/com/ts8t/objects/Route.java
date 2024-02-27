package com.ts8t.objects;

import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.Duration;

/**
 * @author  Rob Kempf
 * <p>
 * A Route describes how to get from an origin to a destination.
 * origin and destination are not necessarily Nodes.
 * It is mutable so a Route can change dynamically.
 */

public class Route {

    public Location origin, destination; // not necessarily Nodes
    public List<Link> links = new LinkedList<Link>();
    public double   distanceInMeters;
    public Duration expectedDuration;
    public double   expectedEnergyUseInJoules;
    // TODO make the members private and expose public methods
}