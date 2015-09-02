/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.objects;

import de.canitzp.rendering.ImageList;
import de.canitzp.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class Player {

    private static final Texture texture = ImageList.player1;
    protected boolean standPlayerOnGrass;
    private World world;
    private int x, y, width, height;

    public Player(int x, int y, int width, int height, World world){
        this.world = world;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.standPlayerOnGrass = false;
    }

    public void render(){

        Color.white.bind();
        texture.bind();

        GL11.glBegin(GL11.GL_QUADS);
        {
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(x, y);
            GL11.glTexCoord2f(texture.getWidth(), 0);
            GL11.glVertex2f(x + width, y);
            GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
            GL11.glVertex2f(x + width, y + height);
            GL11.glTexCoord2f(0, texture.getHeight());
            GL11.glVertex2f(x, y + height);
        }
        GL11.glEnd();
    }

    public void update(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
            moveY(1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            moveY(-1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            moveX(-1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            moveX(1);
        }
         /*
         Bug: Can glitch through Walls!
         if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            moveY(2);
        }
         */
    }

    public void moveX(int x) {
        this.x += x;
    }
    public void moveY(int y) {
        this.y += y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public World playersWorld(){
        return this.world;
    }
    public void setWorld(World world) {
        this.world = world;
    }

    public boolean isStandPlayerOnGrass() {
        return standPlayerOnGrass;
    }

    public void setStandPlayerOnGrass() {
        this.standPlayerOnGrass = true;
    }
}
