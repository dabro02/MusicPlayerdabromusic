package MusicPlayerPackage;

import java.awt.*;


/**
 * Created by Daniel on 19.03.2017.
 */
public class ButtonPictures {

    static int w;
    static int h;
    static MainMusicPlayer game;
    static Graphics2D g;

    public static void getParameters(MainMusicPlayer maincass, Graphics2D graphics , int width, int height)
    {
        w = width;
        h = height;
        game = maincass;
        g = graphics;
    }

    public static void createPlay()
    {
        g.setColor(Color.BLACK);
        int[] playXPoints = {w/4-17, w/4+17,w/4-17};
        int[] playYPoints = {h/12-20, h/12,h/12+20};
        Polygon playPolygon = new Polygon(playXPoints, playYPoints, 3 );
        g.drawPolygon( playPolygon);
        g.fillPolygon(playPolygon);
    }

    public static void createPause(){
        g.setColor(Color.BLACK);
        int[] pauseXPoints1 = {w/4-10, w/4-5, w/4-5, w/4-10};
        int[] pauseXPoints2 = {w/4+10, w/4+5, w/4+5, w/4+10};
        int[] pauseYPoints1 = {h/12-20, h/12-20, h/12+20, h/12+20};
        int[] pauseYPoints2 = {h/12-20, h/12-20, h/12+20, h/12+20};
        Polygon pausePolygon1 = new Polygon(pauseXPoints1,pauseYPoints1,4);
        Polygon pausePolygon2 = new Polygon(pauseXPoints2,pauseYPoints2,4);
        g.drawPolygon(pausePolygon1);
        g.fillPolygon(pausePolygon1);
        g.drawPolygon(pausePolygon2);
        g.fillPolygon(pausePolygon2);
    }
}
