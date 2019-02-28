package com.super_cargo.game.level;

import com.super_cargo.IO.MouseInput;
import com.super_cargo.game.Game;
import com.super_cargo.graphics.TextureAtlas;
import com.super_cargo.utils.Button;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class EditorLevelRightDoc {

    private static final int x = 0;
    private static final int y = Game.ACTION_WIDTH;
    private static final int width = Game.WIDTH - Game.ACTION_WIDTH;
    private static final int height = Game.HEIGHT;
    private Map<TileType, Tile> tilesButton = new HashMap<>();
    private static final Button buttons[] = {
            new Button(2, 90, TileType.BRICK),
            new Button(2, 94, TileType.METAL),
            new Button(6, 90, TileType.WATER),
            new Button(6, 94, TileType.GRASS),
            new Button(10, 90, TileType.ICE),
            new Button(10, 94, TileType.EMPTY),

    };

    public static void main(String[] args) {
        System.out.println(Game.ACTION_WIDTH);
        System.out.println();
    }

    public EditorLevelRightDoc(TextureAtlas atlas) {
        tilesButton.put(TileType.BRICK, new Tile(atlas.cut(32 * Level.TILE_SCALE, 0, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE_BIGBLOCK),
                Level.TILE_IN_GAME_SCALE, TileType.BRICK));
        tilesButton.put(TileType.METAL, new Tile(atlas.cut(32 * Level.TILE_SCALE, 2 * Level.TILE_SCALE, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE_BIGBLOCK),
                Level.TILE_IN_GAME_SCALE, TileType.METAL));
        tilesButton.put(TileType.WATER, new Tile(atlas.cut(32 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE_BIGBLOCK),
                Level.TILE_IN_GAME_SCALE, TileType.WATER));
        tilesButton.put(TileType.GRASS, new Tile(atlas.cut(34 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE_BIGBLOCK),
                Level.TILE_IN_GAME_SCALE, TileType.GRASS));
        tilesButton.put(TileType.ICE, new Tile(atlas.cut(36 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE_BIGBLOCK),
                Level.TILE_IN_GAME_SCALE, TileType.ICE));
        tilesButton.put(TileType.EMPTY, new Tile(atlas.cut(36 * Level.TILE_SCALE, 6 * Level.TILE_SCALE, Level.TILE_SCALE_BIGBLOCK, Level.TILE_SCALE_BIGBLOCK),
                Level.TILE_IN_GAME_SCALE, TileType.EMPTY));
    }


    public void update(MouseInput mouseInput) {

    }

    public void render(Graphics2D g) {

        g.fillRect(y, x, width, height);
        g.setColor(new Color(99, 99, 99));

        for (int i = 0; i < buttons.length; i++) {
            Tile tile = tilesButton.get(buttons[i].getTileType());
            tile.render(g, buttons[i].getY() * Level.TILE_SCALE, buttons[i].getX() * Level.TILE_SCALE);
        }

    }

}
