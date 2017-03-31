package MusicPlayerPackage;

import com.badlogic.gdx.audio.Music;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static MusicPlayerPackage.ButtonPictures.game;


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
            //mp3file = Gdx.audio.newMusic(Gdx.files.internal("core/assets/data/Alan Walker - Alone.mp3"));
        }
        catch(Exception e) {}
    }

    public void liederAnzeigen(Graphics2D g, ArrayList<File> mp3files)
    {

        int y = 0;
        String zahl;

        for(int i= 0; i<mp3files.size();i++){
            g.setColor(new Color(0.5f,0.5f,0.5f,0.5f));
            g.fillRect(game.actualwidth/2, y,game.actualwidth,35);
            zahl = String.valueOf((i));

            g.setColor(Color.BLACK);
            g.drawString(zahl+".", game.actualwidth/2+10, y+23 );
            y = y+35;
            g.drawRect(game.actualwidth/2, y-1,game.actualwidth,1);

        }

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
