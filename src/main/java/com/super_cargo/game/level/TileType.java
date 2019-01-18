package com.super_cargo.game.level;

public enum TileType {

    EMPTY(0), BRICK(1), METAL(2), WATER(3), GRASS(4), ICE(5), BACKGROUND_RIGHT_MENU_DOC(6),
    S(7), A(8), V(9), E(10), R(11), O(12);

    private int n;

    TileType(int n) {
        this.n = n;
    }

    public int numeric() {
        return n;
    }

    public static TileType fromNumeric(int n) {
        switch (n) {
            case 1:
                return BRICK;
            case 2:
                return METAL;
            case 3:
                return WATER;
            case 4:
                return GRASS;
            case 5:
                return ICE;
            case 6:
                return BACKGROUND_RIGHT_MENU_DOC;
            case 7:
                return S;
            case 8:
                return A;
            case 9:
                return V;
            case 10:
                return E;
            case 11:
                return R;
            case 12:
                return O;
            default:
                return EMPTY;
        }
    }
}
