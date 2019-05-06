package com.company.app;

import java.awt.*;

public class Config {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 900;
    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int X_RESOLUTION = WINDOW_WIDTH / COLS;
    public static final int Y_RESOLUTION = WINDOW_HEIGHT / ROWS;
    public static final int NUMBER_OF_PLAYERS = 5;
    public static final int PLAYER_WIDTH = 40;
    public static final int xOffset = Config.X_RESOLUTION / 2 - 8;
    public static final int yOffset = Config.Y_RESOLUTION / 2 + 10;
    public static final int NUM_LADDERS = 2;
    public static final int NUM_SNAKES = 2;

    public static Color[] playerColors = {Color.red,Color.blue,Color.yellow,Color.green,Color.pink};

}





