/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.world;

import de.canitzp.objects.Moving;
import de.canitzp.world.tiles.World1_1;

public class WorldRegister{

    public static World world, world1_1;

    public static void registerWorld(){
        world = new World(1280, 720);
        world1_1 = new World1_1(1280, 720);
    }

    public static void renderWorld(World worldToRender){
        if(worldToRender == null){
            world.render();
        } else {
            worldToRender.render();
        }
    }

    public static void updateWorld(Moving object){
        world.update(object);
        world1_1.update(object);
    }






}
