package com.super_cargo.game.level;

import com.super_cargo.IO.MouseInput;
import com.super_cargo.game.Game;
import com.super_cargo.graphics.Sprite;
import com.super_cargo.graphics.SpriteSheet;
import com.super_cargo.graphics.TextureAtlas;
import com.super_cargo.utils.Button;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class RightDoc {
    private static final int x = 0;
    private static final int y = Game.ACTION_WIDTH;
    private static final int width = Game.WIDTH - Game.ACTION_WIDTH;
    private static final int height = Game.HEIGHT;
    private BufferedImage image;
    private static Graphics2D backgroundDoc;
    private static Sprite sprite;

    private static Stack<Image> stackEnemies = new Stack<Image>();
    private static int shore;

    private static final Button buttons[] = {
            new Button(1, 45, 1, 1, TileType.BRICK),
            new Button(1, 47, 1, 1, TileType.METAL),
            new Button(3, 45, 1, 1, TileType.WATER),
            new Button(3, 47, 1, 1, TileType.GRASS),
            new Button(5, 45, 1, 1, TileType.ICE),
            new Button(5, 47, 1, 1, TileType.EMPTY),
    };



    public RightDoc(TextureAtlas atlas) {
        SpriteSheet sheet = new SpriteSheet(atlas.cut(368,0,32,240));
        sprite = new Sprite(2,sheet);

    }



    public void update(MouseInput mouseInput) {

    }

    public void render(Graphics2D g) {
        g.fillRect(y,x,width,height);
        g.setColor(new Color(99,99,99));

        g.drawImage(image,x,y,null);

        for (int i = 0; i < buttons.length ; i++) {
            sprite.render(g,buttons[i].getY(),buttons[i].getX());
        }


        sprite.render(g,y+32,x);

    }

    public void createUILevelDoc() {

    }

    public void createEditorDoc(){

    }

}
