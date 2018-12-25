package com.super_cargo.game.level;

import com.super_cargo.game.Game;

import javax.swing.*;
import java.awt.*;

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


    private void resetLevelEmpty() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length - Game.ACTION_WIDTH; j++) {
                field[i][j] = 0;
            }
        }
    }

    private void onSaveLevelFile() {

    }

    private void buildUIEditor() {
        JTextField save = new JTextField("save level");
        save.setFont(new Font("Arial",Font.BOLD,14));

        JTextField back = new JTextField("back to menu");
        save.setFont(new Font( "Arial", Font.BOLD, 14));

    }

    private void onFocusIcon() {

    }

    private void setField(int x , int y){

    }
}
