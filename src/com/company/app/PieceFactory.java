package com.company.app;

import java.awt.*;

public class PieceFactory {
    public static Piece createPiece(Color c, Tile tile){
        String path = "res/Piece/redPiece.png";
        if(Color.red.equals(c))
            path = "res/Piece/redPiece.png";
        if(Color.yellow.equals(c))
            path = "res/Piece/yellowPiece.png";
        if(Color.blue.equals(c))
            path = "res/Piece/bluePiece.png";
        if(Color.green.equals(c))
            path = "res/Piece/greenPiece.png";
        if(Color.pink.equals(c))
            path = "res/Piece/purplePiece.png";


        return new Piece(c,tile,path);
    }
}
