package com.super_cargo.game.level;

import com.super_cargo.IO.MouseInput;
import com.super_cargo.game.Game;
import com.super_cargo.graphics.TextureAtlas;
import com.super_cargo.utils.Button;
import com.super_cargo.utils.Utils;

import java.awt.*;
import java.util.Map;

public class EditorLevel {

    private static final Point[] closed = {
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

    public EditorLevel(TextureAtlas atlas) {
        tiles = new TileMapInit(atlas).getMAP();
    }

    public static Point[] getClosed() {
        return closed;
    }

    public static boolean getIsClosed() {
        return isClosed;
    }

    public static void setIsClosed(boolean isClosed) {
        EditorLevel.isClosed = isClosed;
    }

    private static void resetLevelEmpty() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < Game.ACTION_WIDTH / 16; j++) {
                field[i][j] = TileType.EMPTY.numeric();
            }
        }
    }

    private static void onSaveLevelFile() {
        Utils.writeLevel("res/level_" + level + ".lvl", field);
        level++;
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                Tile tile = tiles.get(TileType.fromNumeric(field[i][j]));
                tile.render(g, j * Level.SCALED_TILE_SIZE, i * Level.SCALED_TILE_SIZE);
            }
        }
    }

    public void update(MouseInput mouseInput, Button [] buttons) {

    }

}
