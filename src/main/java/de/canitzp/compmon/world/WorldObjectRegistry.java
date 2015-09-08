/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world;

import de.canitzp.compmon.block.BlockList;
import de.canitzp.compmon.rendering.ImageList;

public class WorldObjectRegistry {

    protected static void makeGrass(World world, int x, int y) {
        world.addToRegisterListLayer2(BlockList.GRASS.makeObjectAt(x, y, world).setToGrass().setTexture(ImageList.grass1).noCollision());
    }

    protected static void makeTeleportPad(Coords coords, Coords targetCoords) {
        coords.getWorld().addToRegisterListLayer3(BlockList.TELEPORTPAD.makeObjectAt(coords.getX(), coords.getY(), coords.getWorld()).noCollision().setTexture(ImageList.TeleportPad).toTeleportPad().setTeleportationTarget(targetCoords));
    }

    protected static void makeHouse(Coords coords, int xDoor, int yDoor, int widthDoor, Coords targetCoords) {
        coords.getWorld().addToRegisterListLayer2(BlockList.HOUSE2.makeHouseAt(coords, xDoor, yDoor, widthDoor, targetCoords).setTexture(ImageList.HouseSandy1));
    }
}
