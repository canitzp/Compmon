/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world;


import de.canitzp.compmon.block.Block;
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
    //New since MultiWorld System:
    /*
    * Order to render:
    *       1. UnderWay
    *       2. Way / Grass
    *       3. OverWay
    *       4. Objects like Grass
    *       5. Other Objects
    */
    protected static Set<Block> toRegisterLayer1 = new HashSet<Block>();
    protected static Set<Block> toRegisterLayer2 = new HashSet<Block>();
    protected static Set<Block> toRegisterLayer3 = new HashSet<Block>();
    protected static Set<Block> toRegisterLayer4 = new HashSet<Block>();
    protected static Set<Block> toRegisterLayer5 = new HashSet<Block>();
    protected int WIDTH, HEIGHT;
    protected World(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public static void renderBlocksLayer1(Player player) {
        for (Block block : toRegisterLayer1) {
            block.render(player);
            blockList.add(block);
        }
    }

    public static void renderBlocksLayer2(Player player) {
        for (Block block : toRegisterLayer2) {
            block.render(player);
            blockList.add(block);
        }
    }

    public static void renderBlocksLayer3(Player player) {
        for (Block block : toRegisterLayer3) {
            block.render(player);
            blockList.add(block);
        }
    }

    public static void renderBlocksLayer4(Player player) {
        for (Block block : toRegisterLayer4) {
            block.render(player);
            blockList.add(block);
        }
    }

    public static void renderBlocksLayer5(Player player) {
        for (Block block : toRegisterLayer5) {
            block.render(player);
            blockList.add(block);
        }
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

    public void register() {
    }

    public void addToRegisterListLayer1(Block block) {
        toRegisterLayer1.add(block);
    }

    public void addToRegisterListLayer2(Block block) {
        toRegisterLayer2.add(block);
    }

    public void addToRegisterListLayer3(Block block) {
        toRegisterLayer3.add(block);
    }

    public void addToRegisterListLayer4(Block block) {
        toRegisterLayer4.add(block);
    }

    public void addToRegisterListLayer5(Block block) {
        toRegisterLayer5.add(block);
    }



}
