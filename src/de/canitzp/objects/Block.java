package de.canitzp.objects;

import de.canitzp.rendering.ImageLoader;
import de.canitzp.world.Coords;
import de.canitzp.world.Side;
import de.canitzp.world.World;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;


public class Block extends Moving {

    private Texture texture  = ImageLoader.loadTexture("res/test.png");
    private int x, y, width, height;
    private Coords coords;

    public Block(Coords coords, int width, int height) {
        super(coords.getX(), coords.getY(), width, height);
        this.x = coords.getX();
        this.y = coords.getY();
        this.width = width;
        this.height = height;
        this.coords = coords;
    }

    public void startup(){

    }

    public void render(){
        GL11.glPushMatrix();

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
        GL11.glRotatef(180, 0, 0, 1);
        GL11.glPopMatrix();
    }



    public static Block block1 = new Block(new Coords(200, 200), 100, 100);
    public static Block block2 = new Block(new Coords(100, 50), 10 ,10);

    public static void register(){
        World.registerBlock(block1);
        World.registerBlock(block2);
    }

    public boolean checkCollisionWithObject(Moving object){
        if((y + height) <= object.getY()) return false;
        if(y >= (object.getY() + object.getHeight())) return false;
        if((x + width) <= object.getX()) return false;
        if(x >= (object.getX() + object.getWidth())) return false;
        return true;
    }
    public Side checkInstaCollisionWithObject(Moving object){
        if(checkCollisionWithObject(object)){
            if(object.getX() + object.getHeight() - 1 == x || object.getX() + object.getHeight() == x) return Side.LEFT;
            if(object.getY() + object.getWidth() - 1 == y || object.getY() + object.getWidth() == y) return Side.BOTTOM;
            if(object.getX() + object.getHeight() - object.getWidth() + 1 == x + width || object.getX() + object.getHeight() -object.getWidth() == x + width) return Side.RIGHT;
            if(object.getY() + object.getWidth() - object.getHeight() + 1 == y + height || object.getY() + object.getWidth() - object.getHeight() == y + height) return Side.TOP;
        } else return Side.INSIDE;

        return null;
    }


}