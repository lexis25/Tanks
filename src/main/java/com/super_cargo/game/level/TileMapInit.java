package com.super_cargo.game.level;

import com.super_cargo.graphics.TextureAtlas;

import java.util.HashMap;
import java.util.Map;

public class TileMapInit {

    private static Map<TileType, Tile> MAP = new HashMap<TileType, Tile>();

    public TileMapInit(TextureAtlas atlas) {

        MAP.put(TileType.BRICK, new Tile(atlas.cut(32 * Level.TILE_SCALE, 0, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.BRICK));
        MAP.put(TileType.METAL, new Tile(atlas.cut(32 * Level.TILE_SCALE, 2 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.METAL));
        MAP.put(TileType.WATER, new Tile(atlas.cut(32 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.WATER));
        MAP.put(TileType.GRASS, new Tile(atlas.cut(34 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.GRASS));
        MAP.put(TileType.ICE, new Tile(atlas.cut(36 * Level.TILE_SCALE, 4 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.ICE));
        MAP.put(TileType.EMPTY, new Tile(atlas.cut(36 * Level.TILE_SCALE, 6 * Level.TILE_SCALE, Level.TILE_SCALE, Level.TILE_SCALE),
                Level.TILE_IN_GAME_SCALE, TileType.EMPTY));
    }

    public Map<TileType, Tile> getMAP() {
        return MAP;
    }
}
