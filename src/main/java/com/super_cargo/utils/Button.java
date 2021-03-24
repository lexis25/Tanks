package com.super_cargo.utils;

import com.super_cargo.game.level.TileType;
import com.super_cargo.graphics.Sprite;
import com.super_cargo.graphics.TextureAtlas;

import java.awt.*;
import java.util.HashMap;

public class Button{

    private int x;
    private int y;
    private int width;
    private int height;

    private TileType tileType;
    private Point[][] cord;

    private HashMap <Point, Sprite> word = new HashMap<Point, Sprite>();

    private static String PLAYER_1 = "PLAYER_1";
    private static String PLAYER_2 = "PLAYER_2";
    private static String CREDITS = "CREDITS";

    public Button(int x, int y, int wh, TileType type) {// without number
        this.x = x;
        this.y = y;
        this.width = wh;
        this.height = wh;
        this.tileType = type;
        createCord();
    }

    public Button(int x, int y, String nameButton, TextureAtlas atlas) {

        this.x = x;
        this.y = y;

    }


    private void createCord() {
        cord = new Point[width + height][height + height];

        int tempY = y;
        int tempX = x;
        for (int i = 0; i < cord.length; i++) {
            for (int j = 0; j < cord[i].length; j++) {
                if (i == 0 && j == 0) {
                    cord[i][j] = new Point(x, y);
                }
                cord[i][j] = new Point(x + i, y + j);
            }
            y = tempY;
        }
        x = tempX;
        y = tempY;
    }

    public Point[][] getCord() {
        return cord;
    }

    public TileType getTileType() {
        return tileType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
