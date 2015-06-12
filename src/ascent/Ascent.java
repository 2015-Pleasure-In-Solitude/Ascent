/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

import static ascent.loadImageFromResource.loadImageFromResource;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;


import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sofyashipova
 */
public class Ascent extends JPanel {

    Ground ground;
    Player player;
    loadImageFromResource loadI;
    int x = 0;

    public Ascent() {
        ground = new Ground(this);
        player = new Player(this);
        loadI = new loadImageFromResource(this);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    public void move() {
        player.move();
    }
    

    

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Image img = null;


        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("backgrounds/L12.png");
            img = ImageIO.read(input);
        } catch (IOException e) {
        }

        g.drawImage(img, x, 0, 5000, getHeight(), null);

        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        ground.paint(g2d);
        player.paint(g2d);
    }

    
    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("The Ascent");

//<editor-fold defaultstate="collapsed" desc="FullscreenOSX">
        com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(frame, true);
        com.apple.eawt.Application.getApplication().requestToggleFullScreen(frame);
//</editor-fold>

        Ascent ascent = new Ascent();
        frame.add(ascent);
        frame.setSize(1280, 800);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            ascent.move();
            ascent.repaint();
            Thread.sleep(10);
        }
    }

}
