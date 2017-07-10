package com.super_cargo.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {

    private SpriteSheet sheet;
    private float scale;

    public Sprite(SpriteSheet sheet, float scale) {
        this.sheet = sheet;
        this.scale = scale;
    }

    public void render(Graphics2D graphics2D, float x, float y) {
        BufferedImage image = sheet.getSprite(0);
        graphics2D.drawImage(sheet.getSprite(0), (int) x, (int) y, (int) (image.getWidth() * scale),
                (int) (image.getHeight() * scale), null);

    }

}
