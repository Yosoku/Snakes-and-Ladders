package com.company.app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Snake extends SnakeOrLadder {


    public Snake(Tile bot, Tile top) {
        super(bot, top, "res/snakeImage.png");
        top.setNext(bot);
        top.setType(Type.SNAKE);

    }


}
