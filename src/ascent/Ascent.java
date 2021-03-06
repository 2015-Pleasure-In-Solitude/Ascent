/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sofyashipova
 */
public class Ascent extends JPanel {

    Ground ground = new Ground(this);
    Player player = new Player(this);

    public Ascent() {

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
//        Image img = ResourceTools.   ImageIcon("/backgrounds/Basic.png").getImage();
//        Image img = new ImageIcon("/Users/sofyashipova/NetBeansProjects/Ascent/src/backgrounds/Basic.png").getImage();
//        Image img = getResource("Resources/AppleMan.png");
        Image img = null;   
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("backgrounds/Basic.png");
            img = ImageIO.read(input);
        } catch (IOException e) {
            //TODO - exception handling
        }

        g.drawImage(img, 0, 0, 3000, getHeight(), null);

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
