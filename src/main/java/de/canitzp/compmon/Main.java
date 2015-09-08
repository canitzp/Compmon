/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon;


import de.canitzp.compmon.objects.Player;
import de.canitzp.compmon.rendering.Debugging;
import de.canitzp.compmon.rendering.Window;
import de.canitzp.compmon.world.Coords;
import de.canitzp.compmon.world.World;
import de.canitzp.compmon.world.WorldRegister;

public class Main {

    public static Player player;
    private static boolean debugOn;

    public Main() {
    }

    public static void main(String[] args) {
        Window.startup();
    }

    public static void setDebugOn() {
        debugOn = true;
    }

    public static void setDebugOff() {
        debugOn = false;
    }

    public static boolean isDebugOn() {
        return debugOn;
    }

    //Look to Window preInit()
    public void preInit() {
    }

    public void init() {
        player = new Player(new Coords(0, 0, WorldRegister.world1_1), 16, 16);
        WorldRegister.registerWorld(player.playersWorld());
    }

    public void postInit() {

    }

    public void render() {
        WorldRegister.renderWorld(player.playersWorld());
        World.renderBlocksLayer1(player);
        World.renderBlocksLayer2(player);
        World.renderBlocksLayer3(player);
        World.renderBlocksLayer4(player);
        World.renderBlocksLayer5(player);
        player.render();
        /**
         * Debugging Screen rendering:
         */
        if (isDebugOn()) {
            Debugging.render();
        }
    }

    public void update() {
        player.update();
        player.playersWorld().update(player);
    }
}
