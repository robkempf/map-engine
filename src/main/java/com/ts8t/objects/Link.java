package com.ts8t.objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.Duration;

import com.ts8t.abstracts.Direction;
import com.ts8t.abstracts.Distance;
import com.ts8t.attributes.Accident;
import com.ts8t.attributes.Construction;
import com.ts8t.attributes.EndLaneKey;
import com.ts8t.attributes.RoadCondition;
import com.ts8t.attributes.Light;
import com.ts8t.attributes.Sign;

/**
 * @author  Rob Kempf
 * <p>
 * A Link is the base distance component of a roads on an AreaMap.
 * It is a vector with one begin Node and one end Node, and is
 * a straight approximation of a road segment in a single direction.
 * A two-way road is represented by two links pointed in opposite directions.
 * A Link is also used to define one step in a Route.
 */

public class Link {
    private final  Node   begin, end;
    private final double averageDirectionInDecimalDegrees;
    private double straightLineDistanceInMeters; // euclidean distance between begin and end
    private double actualRoadDistanceInMeters;   // rolling distance following the road
    private final  List<EndLaneKey>  endLanes  = new ArrayList<EndLaneKey>();
    private final  Set<Sign>         endSigns  = new HashSet<Sign>();
    private final  Set<Light>        endLights = new HashSet<Light>();
    private int    legalSpeedLimitInKmph = 0;
    /** mutable expected values measurements depend upon current conditions */
    public Duration          expectedDuration;
    public double   expectedEnergyUseInJoules;
    public double  currrentAverageSpeedInKmph;/** average speed of vehicles now on link */
    public RoadCondition currentRoadCondition;
    public Accident     currentAccidentStatus;
    public Construction    constructionStatus;
    public double     currentNumberOfVehicles;
    public double         maxRecommendedSpeed;/** fastest you should go in current conditions */

    /**
     * @param begin is where the Link starts
     * @param end   is where the Link finishes
     */
    public Link (Node begin, Node end) {
        this.begin = begin;
        this.end   = end;
        straightLineDistanceInMeters     = Distance.calculateInMeters         (begin, end);
        averageDirectionInDecimalDegrees = Direction.calculateInDecimalDegrees(begin, end);
    }

    public Link (Node begin, Node end, double actualRoadDistanceInMeters) {
        this.begin = begin;
        this.end   = end;
        this.actualRoadDistanceInMeters  = actualRoadDistanceInMeters;
        straightLineDistanceInMeters     = Distance.calculateInMeters         (begin, end);
        averageDirectionInDecimalDegrees = Direction.calculateInDecimalDegrees(begin, end);
    }

    
    /** 
     * @return Node
     */
    public Node getBegin() {
        return begin;
    }

    public Node getEnd() {
        return end;
    }

    public double getStraightLineDistanceInMeters() {
        return straightLineDistanceInMeters;
    }

    public synchronized void recalculateStraightLineDistance() { // done by begin or end Node when elevation changes
        straightLineDistanceInMeters     = Distance.calculateInMeters         (begin, end);
    }
    
    public double getActualRoadDistanceInMeters() {
        return actualRoadDistanceInMeters;
    }
    
    public void setActualRoadDistanceInMeters(double actualRoadDistanceInMeters) {
        this.actualRoadDistanceInMeters = actualRoadDistanceInMeters;
    }

    public double getAverageDirectionInDecimalDegrees() {
        return averageDirectionInDecimalDegrees;
    }

    public List<EndLaneKey> getEndLanes() {
        return endLanes;
    }
    
    public Set<Sign> getEndSigns() {
        return endSigns;
    }
    
    public Set<Light> getEndLights() {
        return endLights;
    }

    public int getLegalSpeedLimitInKmph() {
        return legalSpeedLimitInKmph;
    }
}