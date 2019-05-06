package com.company.app;

import java.awt.*;

public class Ladder extends SnakeOrLadder {


    public Ladder(Tile bot,Tile top){
        super(bot,top,"res/ladderImage.png");
        bot.setNext(top);
        bot.setType(Type.LADDER);
    }



}
