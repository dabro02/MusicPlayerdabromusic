package MusicPlayerPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import java.awt.*;
import java.io.File;


/**
 * Created by Daniel on 18.03.2017.
 */

public class Lieder {
    Music mp3file;

    Lieder()
    {
        liederImportieren();

    }

    public  void liederImportieren(){
        try {
            File file = new File("data/Alan Walker - Alone.mp3");
            System.out.println(file);
            if(file.exists())
            {
                System.out.println("hallo");
            }
            System.out.println("importieren");
            mp3file = Gdx.audio.newMusic(Gdx.files.internal("core/assets/data/Alan Walker - Alone.mp3"));
        }
        catch(Exception e) {}
    }

    public void liederAnzeigen(Graphics2D g)
    {
        /*g.setColor(new Color(0.5f,0.5f,0.5f,0.5f));
        g.fillRect(game.actualwidth/2, 0,game.actualwidth,game.actualheight/20);
        g.drawString(lied.toString(), game.actualheight/2, 0);*/
    }

    public void liederStarten()
    {
            mp3file.play();
        }

    public void liederStoppen()
    {
        mp3file.pause();
    }
}
