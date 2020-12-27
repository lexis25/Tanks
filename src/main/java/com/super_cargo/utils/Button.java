package com.super_cargo.utils;

import com.super_cargo.game.level.TileType;

import javax.swing.*;
import java.awt.*;

public class Button {

    private int x;
    private int y;
    private int width;
    private int height;

    private TileType tileType;
    private Point[][] cord;

    private static String PLAYER_1 = "PLAYER_1";
    private static String PLAYER_2 = "PLAYER_2";
    private static String CREDITS = "CREDITS";

    public Button(int x, int y, int wh, TileType type) {
        this.x = x;
        this.y = y;
        this.width = wh;
        this.height = wh;
        this.tileType = type;
        createCord();
    }

    public Button(String nameButton, TileType type){
        cord = new Point[nameButton.length()][nameButton.length()];

        if(nameButton.equalsIgnoreCase("save")){
            for (int i = 0; i < nameButton.length(); i++) {

            }
        }else if(nameButton.equalsIgnoreCase("start")){

        }else if(nameButton.equalsIgnoreCase("settings")){

        }else{
            try{

            }catch (Exception e){

            }
        }

    }

    public Button(String nameButton){
        JButton button = new JButton(nameButton);
        
    }

    private void createCord() {

        int tempLengthX = 0;
        int tempLengthY = 0;
        if(width == height){
            tempLengthX = width + height;
            tempLengthY = height + height;
        }else if(width > height){
            tempLengthX = width + height;
            tempLengthY = ++height;
        }else if(width < height){
            tempLengthY = width + height;
            tempLengthX = ++width;
        }

        cord = new Point[tempLengthX][tempLengthY];
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
