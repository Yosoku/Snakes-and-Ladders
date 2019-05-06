package com.company.app;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public abstract class SnakeOrLadder {
    protected Tile bot;
    protected Tile top;
    private BufferedImage image;

    SnakeOrLadder(Tile bot, Tile top, String path) {
        this.bot = bot;
        this.top = top;
        image = BufferedImageLoader.loadBufferedImage(path);
        double ySide = top.getyPos() - bot.getyPos();
        double xSide = top.getxPos() - bot.getxPos();
        double sinx = Math.sin(ySide / Math.sqrt(ySide*ySide+xSide*xSide));
        double angle = Math.toDegrees(Math.asin(sinx));
        rotate(1);
    }

    public void draw(Graphics g) {
        if (this instanceof Snake)
            g.setColor(Color.red);
        else
            g.setColor(Color.green);



// Rotation information



        g.drawLine(bot.getxPos(), bot.getyPos(), top.getxPos(), top.getyPos());
        g.drawImage(image, top.getxPos(), top.getyPos(), null);
    }


    private void rotate(double degrees){
        ImageIcon icon = new ImageIcon(image);
        BufferedImage blankCanvas = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = blankCanvas.createGraphics();
        g2d.rotate(Math.toRadians(degrees));
        g2d.drawImage(blankCanvas,0,0,null);
        this.image = blankCanvas;

    }

}
