package com.ts8t.attributes;

/**
 * @author  Rob Kempf
 * <p>
 * A Turn is an action a vehicle can take to leave an EndLane.
 */

public enum Turn {
    ONLY_OPTION, // default
    STRAIGHT,
    RIGHT,
    LEFT,
    UTURN,
    EXIT_RIGHT,
    EXIT_LEFT,
    ENTER_ROTARY,
    ENTER_ROUNDABOUT;
}
