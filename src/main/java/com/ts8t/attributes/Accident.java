package com.ts8t.attributes;

/**
 * @author  Rob Kempf
 * <p>
 * Accident is a dynamic event that impacts traffic flow.
 */

public enum Accident {
    NONE, // default
    TRAFFIC_STOPPED,
    RUBBER_NECKING,
    ON_SHOULDER;
}
