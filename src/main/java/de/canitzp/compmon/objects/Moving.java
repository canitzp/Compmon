/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.objects;


import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.World;

public class Moving {

    protected int x, y;
    protected int width, height;
    protected World world;


    public Moving(Coords coords, int width, int height) {
        this.x = coords.getX();
        this.y = coords.getY() + coords.getWorld().getHEIGHT() - (coords.getY() * 2);
        this.width = width;
        this.height = height;
        this.world = coords.getWorld();
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

    public World getWorld() {
        return world;
    }
}
