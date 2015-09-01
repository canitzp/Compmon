/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.rendering;

import org.newdawn.slick.opengl.Texture;

public enum WorldTiles {

    Grasslands(ImageLoader.loadTexture("res/world/WorldTile1-Grassland.png"));

    private Texture texture;
    WorldTiles(Texture texture){
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}
