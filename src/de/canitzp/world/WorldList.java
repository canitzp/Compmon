/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.world;

public enum WorldList {

    WORLD1_1(WorldRegister.world1_1);


    private World world;
    WorldList(World world) {
        this.world = world;
    }
    public World getWorld(){
        return this.world;
    }
}
