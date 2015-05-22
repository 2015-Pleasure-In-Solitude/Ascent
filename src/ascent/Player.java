/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player {

    private static int Y = 445;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 55;
    int x = 100;
    int xa = 0;
    int ya = 0;
    int t1 = 0;
    int t2 = 0;
    final Ascent ascent;

    public Player(Ascent game) {
        this.ascent = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < ascent.getWidth() - WIDTH) {
            x = x + xa;
        }

        if (Y - ya > 0) {
            Y = Y - ya;
        }

        if (collision()) {
            ya = -1;
            Y = ascent.ground.getTopY() - HEIGHT;
        }

    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            xa = -5;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            xa = 5;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ya = 4;
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            ya = -4;
        }
    }

    private boolean collision() {
        return ascent.ground.getBoundsP().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }

}
