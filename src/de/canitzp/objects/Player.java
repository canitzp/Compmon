/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.objects;

import de.canitzp.rendering.ImageLoader;
import de.canitzp.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class Player extends Moving{

    private static final Texture texture = ImageLoader.loadTexture("res/world/Player.png");
    private World world;

    public Player(int x, int y, int width, int height, World world){
        super(x, y, width, height, world);
        this.world = world;
    }

    public void render(){

        Color.white.bind();
        texture.bind();

        GL11.glBegin(GL11.GL_QUADS);
        {
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(x, y);
            GL11.glTexCoord2f(texture.getWidth(), 0);
            GL11.glVertex2f(x + width, y);
            GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
            GL11.glVertex2f(x + width, y + height);
            GL11.glTexCoord2f(0, texture.getHeight());
            GL11.glVertex2f(x, y + height);
        }
        GL11.glEnd();
    }

    public void update(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
            moveY(1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            moveY(-1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            moveX(-1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            moveX(1);
        }
    }

    public World playersWorld(){
        return this.world;
    }

}
