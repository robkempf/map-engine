package com.ts8t.attributes;

import com.ts8t.objects.Location;

/**
 * @author  Rob Kempf
 * <p>
 * A Sign is a STATIC notice meant to communicate intended vehicle behavior.
 * All Light attributes are IMMUTABLE and required at time of instantiation.
 */

public class Sign {
    
    /** assuming can pinpoint with sufficient relative accuracy */
    private final SignType signType;
    private final Location location;
    private final double   heightInMeters;
    
    public Sign (SignType signType, Location location, double heightInMeters) {
        this.signType      = signType;
        this.location       = location;
        this.heightInMeters = heightInMeters;
    }
    
    /**
     * @return signType is an enumeration of all the signs we expect to see
     */
    public SignType getSignType() {
        return signType;
    }

    /**
     * @return location is the exact geographic location of object's central reference point
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return height is the exact physical height of object's central reference point
     */
    public double getHeightInMeters() {
        return heightInMeters;
    }

    /** for examples of US signs see http://mutcd.fhwa.dot.gov/services/publications/fhwaop02084/ */
    public enum SignType {
        STOP,
        YIELD,
        LEFT_TURN_AHEAD,
        END_ROAD_WORK;
    }
}
