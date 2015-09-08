/*
 * Copyright (c) 2015. canitzp
 * All Rights of this Project contains to me.
 * It is not allowed to copy or redistribute this Code.
 */

package de.canitzp.compmon.rendering;

import de.canitzp.compmon.Main;
import org.newdawn.slick.TrueTypeFont;

import java.awt.*;

public class Debugging {

    private static Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
    private static TrueTypeFont font = new TrueTypeFont(awtFont, false);

    public static void render() {
        String layer1 = Window.getFramerate() + " - World: " + Main.player.getWorld().getName();
        font.drawString(0, 0, layer1);
    }
}
