package de.canitzp.objects;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Player extends Moving{

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public void render(){
        GL11.glColor3f(1, 1, 0);
        GL11.glBegin(GL11.GL_QUADS);
        {
            GL11.glVertex2f(x, y);
            GL11.glVertex2f(x + width, y);
            GL11.glVertex2f(x + width, y + height);
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
}
