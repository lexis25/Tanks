package com.super_cargo.game.level;

import com.super_cargo.IO.MouseInput;
import com.super_cargo.game.Game;
import com.super_cargo.utils.Button;

import java.awt.*;
import java.util.Map;

public class EditorLevelRightDoc {

    private static final int x = 0;
    private static final int y = Game.ACTION_WIDTH;
    private static final int width = Game.WIDTH - Game.ACTION_WIDTH;
    private static final int height = Game.HEIGHT;
    private Map<TileType, Tile> tilesButton;
    private static final Button buttons[] = {
            new Button(0, Game.ACTION_WIDTH, TileType.BRICK),
            new Button(1, 49, TileType.METAL),
            new Button(5, 45, TileType.WATER),
            new Button(5, 49, TileType.GRASS),
            new Button(9, 45, TileType.ICE),
            new Button(10, 59, TileType.EMPTY),


    };


    public void update(MouseInput mouseInput) {

    }

    public void render(Graphics2D g) {

        g.fillRect(y, x, width, height);
        g.setColor(new Color(99, 99, 99));
//        g.drawImage(Image.,x,y,null);

        for (int i = 0; i < buttons.length; i++) {
            Tile tile = tilesButton.get(buttons[i].getTileType());
            tile.render(g, buttons[i].getY() * Level.TILE_SCALE, buttons[i].getX() * Level.TILE_SCALE);
            System.out.println(buttons[i].getY() * Level.TILE_SCALE + " " + buttons[i].getX() * Level.TILE_SCALE);
            System.out.println(Game.WIDTH);
        }

    }

}
