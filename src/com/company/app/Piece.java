package com.company.app;

import java.awt.*;

public class Piece {
    private int xPos;
    private int yPos;
    private Color pColor;
    private Tile currentTile;
    private int movesLeft = 0;


    public Piece(Color c, Tile currentTile) {
        this.xPos = currentTile.getxPos();
        this.yPos = currentTile.getyPos();
        this.pColor = c;
        this.currentTile = currentTile;
    }

    public int getMovesLeft() {
        return this.movesLeft;
    }

    public void setMovesLeft(int m) {
        this.movesLeft = m;
    }
    //TODO Messy code
    public void move(Board board) {
        if(this.currentTile.getType()==Type.NORMAL)
            this.currentTile = this.currentTile.getNext();
        if(this.currentTile.getType() ==Type.SNAKE && this.movesLeft==1)
            this.currentTile = this.currentTile.getNext();
        if(this.currentTile.getType() ==Type.LADDER && this.movesLeft==1)
            this.currentTile = this.currentTile.getNext();
        if(this.currentTile.getType() ==Type.SNAKE && this.movesLeft>1)
        {
            this.xPos = this.currentTile.getxPos();
            this.yPos = this.currentTile.getyPos();
            int i = board.getIndex(this.currentTile);
            this.currentTile = board.getTiles()[i+1];
            this.movesLeft--;
        }
        if(this.currentTile.getType() ==Type.LADDER && this.movesLeft>1)
        {
            this.xPos = this.currentTile.getxPos();
            this.yPos = this.currentTile.getyPos();
            int i = board.getIndex(this.currentTile);
            this.currentTile = board.getTiles()[i+1];
            this.movesLeft--;
        }

        this.xPos = this.currentTile.getxPos();
        this.yPos = this.currentTile.getyPos();
        this.movesLeft--;
    }


    public void update(Board board){
        if (this.getMovesLeft() > 0)
            this.move(board);
    }

    public void draw(Graphics g) {
        g.setColor(pColor);
        int rad = Config.PLAYER_WIDTH / 2;

        g.fillOval(this.xPos + Config.xOffset - rad, this.yPos + Config.yOffset - rad, rad * 2, rad * 2);
    }





    public String toString(){
        return "Player position :(" + this.xPos + ","+this.yPos +") Color : " +pColor+" Moves left :" +movesLeft +"\n";
    }
}
