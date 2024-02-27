package com.ts8t.abstracts;

import com.ts8t.objects.Location;

/**
 * @author  Rob Kempf
 * <p>
 * Distance in meters
 */

public abstract class Distance {
    
    /**
     * @param begin  start point of measurement
     * @param end    end point of measurement
     * @return distanceInMeters
     */
    public static double calculateInMeters(Location begin, Location end) {
        double distanceInMeters;
        // TODO this is a placeholder calculation, transition to more evolved code
        distanceInMeters = distance(begin.getLatitude(), end.getLatitude(), begin.getLongitude(), end.getLongitude(), begin.getElevation(), end.getElevation());
        return distanceInMeters;
    }

    /**
     * @param loc1 is one location
     * @param loc2 is another location
     * @param radiusOfConfusionInMeters is the accepted error distance of accuracy in two dimensions
     * @return true if the confusion radii of the two locations overlap, false if not
     */
    public static boolean OverlappingRadiusOfConfusion (Location loc1, Location loc2, double radiusOfConfusionInMeters) {
        double twoDimCloseDistance, latDif, lonDif;
        latDif = loc1.getLatitude() - loc2.getLatitude();
        lonDif = loc1.getLongitude() - loc2.getLongitude();
        twoDimCloseDistance = Math.sqrt(Math.pow(latDif, 2) + Math.pow(lonDif, 2));
        if (radiusOfConfusionInMeters * 2 > twoDimCloseDistance) { // times two because looking for overlap
            return true;
        }
        return false;
    }

    /**
     * adapted from: http://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
     * 
     * Uses Haversine method as its base.
     * 
     * @param lat1  starting latitude in decimal degrees
     * @param lat2  finishing latitude in decimal degrees
     * @param lon1  starting longitude in decimal degrees
     * @param lon2  finishing longitude in decimal degrees
     * @param el1   starting elevation in meters
     * @param el2   finishing elevation in meters
     * @return distance in meters
     */
    private static double distance (double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

        final int R = 6_371_000; // Radius of the earth in meters

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
        
}
