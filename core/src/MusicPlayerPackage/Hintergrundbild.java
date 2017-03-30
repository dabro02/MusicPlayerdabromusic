package MusicPlayerPackage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Daniel on 16.03.2017.
 */
public class Hintergrundbild {


    public static void getHintergrund(MainMusicPlayer game){
        int w = game.actualwidth;
        int h = game.actualheight;
        File imgtest = new File("");
        File dirtest = new File("core/src/MusicPlayerPackage/Pictures");
        if(dirtest.exists()){
        imgtest = new File("core/src/MusicPlayerPackage/Pictures/Hintergrund.png");
        }
        else{
            dirtest.mkdir();
            imgtest = new File("core/src/MusicPlayerPackage/Pictures/Hintergrund.png");
        }
        if(!imgtest.exists())
        {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

        for(float i = 0; i<=w; i++) {
            for(float j = 0; j<=h; j++) {
                //rote farbe                             alpha-wert (transparenz 0<)
                g.setColor(new Color(0.85f, 0, 0.6f, ((i/w)*(j/h))));
                g.drawLine((int) i, (int)j, (int)i, (int)j);
                //grüne farbe                            alpha-wert (transparenz 1<)
                g.setColor(new Color(0, 1f, 0, ((1-(i/w))*(1-(j/h)))));
                g.drawLine((int) i, (int)j, (int)i, (int)j);

            }
        }
        try {
            ImageIO.write(img, "png", new File("core/src/MusicPlayerPackage/Pictures/Hintergrund.png"));
        } catch (IOException k) {
            k.printStackTrace();
        }
        }
    }
}
