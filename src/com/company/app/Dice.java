package com.company.app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Dice {
    private Random dice;
    private int xPos;
    private int yPos;
    private int width = 100;
    private int height = 100;
    private BufferedImage img = null;

    public Dice(int x, int y) {
        this.yPos = y;
        this.xPos = x;
        dice = new Random();
        img = BufferedImageLoader.loadBufferedImage("res//Dice/dice6.png");
    }

    /**
     *
     * @return A random number between 1 and 6
     */
    public int rollDice() {
        int roll = dice.nextInt(6) + 1;
        String path = "res/Dice/dice" + roll +".png";
        img = BufferedImageLoader.loadBufferedImage(path);
        return roll;
    }

    public boolean contains(Point p) {
        if (p.x >= xPos && p.x < xPos + width)
            if (p.y > yPos && p.y < yPos + height)
                return true;
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.drawImage(img,xPos,yPos,width,height,null);
    }


}

