package com.super_cargo.IO;

import com.super_cargo.game.level.Level;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    private int x;
    private int y;

    public MouseInput() {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse was pressed extends adapter");
        x = e.getX();
        y = e.getY();
    }

    public int getX() {
        this.x = x / Level.TILE_SCALE * Level.TILE_IN_GAME_SCALE;
        return x;
    }

    public int getY() {
        this.y = y / Level.TILE_SCALE * Level.TILE_IN_GAME_SCALE;
        return y;
    }
}