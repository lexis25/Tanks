package com.super_cargo.game.level;

import com.super_cargo.IO.MouseInput;
import com.super_cargo.game.Game;
import com.super_cargo.graphics.TextureAtlas;
import com.super_cargo.utils.Button;
import com.super_cargo.utils.Utils;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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
    private static boolean isClosed;
    private Map<TileType, Tile> tiles;
    private static int level = 1;
    private static TileType tileType;
    private static Button brick;
    private static Button metal;
    private static Button water;
    private static Button grass;
    private static Button ice;
    private static Button empty;

    public EditorLevel(TextureAtlas atlas) {

        tiles = new HashMap<TileType, Tile>();

        tiles.put(TileType.BRICK, new Tile(atlas.cut(32 * Level.TILE_SCALE, 0 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.BRICK));
        tiles.put(TileType.METAL, new Tile(atlas.cut(32 * Level.TILE_SCALE, 2 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.METAL));
        tiles.put(TileType.WATER, new Tile(atlas.cut(32 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.WATER));
        tiles.put(TileType.GRASS, new Tile(atlas.cut(34 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.GRASS));
        tiles.put(TileType.ICE, new Tile(atlas.cut(36 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.ICE));
        tiles.put(TileType.EMPTY, new Tile(atlas.cut(36 * Level.TILE_SCALE, 6 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.EMPTY));
        tiles.put(TileType.BACKGROUND_RIGHT_MENU_DOC, new Tile(atlas.cut(46 * Level.TILE_SCALE, 0 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.BACKGROUND_RIGHT_MENU_DOC));

        createRightDoc();
        buildUIEditor(atlas);
    }


    private static void resetLevelEmpty() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < Game.ACTION_WIDTH / 16; j++) {
                field[i][j] = 0;
            }
        }
    }

    private static void onSaveLevelFile() {
        Utils.writeLevel("res/level_" + level + ".lvl", field);
        level++;
    }

    private void buildUIEditor(TextureAtlas atlas) {
        brick = new Button(1, 45, 1, 1, TileType.BRICK);
        addButton(brick);
        metal = new Button(1, 47, 1, 1, TileType.METAL);
        addButton(metal);
        water = new Button(3, 45, 1, 1, TileType.WATER);
        addButton(water);
        grass = new Button(3, 47, 1, 1, TileType.GRASS);
        addButton(grass);
        ice = new Button(5, 45, 1, 1, TileType.ICE);
        addButton(ice);
        empty = new Button(5, 47, 1, 1, TileType.EMPTY);
        addButton(empty);
    }

    private static void createRightDoc() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 44; j < field[i].length; j++) {
                field[i][j] = TileType.fromNumeric(6).numeric();
            }
        }
    }

    private static void addButton(Button button) {
        for (int i = 0; i < button.getCord().length; i++) {
            for (int j = 0; j < button.getCord()[i].length; j++) {
                field[button.getX() + i][button.getY() + j] = button.getTileType().numeric();
            }
        }
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                Tile tile = tiles.get(TileType.fromNumeric(field[i][j]));
                tile.render(g, j * Level.SCALED_TILE_SIZE, i * Level.SCALED_TILE_SIZE);
            }
        }
    }

    public void update(MouseInput mouseInput) {
        int x = mouseInput.getX();
        int y = mouseInput.getY();

        getEqualsCord(brick, x, y);
        getEqualsCord(metal, x, y);
        getEqualsCord(water, x, y);
        getEqualsCord(grass, x, y);
        getEqualsCord(ice, x, y);
        getEqualsCord(empty, x, y);

        for (int i = 0; i < closed.length; i++) {
            if (x == closed[i].getX() && y == closed[i].getY()) {
                isClosed = true;
            }
        }

        if (!isClosed && tileType != null && y <= 43) {
            field[x][y] = tileType.numeric();
        }
    }

    private void getEqualsCord(Button button, int x, int y) {
        for (int i = 0; i < button.getCord().length; i++) {
            for (int j = 0; j < button.getCord()[i].length; j++) {
                if (button.getCord()[i][j].equals(new Point(x, y))) {
                    tileType = button.getTileType();
                }
            }
        }
    }
}
