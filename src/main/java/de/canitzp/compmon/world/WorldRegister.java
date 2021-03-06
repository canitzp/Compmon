/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world;

import de.canitzp.compmon.world.tiles.World1_1;
import de.canitzp.compmon.world.tiles.World1_2;

public class WorldRegister {

    public static World1_1 world1_1 = new World1_1(1280, 720);
    public static World1_2 world1_2 = new World1_2(1280, 720);


    public static void renderWorld(World worldToRender) {
        worldToRender.render();
    }

    public static void registerWorld(World worldToRegister) {
        worldToRegister.register();
    }

}
