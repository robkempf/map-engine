package com.ts8t.abstracts;

import com.ts8t.objects.Location;

/**
 * @author  Rob Kempf
 * <p>
 * Direction in decimal degrees. North = 0.0, East = 90.0
 */

public abstract class Direction {

    /**
     * @param begin  where Direction vector starts
     * @param end    where Direction vector finishes
     * @return directionInDecimalDegrees
     */
    public static double calculateInDecimalDegrees(Location begin, Location end) {
        double directionInDecimalDegrees;
        // TODO this is a placeholder calculation, transition to more evolved code
        directionInDecimalDegrees = bearingInDegrees (begin, end);
        return directionInDecimalDegrees;
    }
    
    /** see http://www.movable-type.co.uk/scripts/latlong.html
     * 
     * @param src  beginning point of vector
     * @param dst  end point of vector
     * @return bearing in radians
     */
    private static double bearingInRadians(Location src, Location dst) {
        double srcLat = Math.toRadians(src.getLatitude());
        double dstLat = Math.toRadians(dst.getLatitude());
        double dLng = Math.toRadians(dst.getLongitude() - src.getLongitude());

        return Math.atan2(Math.sin(dLng) * Math.cos(dstLat),
                Math.cos(srcLat) * Math.sin(dstLat) - 
                  Math.sin(srcLat) * Math.cos(dstLat) * Math.cos(dLng));
    }

    /**
     * @param src  beginning point of vector
     * @param dst  end point of vector
     * @return bearing in degrees
     */
    private static double bearingInDegrees(Location src, Location dst) {
        return Math.toDegrees((bearingInRadians(src, dst) + Math.PI) % Math.PI);
    }    
}
