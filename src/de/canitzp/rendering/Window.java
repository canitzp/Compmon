/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.rendering;


import de.canitzp.Main;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window{

    private static int WIDTH = 1280;
    private static int HEIGHT = 720;
    private static int FPS = 120;
    private static Main main;


    //Initializations:
    public static void startup(){
        initEngine();
        initGL();
        initGame();
        gameloop();
        preInit();
    }

    //Only to Load Lists like Block Collision List.
    private static void preInit(){
        main.register();
        init();
    }
    private static void init(){

    }
    private static void postInit(){

    }







    private static void initGame() {
        main = new Main();
    }

    private static void gameloop() {
        while (!Display.isCloseRequested()){
            System.gc();
            Display.sync(FPS);
            Display.update();
            render();
            update();
        }
        clean();
    }

    private static void update() {
        main.update();
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
            clean();
        }
    }

    private static void initEngine(){
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Pokemon");
            Display.create();
            Keyboard.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static void initGL() {
        GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glClearColor(0, 0, 0, 1);


    }


    private static void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        main.render();

    }

    private static void clean(){
        Display.destroy();
        Keyboard.destroy();
        System.exit(0);
    }




}


