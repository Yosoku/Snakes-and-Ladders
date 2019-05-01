package com.company.app;

import java.awt.*;

public class Board {
    private Tile[] tiles;


    public Board() {
        tiles = new Tile[Config.ROWS * Config.COLS];
        int i = 0;
        int dir = 1;
        //Constructing the board
        for (int y = Config.WINDOW_HEIGHT - Config.Y_RESOLUTION; y >= 0; y -= Config.Y_RESOLUTION) {
            if (dir == 1) {
                for (int x = 0; x < Config.WINDOW_WIDTH; x += Config.X_RESOLUTION) {
                    tiles[i] = new Tile(i + 1, x, y);
                    i++;
                }
            } else {
                for (int x = Config.WINDOW_WIDTH - Config.X_RESOLUTION; x >= 0; x -= Config.X_RESOLUTION) {
                    tiles[i] = new Tile(i + 1, x, y);
                    i++;
                }
            }
            dir *= -1;
        }
        //Connecting the Tile objects in the board
        for (i = 0; i < Config.ROWS * Config.COLS - 1; i++) {
            tiles[i].setNext(tiles[i + 1]);
        }
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public int getIndex(Tile tile){
        for(int i = 0 ; i<tiles.length ; i++)
            if(tiles[i].equals(tile))
                return i;
        return -1;
    }

    public void draw(Graphics g) {
        for (Tile t : tiles) {
            t.draw(g);
        }
    }

    public String toString(int i) {
        return tiles[i].toString();
    }
}
