package com.super_cargo.game.level;

import com.super_cargo.game.Game;
import com.super_cargo.graphics.TextureAtlas;
import com.super_cargo.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private static int level = 1;
    private static TileType tile;

    EditorLevel(TextureAtlas atlas) {
        createRightDoc();
        buildUIEditor(atlas);
    }


    private static void resetLevelEmpty() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length - Game.ACTION_WIDTH; j++) {
                field[i][j] = 0;
            }
        }
    }

    private static void onSaveLevelFile() {
        Utils.writeLevel("res/level_" + level + ".lvl", field);
        level++;
    }

    private void buildUIEditor(TextureAtlas atlas) {
        // two event how to we know whose event work first in stack event, or override

        JButton brick = new JButton();
        JButton metal = new JButton();
        JButton water = new JButton();
        JButton grass = new JButton();
        JButton ice = new JButton();
        JButton empty = new JButton();


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

    private static void createRightDoc() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 44; j < field[i].length; j++) {
                field[i][j] = TileType.fromNumeric(6).numeric();
            }
        }
    }
}
