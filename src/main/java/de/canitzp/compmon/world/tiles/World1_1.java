/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.world.tiles;

import de.canitzp.compmon.objects.Block;
import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.world.World;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import java.util.HashSet;
import java.util.Set;

public class World1_1 extends World {

    private static Set<Block> toRegister = new HashSet<Block>();

    public World1_1(int WIDTH, int HEIGHT) {
        super(WIDTH, HEIGHT);
    }

    public static void addToRegisterList(Block block) {
        toRegister.add(block);
    }

    /*
     * Order to render:
     *       1. UnderWay
     *       2. Way
     *       3. OverWay
     *       4. Objects like Grass
     *       5. Other Objects
     */
    public void renderBlocks(Player player) {
        for (Block block : toRegister) {
            block.render(player);
        }
    }

    @Override
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
        World1_1BlockRegistry.register();
        for (Block block : toRegister) {
            registerBlock(block);
        }
    }
}
