package com.ts8t.attributes;

/**
 * @author  Rob Kempf
 * <p>
 * A RoutePurpose is a DYNAMIC notice meant to communicate intended vehicle behavior.
 * All RoutePurpose attributes are IMMUTABLE and required at time of instantiation.
 */

public enum RoutePurpose {
    SHORTEST_ROAD_DISTANCE,
    FASTEST_ARRIVAL,
    LEAST_ENERGY;
}
