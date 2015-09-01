/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.objects;


import de.canitzp.rendering.ImageLoader;
import de.canitzp.world.Coords;
import de.canitzp.world.World;
import org.newdawn.slick.opengl.Texture;

public enum ObjectList {

    GRASS("res/world/Grass1.png", 10, 10);


    private String path;
    private int width, height;
    ObjectList(String path, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public Block makeObjectAt(int x, int y, World world){
        return new Block(new Coords(x, y), this.width, this.height, world).setTexture(getObjectTexture());
    }

    public Texture getObjectTexture(){
        if(ImageLoader.loadTexture(this.path).getImageHeight() > 0){
            return ImageLoader.loadTexture(this.path);
        }
        return ImageLoader.loadTexture("res/test.png");
    }

}
