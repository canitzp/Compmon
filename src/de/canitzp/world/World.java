/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.world;

import de.canitzp.objects.Block;
import de.canitzp.objects.Moving;
import de.canitzp.rendering.ImageLoader;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import java.util.HashSet;
import java.util.Set;

public class World {

    private int WIDTH, HEIGHT;
    private static Set<Block> blockList = new HashSet<Block>();
    private static Texture texture = ImageLoader.loadTexture("res/world/WorldTile1-Grassland.png");

    public World(int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void render() {
        Color.white.bind();
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);
        {
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(0, 0);
            GL11.glTexCoord2f(texture.getWidth(), 0);
            GL11.glVertex2f(WIDTH, 0);
            GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
            GL11.glVertex2f(WIDTH, HEIGHT);
            GL11.glTexCoord2f(0, texture.getHeight());
            GL11.glVertex2f(0, HEIGHT);
        }
        GL11.glEnd();
    }


    public void update(Moving object){
        System.gc();
        Block.register();
        for(Block block : blockList){
            if(block.checkCollisionWithObject(object)){
                if(block.checkInstaCollisionWithObject(object) == Side.LEFT){
                    object.moveX(-1);
                }
                if(block.checkInstaCollisionWithObject(object) == Side.BOTTOM){
                    object.moveY(-1);
                }
                if(block.checkInstaCollisionWithObject(object) == Side.TOP){
                    object.moveY(1);
                }
                if(block.checkInstaCollisionWithObject(object) == Side.RIGHT){
                    object.moveX(1);
                }
            }
        }

        if(object.getX() >= this.WIDTH - object.getWidth()){
            object.moveX(-1);
        }

    }

    public static void registerBlock(Block block){
        blockList.add(block);
    }


    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
