/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.block;

import de.canitzp.compmon.objects.Moving;
import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.rendering.ImageList;
import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.Side;
import de.canitzp.compmon.world.World;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;


public class Block extends Moving {

    protected boolean canCollide;
    protected boolean isGrass;
    protected boolean isTeleportPad;
    protected Coords teleportationCoords;
    protected Texture unknownTexture = ImageList.unknown;
    protected Texture texture;
    protected int x, y, width, height;
    protected Coords coords;

    public Block(Coords coords, int width, int height) {
        super(coords, width, height);
        this.x = coords.getX();
        this.y = coords.getY();
        this.width = width;
        this.height = height;
        this.texture = unknownTexture;
        this.canCollide = true;
        this.isGrass = false;
        this.isTeleportPad = false;
        this.coords = coords;
    }

    public void update(Player player) {

    }

    public void render(Player player) {
        if (player.playersWorld() == world) {
            Color.white.bind();
            texture.bind();
            GL11.glBegin(GL11.GL_QUADS);
            {
                GL11.glTexCoord2f(0, 0);
                GL11.glVertex2f(x, y + world.getHEIGHT() - (y * 2) - height);
                GL11.glTexCoord2f(texture.getWidth(), 0);
                GL11.glVertex2f(x + width, y + world.getHEIGHT() - (y * 2) - height);
                GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
                GL11.glVertex2f(x + width, y + height + world.getHEIGHT() - (y * 2) - height);
                GL11.glTexCoord2f(0, texture.getHeight());
                GL11.glVertex2f(x, y + height + world.getHEIGHT() - (y * 2) - height);
            }
            GL11.glEnd();
        }
    }

    public boolean checkCollisionWithObject(Moving object) {
        int y = this.y + world.getHEIGHT() - (this.y * 2) - height;
        if ((y + height) <= object.getY()) return false;
        if (y >= (object.getY() + object.getHeight())) return false;
        if ((x + width) <= object.getX()) return false;
        return x < (object.getX() + object.getWidth());
    }

    public Side checkInstaCollisionWithObject(Moving object) {
        if (checkCollisionWithObject(object)) {
            int y = this.y + world.getHEIGHT() - (this.y * 2) - height;
            if (object.getX() + object.getHeight() - 1 == x || object.getX() + object.getHeight() == x)
                return Side.LEFT;
            if (object.getY() + object.getWidth() - 1 == y || object.getY() + object.getWidth() == y)
                return Side.BOTTOM;
            if (object.getX() + object.getHeight() - object.getWidth() + 1 == x + width || object.getX() + object.getHeight() - object.getWidth() == x + width)
                return Side.RIGHT;
            if (object.getY() + object.getWidth() - object.getHeight() + 1 == y + height || object.getY() + object.getWidth() - object.getHeight() == y + height)
                return Side.TOP;
            else return Side.INSIDE;
        }
        return null;
    }

    //=====
    public Block setTexture(Texture texture) {
        if (texture.getImageHeight() > 0) {
            this.texture = texture;
        } else {
            this.texture = unknownTexture;
        }
        return this;
    }

    public World getWorld() {
        return world;
    }

    public Block noCollision() {
        this.canCollide = false;
        return this;
    }

    public boolean canCollide() {
        return this.canCollide;
    }

    public Block setToGrass() {
        this.isGrass = true;
        return this;
    }

    public boolean isGrass() {
        return this.isGrass;
    }

    public Block toTeleportPad() {
        this.isTeleportPad = true;
        return this;
    }

    public boolean isTeleportPad() {
        return this.isTeleportPad;
    }

    public Block setTeleportationTarget(Coords coords) {
        teleportationCoords = coords;
        return this;
    }

    public Coords getTeleportationCoords() {
        return isTeleportPad ? this.teleportationCoords : null;
    }

    public Coords getCoords() {
        return coords;
    }
}
