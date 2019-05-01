package com.company.app;

import java.awt.*;

public class Players {
    private Piece[] players;
    private int currentPlayer;
    public Players(int numofplayers,Tile start) {
        currentPlayer = 0;
        players = new Piece[numofplayers];
        for (int i = 0; i < numofplayers; i++) {
            players[i] = new Piece(Config.playerColors[i],start);
        }
    }

    public Piece getCurrentPlayer(){
        return players[currentPlayer];
    }
    public void cycleTurn(){
        if(++currentPlayer>=players.length)
            currentPlayer = 0;
    }


    public void update(Board board){
        for ( Piece p : players) {
            if(p.getMovesLeft()>0)
                p.update(board);
            else
                cycleTurn();
        }
    }


    public void draw(Graphics g) {
        for (Piece p : players)
            p.draw(g);
    }
}
