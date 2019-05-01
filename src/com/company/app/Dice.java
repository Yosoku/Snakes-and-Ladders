package com.company.app;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Dice  extends Rectangle{
    private Random dice;
    private int xPos;
    private int yPos;


    public Dice(int x,int y){
        super(x,y,50,50);
        this.yPos = y;
        this.xPos = x;
        dice = new Random();
    }


    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(this.xPos,this.yPos,(int)this.getWidth(),(int)this.getHeight());
    }

    public int rollDice(){
        return dice.nextInt(6)+1;
    }




}
