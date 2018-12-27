package com.super_cargo.game.level;

import com.super_cargo.game.Game;
import com.super_cargo.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class EditorLevel {

    private Point[] closed = {
            new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1),
            new Point(0, 21), new Point(0, 22), new Point(1, 21), new Point(1, 22),
            new Point(0, 42), new Point(0, 43), new Point(1, 42), new Point(1, 43),// enemies

            new Point(36, 17), new Point(36, 18), new Point(37, 17), new Point(37, 18),// player 1

            new Point(36, 21), new Point(36, 22), new Point(37, 21), new Point(37, 21),// flag

            new Point(36, 25), new Point(36, 26), new Point(37, 25), new Point(37, 26),// player 2
    };

    private static int[][] field = new int[Level.TILES_IN_HEIGHT][Level.TILES_IN_WIDTH];
    private static HashMap<TileType, Point> iconDoc = new HashMap<TileType, Point>();
    private static int level = 1;

    EditorLevel() {
        createRightDoc(44, 0);
        createIcon(45, 1, 2, TileType.BRICK);
        createIcon(47,1,2,TileType.METAL);
        createIcon(45, 3, 2,TileType.WATER);
        createIcon(47,3,2,TileType.GRASS);
        createIcon(45,5,2,TileType.ICE);
        createIcon(47,5,2,TileType.EMPTY);
        buildUIEditor();

    }


    private void resetLevelEmpty() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length - Game.ACTION_WIDTH; j++) {
                field[i][j] = 0;
            }
        }
    }

    private void onSaveLevelFile() {
        Utils.writeLevel("res/level_"+ level,field);
        level++;
    }

    private void buildUIEditor() {
        // two event how to we know whose event work first in stack event, or override

        JTextField save = new JTextField("save level");
        save.setFont(new Font("Arial", Font.BOLD, 14));
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                onSaveLevelFile();
            }
        });

        JTextField reset = new JTextField("reset");
        reset.setFont(new Font("Arial", Font.BOLD, 14));
        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                resetLevelEmpty();
            }
        });

        JTextField back = new JTextField("back to menu");
        save.setFont(new Font("Arial", Font.BOLD, 14));
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                // back to menu class
            }
        });

    }

    private void onFocusIcon() {

    }

    private void createIcon(int x, int y, int hw, TileType type) {
        for (int i = x; i < hw; i++) {
            for (int j = y; j < hw; j++) {
                field[i][j] = type.numeric();
                iconDoc.put(type, new Point(i, j));
            }
        }
    }

    private void createRightDoc(int x, int y) {
        for (int i = x; i < field[i].length; i++) {
            for (int j = y; j < field[j].length; j++) {
                field[i][j] = TileType.fromNumeric(6).numeric();
            }
        }
    }
}
