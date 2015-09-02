/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.world;

import de.canitzp.objects.Block;
import de.canitzp.objects.Player;

import java.util.Set;

public class WorldUpdates {

    public static void update(Player player, Set<Block> blockList, World world) {
        for (Block block : blockList) {
            if (block.getWorld() == player.playersWorld() && block.canCollide()) {
                if (block.checkCollisionWithObject(player)) {
                    if (block.checkInstaCollisionWithObject(player) == Side.LEFT) {
                        player.moveX(-1);
                    }
                    if (block.checkInstaCollisionWithObject(player) == Side.BOTTOM) {
                        player.moveY(-1);
                    }
                    if (block.checkInstaCollisionWithObject(player) == Side.TOP) {
                        player.moveY(1);
                    }
                    if (block.checkInstaCollisionWithObject(player) == Side.RIGHT) {
                        player.moveX(1);
                    }
                }
            }
            if (block.isGrass() && block.checkInstaCollisionWithObject(player) == Side.INSIDE) {
                player.setStandPlayerOnGrass();
            }
        }
        if (player.getX() >= world.WIDTH - player.getWidth()) {
            player.moveX(-1);
        }
        if (player.getX() < -1) {
            player.moveX(1);
        }
        if (player.getY() >= world.HEIGHT - player.getHeight() - 1) {
            player.moveY(-1);
        }
        if (player.getY() < 0) {
            player.moveY(1);
        }
    }
}
