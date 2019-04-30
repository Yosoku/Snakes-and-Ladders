package com.company.app;

import java.awt.*;

public class Tile {
    private boolean debug = false;
    private final int number;
    private Tile next;
    private final int xPos;
    private final int yPos;


    public Tile(int number, int xPos, int yPos) {
        this.number = number;
        this.yPos = yPos;
        this.xPos = xPos;
    }


    public int getNumber() {
        return number;
    }

    public Tile getNext() {
        return next;
    }

    public void setNext(Tile next) {
        this.next = next;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }


    public void draw(Graphics g) {
        if ((this.number % 2) == 0)
            g.setColor(Color.white);
        else
            g.setColor(Color.black);
        //Draw Tile
        g.fillRect(this.xPos, this.yPos, Config.X_RESOLUTION, Config.Y_RESOLUTION);
        //Draw Number on Tile
        g.setColor(Color.blue);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        String str = "" + this.number;

        g.drawString(str, this.xPos + Config.xOffset, this.yPos + Config.yOffset);


        if (this.next != null && debug) {
            g.setColor(Color.red);
            g.drawLine(this.xPos + Config.xOffset, this.yPos + Config.yOffset,
                    this.next.xPos + Config.xOffset, this.next.yPos + Config.yOffset);
        }
    }


    public String toString() {
        return "Number: " + this.number + "  X: " + this.xPos + " / Y: " + this.yPos + "\n";
    }

}
