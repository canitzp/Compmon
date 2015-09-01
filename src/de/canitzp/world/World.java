package de.canitzp.world;

import de.canitzp.objects.Block;
import de.canitzp.objects.Moving;
import org.lwjgl.opengl.GL11;

import java.util.HashSet;
import java.util.Set;

public class World {

    private int WIDTH, HEIGHT;
    private static World theWorld;
    private static Set<Block> blockList = new HashSet<Block>();


    public World(int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void render() {
        GL11.glClearColor(0, 204, 0, 0);
    }

    public void update(Moving object){
        System.gc();
        Block.register();
        for(Block block : blockList){
            if(block.checkCollisionWithObject(object)){
                if(block.checkInstaCollisionWithObject(object) == Side.LEFT){
                    object.moveX(-1);
                }
                if(block.checkInstaCollisionWithObject(object) == Side.BOTTOM){
                    object.moveY(-1);
                }
                if(block.checkInstaCollisionWithObject(object) == Side.TOP){
                    object.moveY(1);
                }
                if(block.checkInstaCollisionWithObject(object) == Side.RIGHT){
                    object.moveX(1);
                }
            }
        }

        if(object.getX() >= this.WIDTH - object.getWidth()){
            object.moveX(-1);
        }

    }

    public static World registerBlock(Block block){
        blockList.add(block);
        return getWorld();
    }

    public static World getWorld(){
        return theWorld;
    }

}
