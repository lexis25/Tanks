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
    private static Stack<Icon> stackPlayer;

    private Tile enemy;
    private Tile lifePlayerTitle;
    private Tile playerQuantityLife;

    private static int shore;

    private Icon playerTitle;


    public LevelRightDoc(TextureAtlas atlas) {
        enemy = new Tile(atlas.cut(40 * Level.TILE_SCALE, 24 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE), Level.TILE_IN_GAME_SCALE);
        Icon enemies = new Icon(enemy, new Point(2, 46), 8, 2, true);
        stackEnemies = enemies.getStack();

        lifePlayerTitle = new Tile(atlas.cut(47 * Level.TILE_SCALE, 17 * Level.TILE_SCALE, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE), Level.TILE_IN_GAME_SCALE);
        playerTitle = new Icon(lifePlayerTitle, new Point(18, 46));

        playerQuantityLife = new Tile(atlas.cut(47 * Level.TILE_SCALE, 18 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE), Level.TILE_IN_GAME_SCALE);
        Icon playerQuantityOne = new Icon(playerQuantityLife, new Point(19, 46), 2, 2, false);
        stackPlayer = playerQuantityOne.getStack();


    }

    public void update() {

    }

    public void render(Graphics2D g) {
        g.fillRect(y, x, width, height);
        g.setColor(new Color(99, 99, 99));


        for (int i = 0; i < stackEnemies.size(); i++) {
            stackEnemies.get(i).tile.render(g, (int) (stackEnemies.get(i).point.getY() * Level.SCALED_TILE_SIZE),
                    (int) (stackEnemies.get(i).point.getX() * Level.SCALED_TILE_SIZE));
        }

        for (int i = 0; i < stackPlayer.size(); i++) {
            stackPlayer.get(i).tile.render(g, (int) (stackPlayer.get(i).point.getY() * Level.SCALED_TILE_SIZE),
                    (int) (stackPlayer.get(i).point.getX() * Level.SCALED_TILE_SIZE));
        }


       // playerQuantityLife.render(g, 100, 100);
        lifePlayerTitle.render(g, (int) playerTitle.point.getY() * Level.SCALED_TILE_SIZE,
                (int) playerTitle.point.getX() * Level.SCALED_TILE_SIZE);
    }

    public class Icon {

        private Tile tile;
        private Stack<Icon> stack = new Stack<>();
        private Point point;
        private int pointCountX;
        private int pointCountY;
        private boolean evenCardinal;

        private Icon(Tile tile, Point point, int pointCountY, int pointCountX, boolean evenCardinal) {
            this.pointCountY = pointCountY;
            this.pointCountX = pointCountX;
            this.point = point;
            this.tile = tile;
            this.evenCardinal = evenCardinal;
            setStack();
        }

        private Icon(Tile tile, Point point) {
            this.tile = tile;
            this.point = point;
        }

        public void setStack() {
            double x = point.getX();
            double y = point.getY();

            for (int i = 0; i < pointCountY; i++) {
                for (int j = 0; j < pointCountX; j++) {
                    if (stack.isEmpty()) {
                        stack.add(new Icon(tile, point));
                    } else {
                        stack.add(new Icon(tile, new Point((int) x, (int) (++y))));
                    }
                }
                ++x;
                y -= pointCountX;
            }

            if (!evenCardinal) {
                stack.remove(stack.lastElement());
            }

        }

        public Stack<Icon> getStack() {
            return stack;
        }
    }

}
