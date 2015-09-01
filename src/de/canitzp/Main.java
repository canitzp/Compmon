/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp;

import de.canitzp.objects.Block;
import de.canitzp.objects.Player;
import de.canitzp.rendering.Window;
import de.canitzp.world.World;
import de.canitzp.world.WorldList;
import de.canitzp.world.WorldRegister;

public class Main {

    private static Player player;
    private static World world;

    public static void main(String[] args){
        Window.startup();
    }

    public Main(){
        player = new Player(0, 0, 16, 16, WorldList.WORLD.getWorld());

    }

    //Look to Window preInit()
    public void preInit(){
        WorldRegister.registerWorld();
    }
    public void init(){

    }
    public void postInit(){

    }


    public void render(){
        WorldRegister.renderWorld(player.playersWorld());
        //world.render();
        player.render();
        Block.block1.render();
        Block.block2.render();
    }

    public void update() {
        player.update();
        //world.update(player);
        WorldRegister.updateWorld(player);
        System.out.println(player.playersWorld());
    }
}
