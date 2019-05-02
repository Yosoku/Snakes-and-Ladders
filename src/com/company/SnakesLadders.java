package com.company;

import Freddie.src.app.*;
import com.company.app.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class SnakesLadders extends FCanvas implements MouseListener {
    private Board board;
    private Players players;
    private Dice dice;
    SnakeOrLadder[] ladders;

    SnakesLadders(int width, int height) {
        this.width = width;
        this.height = height;
        setFPSLOG(false);
    }

    private void setUpLadders() {
        int lads = Config.NUM_LADDERS;
        int i = 0;
        Random rand = new Random();
        Tile bot, top;
        //Don't access Tiles that are already ladders or Snakers
        while (i < Config.NUM_LADDERS + Config.NUM_SNAKES) {
            int r2 = rand.nextInt(Config.COLS * Config.COLS / 2);
            int r1 = rand.nextInt(Config.COLS * Config.COLS - Config.COLS * Config.COLS/2) + Config.COLS * Config.COLS/2;
            for (; true; ) {
                if (board.getTiles()[r1].getType() != Type.NORMAL)
                    r1 = rand.nextInt(Config.COLS * Config.COLS - Config.COLS * Config.COLS/2) + Config.COLS * Config.COLS/2;
                if (board.getTiles()[r2].getType() != Type.NORMAL)
                    r2 = rand.nextInt(Config.COLS * Config.COLS / 2);
                if (board.getTiles()[r1].getType() == Type.NORMAL && board.getTiles()[r2].getType() == Type.NORMAL)
                    break;
            }
            bot = board.getTiles()[r2];
            top = board.getTiles()[r1];
            if (lads > 0) {
                ladders[i] = new Ladder(bot, top);
                lads--;
            } else
                ladders[i] = new Snake(bot, top);
            i++;
        }

    }

    public static void main(String[] args) {
        SnakesLadders sn = new SnakesLadders(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        FWindow window = new FWindow(Config.WINDOW_WIDTH + 150, Config.WINDOW_HEIGHT + 28, "Snakes and Ladders", sn);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setIconImage(new ImageIcon("res/snakeIcon.jpg").getImage());
        System.out.println(Config.toString1());
        sn.start();

    }

    @Override
    public void init() {
        setBackground(Color.YELLOW);
        board = new Board();
        dice = new Dice(Config.WINDOW_WIDTH, 400);
        addMouseListener(this);
        ladders = new SnakeOrLadder[Config.NUM_SNAKES + Config.NUM_LADDERS];
        setUpLadders();
        players = new Players(Config.NUMBER_OF_PLAYERS, board.getTiles()[0]);

    }

    @Override
    public void update() {
        players.update(board);
    }

    @Override
    public void draw(Graphics g) {
        board.draw(g);
        players.draw(g);
        dice.draw(g);
        for (SnakeOrLadder sl : ladders)
            sl.draw(g);
    }


    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Point mousePress = e.getPoint();
        if (dice.contains(mousePress)) {
            if (players.someonePlaying()){
                System.out.println("Someone is playing tho");
                return;
            }
            else {
                players.getCurrentPlayer().setMovesLeft(dice.rollDice());
                players.cycleTurn();
            }
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
