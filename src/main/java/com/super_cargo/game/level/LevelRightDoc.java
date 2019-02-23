package com.super_cargo.game.level;

import com.super_cargo.game.Game;
import com.super_cargo.graphics.TextureAtlas;

import java.awt.*;
import java.util.Stack;

public class LevelRightDoc {
    private static final int x = 0;
    private static final int y = Game.ACTION_WIDTH;
    private static final int width = Game.WIDTH - Game.ACTION_WIDTH;
    private static final int height = Game.HEIGHT;

    private static Stack<Icon> stackEnemies;
    private Tile enemy;
    private static int shore;


    public LevelRightDoc(TextureAtlas atlas) {
        enemy = new Tile(atlas.cut(40 * Level.TILE_SCALE, 24 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE), Level.TILE_SCALE);
        stackEnemies = new Icon(enemy, new Point(1,1), 16,2).getStack();
        stackEnemies.get(stackEnemies.lastElement().point.x);
    }


    public void update() {

    }

    public void render(Graphics2D g) {

    }

    public class Icon {

        private Tile tile;
        private Stack<Icon> stack;
        private Point point;
        private int pointCountX;
        private int pointCountY;

        private Icon(Tile tile, Point point, int pointCountY, int pointCountX) {
            pointCountY = pointCountY;
            pointCountX = pointCountX;
            point = point;
            tile = tile;
            setStack();
        }

        private Icon(Tile tile, Point point) {
            tile = tile;
            point = point;
        }

        public void setStack() {
            double x = point.getX();
            double y = point.getY();

            for (int i = 0; i < pointCountY; i++) {
                for (int j = 0; j < pointCountX; j++) {
                    if (stack.isEmpty()) {
                        stack.add(new Icon(tile, point));
                    } else {
                        stack.add(new Icon(tile, new Point((int) x, (int) (y += Level.TILE_SCALE))));
                    }
                }
                x += Level.TILE_SCALE;
            }
        }

        public Stack<Icon> getStack() {
            return stack;
        }
    }

}
