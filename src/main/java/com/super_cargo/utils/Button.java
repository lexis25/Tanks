package com.super_cargo.utils;

import com.super_cargo.game.level.TileType;

import java.awt.*;

public class Button {
    private int x;
    private int y;
    private int width;
    private int height;
    private TileType tileType;

    private static Point[][] cord;


    public static void main(String[] args) {
        Button b = new Button(1, 45, 1, 1, TileType.BRICK);
        showArray(b.getCord());
    }

    public static void showArray(Point [][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

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

}
