package com.super_cargo.IO;

import com.super_cargo.game.level.Level;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends JComponent {
    private int x;
    private int y;

    public Mouse() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                x = e.getX();
                y = e.getY();
            }
        });
    }
    @Override
    public int getX() {
        this.x = x / Level.TILE_SCALE * Level.TILE_IN_GAME_SCALE;
        return x;
    }

    @Override
    public int getY() {
        this.y = y / Level.TILE_SCALE * Level.TILE_IN_GAME_SCALE;
        return y;
    }
}