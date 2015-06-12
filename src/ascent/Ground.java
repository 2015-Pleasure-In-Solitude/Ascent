/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

import java.awt.Graphics2D;
import java.awt.Polygon;



/**
 *
 * @author sofyashipova
 */
public class Ground {

    private final Ascent ascent;

    int X = 0;
    int Y = 590;
    int WIDTH = 5000;
    int HEIGHT = 300;
    int m = 800;
    int m2 = Y;
    int m3 = 250;
    int xpoints[] = {X, X, WIDTH, WIDTH};
    int ypoints[] = {m, m2, m3, m};
    int npoints = 4;
    int M = m;

    public Ground(Ascent ascent) {
        this.ascent = ascent;

    }

    public void paint(Graphics2D g) {
        //g.fillPolygon(xpoints, ypoints, npoints);

    }

    public Polygon getBoundsP() {
        return new Polygon(xpoints, ypoints, npoints);

    }
    


    public int getTopY() {
        while (M>m3) {
            return M--;
        } 
        return 0;

    }

}
