package com.ts8t.objects;

import com.ts8t.abstracts.Distance;

/**
 * @author  Rob Kempf
 * <p>
 * A Location is a point on earth: latitude, longitude and elevation.
 */

public class Location {
    private final double RADIUS_OF_CONFUSION_IN_METERS = 3.0;

    private final double latitude, longitude;
    /** elevation is often not defined, default value is zero */
    protected double           elevation = 0.0;
    protected boolean elevationIsDefined = false; // immutable once set

    public Location (double latitude, double longitude) {
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    public Location (double latitude, double longitude, double elevation) {
        this.latitude    = latitude;
        this.longitude   = longitude;
        setElevation(elevation);
    }

    
    /** 
     * @return double
     */
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public boolean isElevationDefined () {
        return elevationIsDefined;
    }
    
    /**
     * ThreadSafe, GuardedBy("elevationIsDefined")
     * @param elevation also called altitude by GPS systems
     * @return true if changed elevation, false if not
     */
    public synchronized boolean setElevation (double elevation) {
        if (!elevationIsDefined) {
            this.elevation   = elevation;
            elevationIsDefined = true;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @param  that is the other Location for comparison
     * @param  radiusOfConfusionInMeters is the expected error radius for the accuracy of measure
     * @return true if radii of confusion overlap, otherwise false
     */
    public boolean isSame (Location that) {
        return Distance.OverlappingRadiusOfConfusion(this, that, RADIUS_OF_CONFUSION_IN_METERS);
    }
}
