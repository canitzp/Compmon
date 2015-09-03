/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.block;


import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.World;

public enum BlockList {

    GRASS(10, 10),
    TELEPORTPAD(10, 10);


    private int width, height;

    BlockList(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Block makeObjectAt(int x, int y, World world) {
        return new Block(new Coords(x, y), this.width, this.height, world);
    }


}
