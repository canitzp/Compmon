/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world.tiles;


import de.canitzp.compmon.objects.ObjectList;
import de.canitzp.compmon.rendering.ImageList;
import de.canitzp.compmon.world.WorldRegister;

public class World1_1BlockRegistry {

    public static void register() {
        makeGrass(60, 60);
        makeGrass(70, 60);
        makeGrass(80, 60);
        makeGrass(60, 70);
        makeGrass(70, 70);
        makeGrass(80, 70);
    }


    private static void makeGrass(int x, int y) {
        World1_1.addToRegisterList(ObjectList.GRASS.makeObjectAt(x, y, WorldRegister.world1_1).noCollision().setToGrass().setTexture(ImageList.grass1));
    }


}
