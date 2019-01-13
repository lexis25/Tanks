package com.super_cargo.IO;

import com.super_cargo.game.level.Level;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    private int x;
    private int y;


    private boolean isPressed;

    public MouseInput() {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        x = e.getX();
        y = e.getY();
    }

    public int get_X() {
        return x /= Level.TILE_SCALE * Level.TILE_IN_GAME_SCALE;
    }

    public int get_Y() {
        return y /= Level.TILE_SCALE * Level.TILE_IN_GAME_SCALE;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}