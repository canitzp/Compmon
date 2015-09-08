/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world.tiles;


import de.canitzp.compmon.world.World;

public class World1_2 extends World {


    public World1_2(int WIDTH, int HEIGHT) {
        super(WIDTH, HEIGHT, "World1_2");
    }

    @Override
    public void register() {
        World1_2BlockRegistry.register();
    }


}
