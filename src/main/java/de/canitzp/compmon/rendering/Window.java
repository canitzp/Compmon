/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.rendering;


import de.canitzp.compmon.Main;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window {

    private static int WIDTH = 1280;
    private static int HEIGHT = 720;
    private static int FPS = 60;
    private static int currentFPS, debugFPS;
    private static Main main;
    private static long getSystemTime = Sys.getTime() * 1000L / Sys.getTimerResolution();


    //Initializations:
    public static void startup() {
        initEngine();
        initGL();
        initGame();
        preInit();
    }

    //Only to Load Lists like Block Collision List.
    private static void preInit() {
        main.preInit();
        init();
    }

    //Load Objects on World after Loading World
    private static void init() {
        main.init();
        render();
        update();
        postInit();
    }

    private static void postInit() {
        main.postInit();

        gameloop();
    }

    private static void initGame() {
        main = new Main();
    }

    private static void gameloop() {
        while (!Display.isCloseRequested()) {
            System.gc();
            Display.sync(FPS);
            Display.update();
            render();
            update();
            currentFPS++;
            while (Sys.getTime() >= getSystemTime + 1000L) {
                debugFPS = currentFPS;
                getSystemTime += 1000L;
                currentFPS = 0;
            }
        }
        clean();
    }

    private static void update() {
        main.update();
        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            clean();
        }
    }

    private static void initEngine() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Compmon");
            Display.create();
            Keyboard.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static void initGL() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glClearColor(0, 0, 0, 1);
    }


    private static void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        main.render();

    }

    private static void clean() {
        Display.destroy();
        Keyboard.destroy();
        System.exit(0);
    }

    public static int getFramerate() {
        return debugFPS;
    }


}