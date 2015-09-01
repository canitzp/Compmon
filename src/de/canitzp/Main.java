package de.canitzp;

import de.canitzp.objects.Block;
import de.canitzp.objects.Player;
import de.canitzp.rendering.Window;
import de.canitzp.world.World;
import org.lwjgl.opengl.Display;

public class Main {

    private static World world;
    private static Player player;
    private static Block block;

    public static void main(String[] args){
        Window.startup();
    }

    public Main(){
        world = new World(Display.getWidth(), Display.getHeight());
        player = new Player(0, 0, 16, 16);
    }

    //Look to Window preInit()
    public void register(){
    }


    public void render(){
        world.render();
        player.render();
        Block.block1.render();
        Block.block2.render();
    }

    public void update() {
        player.update();
        world.update(player);
    }
}
