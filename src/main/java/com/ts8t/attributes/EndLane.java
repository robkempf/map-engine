package com.ts8t.attributes;

/**
 * @author  Rob Kempf
 * <p>
 * An EndLane is a type of lane at the end of a Link.
 */

public enum EndLane {
    UNRESTRICTED, // default
    RIGHT_TURN_ONLY,
    LEFT_TURN_ONLY,
    STRAIGHT_ONLY,
    UTURN_ONLY,
    MERGE_RIGHT,
    MERGE_LEFT,
    RIGHT_TURN_OPTION,
    LEFT_TURN_OPTION,
    STRAIGHT_OPTION,
    UTURN_OPTION,
    ROTARY,
    ROUNDABOUT;
}