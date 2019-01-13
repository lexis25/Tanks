package com.super_cargo.utils;

import com.super_cargo.game.level.TileType;

import java.awt.*;

public class Button {

    private int x;
    private int y;
    private int width;
    private int height;

    private TileType tileType;
    private Point[][] cord;

    public Button(int x, int y, int width, int height, TileType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tileType = type;
        createCord();
    }


    private void createCord() {

        cord = new Point[width + height][width + height];
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
