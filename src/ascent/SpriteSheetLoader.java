package ascent;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyashipova
 */
public class SpriteSheetLoader {

    String path;

    int width;
    int height;
    int rows;
    int columns;
    BufferedImage[] sprites;
    private Ascent ascent;

    SpriteSheetLoader(Ascent game) {
        this.ascent = game;
    }

    SpriteSheetLoader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void spriteLoader(int width, int height, int rows, int columns) throws IOException {
        BufferedImage sheet = ImageIO.read(new File(path));

        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;

        sprites = new BufferedImage[rows * columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sprites[(i * columns) + j] = sheet.getSubimage(i * width, j * height, width, height);
            }
        }
    }

    public void paint(Graphics g) {
        g.drawImage(sprites[2], 20, 25, null);
    }

}
