/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.objects;

import de.canitzp.compmon.Main;
import de.canitzp.compmon.block.Block;
import de.canitzp.compmon.rendering.ImageList;
import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class Player extends Moving {

    private static final Texture texture = ImageList.player1;
    protected boolean standPlayerOnGrass;
    private World world;
    private int x, y, width, height;

    public Player(Coords coords, int width, int height) {
        super(coords, width, height);
        this.world = coords.getWorld();
        this.x = coords.getX();
        this.y = coords.getY() + world.getHEIGHT() - (y * 2) - height - 2;
        this.width = width;
        this.height = height;
        this.standPlayerOnGrass = false;
    }

    public void render() {

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

    public void update() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            moveY(-1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            moveY(1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            moveX(-1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            moveX(1);
        }
         /*
         Bug: Can glitch through Walls!
         if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            moveY(2);
        }
         */
        /**
         * Debugging Screen:
         */
        if (Keyboard.isKeyDown(Keyboard.KEY_F3) && !Main.isDebugOn()) {
            Main.setDebugOn();
        } else if (Keyboard.isKeyDown(Keyboard.KEY_F3) && Main.isDebugOn()) {
            Main.setDebugOff();
        }
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

    public void moveX(int x) {
        this.x += x;
    }

    public void moveY(int y) {
        this.y += y;
    }

    public World playersWorld() {
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

    public boolean isPlayerOverACollision(Block block) {
        return block.getX() <= x + width && block.getY() <= y + height - 4 && block.getX() >= x && block.getY() >= y + height - 4;
    }
}
