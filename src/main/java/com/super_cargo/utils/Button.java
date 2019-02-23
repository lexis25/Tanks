package com.super_cargo.utils;

import com.super_cargo.game.level.TileType;

public class Button {

    private int x;
    private int y;

    private TileType tileType;

    public Button(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.tileType = type;
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
