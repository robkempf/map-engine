package com.ts8t.attributes;

import com.ts8t.objects.Location;

/**
 * @author  Rob Kempf
 * <p>
 * A Light is a DYNAMIC notice meant to communicate intended vehicle behavior.
 * All Light attributes are IMMUTABLE and required at time of instantiation.
 */

public class Light {
    
    /** assuming can pinpoint with sufficient relative accuracy */
    private final LightType lightType;
    private final Location location;
    private final double   heightInMeters;
    
    public Light (LightType lightType, Location location, double heightInMeters) {
        this.lightType      = lightType;
        this.location       = location;
        this.heightInMeters = heightInMeters;
    }
    
    /**
     * @return signType is an enumeration of all the signs we expect to see
     */
    public LightType getLightType() {
        return lightType;
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

    /** see https://en.wikipedia.org/wiki/Traffic_light */
    public enum LightType {
        STOP,
        YIELD,
        LEFT_TURN_AHEAD,
        END_ROAD_WORK;
    }
}
