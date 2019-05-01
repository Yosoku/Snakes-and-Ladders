package com.company.app;

import java.awt.*;

public abstract class SnakeOrLadder {
    protected Tile bot;
    protected Tile top;
    protected Color color;

    SnakeOrLadder(Tile bot,Tile top){
        this.bot = bot;
        this.top = top;
    }
    public void draw(Graphics g){
        g.setColor(this.color);
        g.drawLine(bot.getxPos()+Config.xOffset,
                bot.getyPos()+Config.yOffset,
                top.getxPos()+Config.xOffset,
                top.getyPos()+Config.xOffset
        );
    }

}
