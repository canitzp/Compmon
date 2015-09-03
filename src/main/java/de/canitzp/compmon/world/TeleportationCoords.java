/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world;


public class TeleportationCoords {

    private World world;
    private Coords coords;

    public TeleportationCoords(World world, Coords coords) {
        this.world = world;
        this.coords = coords;
    }

    public World getTeleportationTargetWorld() {
        return this.world;
    }

    public Coords getTeleportationTargetCoords() {
        return this.coords;
    }
}
