/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.OptionalInt;



/**
 *
 * @author sofyashipova
 */
public class Ground {

    private Ascent ascent;

    int X = 0;
    int Y = 445;
    int WIDTH = 5000;
    int HEIGHT = 300;
    int xpoints[] = {X, X, WIDTH, WIDTH};
    int ypoints[] = {800, Y, Y, 800};
    int npoints = 4;

    public Ground(Ascent ascent) {
        this.ascent = ascent;

    }

    public void paint(Graphics2D g) {
        //    g.fillRect(X, Y, WIDTH, HEIGHT);

        g.fillPolygon(xpoints, ypoints, npoints);

    }

    /*    public Rectangle getBounds() {
     return new Rectangle(X, Y, WIDTH, HEIGHT);
     }*/
    public Polygon getBoundsP() {
        return new Polygon(xpoints, ypoints, npoints);

    }
    


    public int getTopY() {
        return Y;
}

}
