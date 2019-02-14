package com.super_cargo.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    private int spriteCount;
    private int scale;
    private int spritesInWidth;


    public SpriteSheet(BufferedImage sheet, int spriteCount, int scale) {
        this.sheet = sheet;
        this.spriteCount = spriteCount;
        this.scale = scale;

        this.spritesInWidth = sheet.getWidth() / scale;
    }

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage getSprite(int index){
        index = index % spriteCount;

        int x = index % spritesInWidth * scale;
        int y = index / spritesInWidth * scale;

        return sheet.getSubimage(x,y,scale,scale);
    }

    public BufferedImage getSprite(){
        return sheet.getSubimage(0,0,sheet.getWidth(),sheet.getHeight());
    }
}
