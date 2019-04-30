package com.company;
import Freddie.src.app.*;
import com.company.app.*;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakesLadders extends FCanvas implements KeyListener {
    private Board board;
    private Player player;
    private Random dice;

    SnakesLadders(int width, int height) {
        this.width = width;
        this.height = height;
        setFPSLOG(false);
        addKeyListener(this);
    }

    public static void main(String[] args) {
        SnakesLadders sn = new SnakesLadders(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        FWindow window = new FWindow(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT + 28, "Snakes and Ladders", sn);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        System.out.println(Config.toString1());
        sn.start();

    }

    @Override
    public void init() {
        setBackground(Color.black);
        board = new Board();
        player = new Player(Color.red, board.getTiles()[0]);
        dice = new Random();
    }

    @Override
    public void draw(Graphics g) {
        board.draw(g);
        player.draw(g);
    }


    @Override
    public void update() {
        if (player.getMovesLeft() > 0)
            player.move();
        if (player.getMovesLeft() == 0)
            player.setMovesLeft(dice.nextInt(7) + 1);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
