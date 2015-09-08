/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.block;


import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.World;

public enum BlockList {

    GRASS(10, 10),
    TELEPORTPAD(10, 10),
    HOUSE1(32, 32),
    HOUSE2(42, 33);


    private int width, height;

    BlockList(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void updateBlock(Block block, Player player) {
        block.update(player);
    }

    public Block makeObjectAt(int x, int y, World world) {
        return new Block(new Coords(x, y, world), this.width, this.height);
    }

    public Block makeHouseAt(Coords coords, int xDoor, int yDoor, int widthDoor, Coords targetCoords) {
        return new BlockHouse(coords, this.width, this.height, xDoor, yDoor, widthDoor, targetCoords);
    }


}
