package com.ts8t.attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Rob Kempf
 * <p>
 * One EndLaneKey describes one lane at the end of a Link.
 * When used in a List, endLanes are indexed from left to right
 * as viewed by a vehicle approaching the end of a Link.
 */

public class EndLaneKey {
    public final EndLane lane;
    
    public EndLaneKey (final EndLane lane) {
        this.lane = lane;
    }
    /** legalTurns and turnDistancesInMeters are indexed in matching order */
    public final List<Turn>   legalTurns            = new ArrayList<Turn>  ();
    public final List<Double> turnDistancesInMeters = new ArrayList<Double>();        
}
