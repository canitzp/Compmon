/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon;


import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.rendering.Window;
import de.canitzp.compmon.world.WorldRegister;

public class Main {

    private static Player player;

    public Main() {
        player = new Player(0, 0, 16, 16, WorldRegister.world1_1);
    }

    public static void main(String[] args) {
        Window.startup();
    }

    //Look to Window preInit()
    public void preInit() {
    }

    public void init() {

    }

    public void postInit() {

    }


    public void render() {
        WorldRegister.renderWorld(player.playersWorld());
        //Block.block1.render(player);
        //Block.block2.render(player);
        WorldRegister.world1_1.renderBlocks(player);
        player.render();
    }

    public void update() {
        player.update();
        WorldRegister.updateWorld(player);
    }
}
