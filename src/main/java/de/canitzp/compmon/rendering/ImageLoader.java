/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.rendering;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class ImageLoader {

    public static Texture loadTexture(String typeAndName) {
        try {
            return TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/compmon/" + typeAndName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
