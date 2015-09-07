/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world.tiles;

import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.World;
import de.canitzp.compmon.world.WorldObjectRegistry;
import de.canitzp.compmon.world.WorldRegister;

public class World1_1BlockRegistry extends WorldObjectRegistry {

    private static World world = WorldRegister.world1_1;

    public static void register() {
        makeGrass(world, 60, 60);
        makeGrass(world, 70, 60);
        makeGrass(world, 80, 60);
        makeGrass(world, 60, 70);
        makeGrass(world, 70, 70);
        makeGrass(world, 80, 70);
        makeTeleportPad(new Coords(90, 90, world), new Coords(150, 150, WorldRegister.world1_2));
        makeHouse(new Coords(150, 150, world), 15, 0, 5, new Coords(400, 400, WorldRegister.world1_2));
    }
}
