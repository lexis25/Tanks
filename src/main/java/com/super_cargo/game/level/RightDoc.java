package com.super_cargo.game.level;

import com.super_cargo.IO.MouseInput;
import com.super_cargo.game.Game;
import com.super_cargo.utils.Button;

import java.awt.*;

public class RightDoc {
    private static final int x = 0;
    private static final int y = Game.WIDTH - Game.ACTION_WIDTH;
    private static final int width = Game.WIDTH;
    private static final int height = Game.HEIGHT;

    private static final Button buttons[] = {
            new Button(1, 45, 1, 1, TileType.BRICK),
            new Button(1, 47, 1, 1, TileType.METAL),
            new Button(3, 45, 1, 1, TileType.WATER),
            new Button(3, 47, 1, 1, TileType.GRASS),
            new Button(5, 45, 1, 1, TileType.ICE),
            new Button(5, 47, 1, 1, TileType.EMPTY),
            new Button(34, 45, 0, 4, TileType.S),
    };

    public RightDoc() {

    }

    public void createUILevelDoc() {

    }


    public void update(MouseInput mouseInput) {

    }

    public void render(Graphics2D g) {

    }
}
