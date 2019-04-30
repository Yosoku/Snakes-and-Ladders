package com.company.app;

import java.awt.*;

public class Player {
    private int xPos;
    private int yPos;
    private Color pColor;
    private Tile currentTile;
    private int movesLeft = 0;


    public Player(Color c, Tile currentTile) {
        this.xPos = currentTile.getxPos();
        this.yPos = currentTile.getyPos();
        this.pColor = c;
        this.currentTile = currentTile;
    }


    public void draw(Graphics g) {
        g.setColor(pColor);
        int rad = Config.PLAYER_WIDTH / 2;
        g.fillOval(this.xPos + Config.xOffset - rad, this.yPos + Config.yOffset - rad, rad * 2, rad * 2);
    }

    public void move() {
        this.currentTile = this.currentTile.getNext() == null ? this.currentTile : this.currentTile.getNext();
        this.xPos = this.currentTile.getxPos();
        this.yPos = this.currentTile.getyPos();
    }

    public int getMovesLeft() {
        return this.movesLeft;
    }

    public void setMovesLeft(int m) {
        this.movesLeft = m;
    }
}
