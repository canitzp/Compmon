/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.block;

import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.WorldRegister;

public class BlockHouse extends Block {

    private int x, y, width, height, xDoor, yDoor, widthDoor, heightDoor;
    private Coords target;

    public BlockHouse(Coords coords, int width, int height, int xDoor, int yDoor, int widthDoor, Coords target) {
        super(coords, width, height);
        this.x = coords.getX();
        this.y = coords.getY();
        this.width = width;
        this.height = height;
        this.xDoor = xDoor;
        this.yDoor = yDoor;
        this.widthDoor = widthDoor;
        this.heightDoor = heightDoor;
        this.target = target;
    }

    @Override
    public void update(Player player) {
        if (player.playersWorld() == getWorld()) {
            if (player.getX() == this.x + this.xDoor + this.widthDoor / 2 && player.getY() == this.y + this.yDoor) {
                player.setWorld(target.getWorld());
                player.setX(target.getX());
                player.setY(target.getY());
                WorldRegister.registerWorld(target.getWorld());
            }
        }
    }

}
