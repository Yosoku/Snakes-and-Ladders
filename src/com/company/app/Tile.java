package com.company.app;

import java.awt.*;



public class Tile {
    private boolean debug = false;
    private final int number;
    private Tile next;
    private final int xPos;
    private final int yPos;
    private Type type;


    public Tile(int number, int xPos, int yPos) {
        this.number = number;
        this.yPos = yPos;
        this.xPos = xPos;
        type = Type.NORMAL;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void draw(Graphics g) {
        if ((this.number % 2) == 0)
            g.setColor(Color.white);
        else
            g.setColor(Color.gray);
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

    public  boolean equals(Object object){
        // If the object is compared with itself then return true
        if (object == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(object instanceof Tile)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Tile t = (Tile) object;

        // Compare the data members and return accordingly
        return t.getNumber()==this.getNumber();

    }

}
