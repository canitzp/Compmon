/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world;


import de.canitzp.compmon.objects.Block;
import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.rendering.ImageList;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import java.util.HashSet;
import java.util.Set;

public class World {

    protected static Set<Block> blockList = new HashSet<Block>();
    protected static Texture texture = ImageList.worldTileGrassland1;
    protected int WIDTH, HEIGHT;

    protected World(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public static void registerBlock(Block block) {
        blockList.add(block);
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

    public void update(Player player) {
        System.gc();
        WorldUpdates.update(player, blockList, this);
    }
}
