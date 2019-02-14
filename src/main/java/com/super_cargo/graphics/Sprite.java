package com.super_cargo.graphics;

import com.super_cargo.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {

    private SpriteSheet sheet;
    private float scale;
    private BufferedImage image;

    public Sprite(SpriteSheet sheet, float scale) {
        this.sheet = sheet;
        this.scale = scale;
        image = sheet.getSprite(0);
        image = Utils.resize(image,(int) (image.getWidth() * scale),(int) (image.getHeight() * scale));
    }

    public Sprite (float scale, SpriteSheet sheet){
        this.sheet = sheet;
        this.scale = scale;
        image = sheet.getSprite();
        image = Utils.resize(image,(int) (image.getWidth() * scale), (int) (image.getHeight() * scale));

    }

    public void render(Graphics2D graphics2D, float x, float y) {

        graphics2D.drawImage(image, (int) (x), (int) (y),  null);

    }

}
