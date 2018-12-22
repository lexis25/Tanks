package com.super_cargo.game.level;

import java.awt.*;

public class EditorLevel {

    private Point[] closed = {
            new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1),
            new Point(0, 23), new Point(0, 24), new Point(1, 23), new Point(1, 24),
            new Point(0, 48), new Point(0, 49), new Point(1, 48), new Point(1, 49),
            new Point(36, 20), new Point(36, 21), new Point(37, 20), new Point(37, 21),
            new Point(36, 27), new Point(36, 28), new Point(37, 27), new Point(37, 28),
            new Point(35, 23), new Point(35, 24), new Point(36, 23), new Point(36, 24),
            new Point(37, 23), new Point(37, 24)
    };

    private  int[][] level = new int[Level.TILES_IN_HEIGHT][Level.TILES_IN_WIDTH];


    private  void resetLevelEmpty() {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                level[i][j] = 0;
            }
        }
    }
}
