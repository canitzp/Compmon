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

    protected static void makeTeleportPad(World world, int x, int y, World targetWorld, Coords targetCoords) {
        world.addToRegisterListLayer3(BlockList.TELEPORTPAD.makeObjectAt(x, y, world).noCollision().setTexture(ImageList.TeleportPad).toTeleportPad().setTeleportationTarget(targetWorld, targetCoords));
    }
}
