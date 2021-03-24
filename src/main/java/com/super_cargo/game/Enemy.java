package com.super_cargo.game;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {

    private Point[] scanView;
    private int lengthViewType;

    private static String TYPE_HEAVY = "HEAVY";
    private static String TYPE_LIGHT = "LIGHT";
    private static String TYPE_ANTI_TANK = "ANTITANK";
    private String type;
    private int speed;
    private final boolean alienOrOur = true;
    private int[][] memoryMap;
    private final Point[] startPos = {new Point(0, 0), new Point(25, 0), new Point(50, 0)};
    private int x;
    private int y;
    private boolean visible = true;
    private String[] intelligence = {"smart", "stupid", "normal"};

    private int hp;

    public Enemy(String typeTank) {
        switch (typeTank) {
            case (TYPE_HEAVY):
                type = TYPE_HEAVY;
                hp = 3;
                speed = 1;
                break;
            case (TYPE_LIGHT):
                type = TYPE_LIGHT;
                hp = 2;
                speed = 2;
                break;
            case (TYPE_ANTI_TANK):
                type = TYPE_ANTI_TANK;
                hp = 1;
                speed = 3;
                break;
        }
        initialize();
    }

    private void randomLocation() {
        Point point = startPos[new Random().nextInt(startPos.length - 1)];
        this.x = point.x;
        this.y = point.y;
    }

    private void checkCollision() {

    }

    private void createStackVisible() {

    }

    private void scanView() {

    }

    private void inVisible() {
        this.visible = false;
    }

    private void isVisible() {
        this.visible = true;
    }

    public void initialize() {
        final Thread thread = new Thread() {
            public void run() {
                try {
                    int i = 0;
                    while (i < 5) {
                        if (visible) {
                            inVisible();
                            sleep(500);
                        } else {
                            isVisible();
                            sleep(500);
                        }
                        i++;
                    }
                    interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    interrupt();
                }
            }
        };
    }
}
