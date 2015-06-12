/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

//import ascent.SpriteSheetLoader;
import static ascent.loadImageFromResource.loadImageFromResource;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player {

    private static int Y = 590;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 25;
    int x = 100;
    int xa = 0;
    int ya = 0;
    int xback;
    String run = "backgrounds/run.png";
    String idle = "backgrounds/idle.png";
    String path = run;


    Image walk1, walk2;

    Ascent ascent;
    

    public Player(Ascent game) {
        this.ascent = game;

        BufferedImage sheet;
        sheet = (BufferedImage) loadImageFromResource(path);
        walk1 = sheet.getSubimage(0, 0, 20, 25);
       
        walk2 = sheet.getSubimage(20, 0, 20, 25);
    }


    public void move() {

        
        if (x + xa > 0 && x + xa < ascent.getWidth() - WIDTH) {

            if ((x + xa > 0) && (x + xa < ascent.getWidth() - WIDTH)) {

                x = x + xa;
            ascent.x = ascent.x + xback;
        } else if (x + xa >= ascent.getWidth() - WIDTH) {
            xback -= 50;
            x = 0;
        }   else if (x + xa <= ascent.getWidth() - WIDTH) {
            xback += 50;
            x = 0;
        }

        if (Y - ya > 0) {
            Y = Y - ya;
        }

        if (collision()) {
            ya = -1;
            Y = ascent.ground.getTopY() - HEIGHT;
            
        }
        
        if (x == 0) {
            path = idle;
        }
        else if (x > 0) {
            path = run;
        }
        else if (x < 0) {
            path = run;
        }

    }
    }
    public void paint(Graphics2D g) {

        
        if ((walk1 != null) && (walk2 != null)) {
            if (Math.random() > .5) {
                g.drawImage(walk1, x, Y, null);
            } else {
                g.drawImage(walk2, x, Y, null);
            }
            
            
        }

    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
        xback = 0;

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            xa = -5;

            xback = 2;

            
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            xa = 5;
            xback = -2;

        }
        if (e.getKeyCode() == KeyEvent.VK_W) {

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            xa = 5;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {

            ya = 4;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
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
