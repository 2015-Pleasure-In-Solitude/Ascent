/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascent;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyashipova
 */
public class loadImageFromResource {
        
    private final Ascent ascent;

    
    loadImageFromResource(Ascent ascent) {
        this.ascent = ascent;
        

    } 
                public static Image loadImageFromResource(String resourcePath) {
        Image image = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream(resourcePath);
            image = ImageIO.read(input);
        } catch (IOException e) {

        }
        return image;
    }

}
