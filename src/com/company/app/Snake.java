package com.company.app;

import java.awt.*;

public class Snake extends SnakeOrLadder {


    public Snake(Tile bot,Tile top){
        super(bot,top);
        this.color = Color.red;
        top.setNext(bot);
        top.setType(Type.SNAKE);
    }


}
