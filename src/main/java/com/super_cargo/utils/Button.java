package com.super_cargo.utils;

import com.super_cargo.game.level.TileType;

import java.awt.*;

public class Button {

    private int x;
    private int y;
    private int width;
    private int height;
    private int scale;

    private TileType tileType;
    private Point[][] cord;

    public Button(int x, int y, int width, int height, TileType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tileType = type;
        this.scale = scale;
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
