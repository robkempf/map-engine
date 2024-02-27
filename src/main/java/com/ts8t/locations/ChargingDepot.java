package com.ts8t.locations;

import com.ts8t.objects.Location;
/**
 * @author  Rob Kempf
 * <p>
 * ChargingDepot is a Location where vehicles can recharge their energy supply.
 */
public class ChargingDepot extends Location {

    public int totalBays      = 0;
    public int functionalBays = 0;
    public int openBays       = 0;
    public int occupiedBays   = 0;
    public BayType bayType    = BayType.STANDARD;
    
    public ChargingDepot (int totalBays, BayType bayType, double latitude, double longitude, double elevation) {
        super (latitude, longitude, elevation);
        this.totalBays = totalBays;
        this.bayType   = bayType;
    }

    private enum BayType {
        STANDARD,
        BIG,
        SMALL,
        HIGH_VOLTAGE;
    }
}