package MusicPlayerPackage;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Daniel on 14.03.2017.
 */
public class MainFrame extends JPanel{
    MainMusicPlayer game;
    BufferedImage hintergrundbild1;
    Buttons playButton;


    MainFrame(final MainMusicPlayer game)
    {
        this.game =game;

        game.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if (playButton.buttonPointed(e.getX(), e.getY()))
                    {
                        if (game.playOrPause) {
                            game.playOrPause = false;
                            System.out.println("klick");
                            game.lieder.liederImportieren();
                            game.lieder.liederStarten();

                        }
                        else {
                            game.playOrPause = true;
                            game.lieder.liederStoppen();
                        }
                    }
                }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        Hintergrundbild.getHintergrund(game);

        try{
            hintergrundbild1 = ImageIO.read(new File("core/src/MusicPlayerPackage/Pictures/Hintergrund.png"));
        }
        catch(Exception e){}
        playButton = new Buttons(game.actualwidth/4-25,game.actualheight/12-25,50,50, null);
    }


    @Override
    protected void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        g.drawImage(hintergrundbild1, 0,0 , null);
        g.setColor(new Color(0.5f,0.5f,0.5f,0.5f));
        g.fillRect(0,0,game.actualwidth/2,game.actualheight/6);
        playButton.renderButtons(g);
        playButton.koordsUpdate(game.actualwidth/4-25,game.actualheight/12-25,50,50);
        ButtonPictures.getParameters(game,g,game.actualwidth,game.actualheight);
        game.lieder.liederAnzeigen(g);
        if(game.playOrPause){
            ButtonPictures.createPlay();
        }
        else {
            ButtonPictures.createPause();
        }
    }



    public void updateMainFrame() {
        while(true){
            int y = 0;
            int x = 0;
            try {
                y = game.frame.getMousePosition().y;
                x = game.frame.getMousePosition().x;
            }
            catch(Exception e){}
            playButton.buttonPointed(x,y);
            game.actualwidth = game.frame.getWidth();
            game.actualheight = game.frame.getHeight();
            game.actualX = game.frame.getX();
            game.actualY = game.frame.getY();
            if(game.actualheight< 400)
            {
                game.actualheight = 400;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            else if (game.actualwidth < 600){
                game.actualwidth = 600;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            else if(game.actualheight> 768)
            {
                game.actualheight = 768;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            else if (game.actualwidth > 1366){
                game.actualwidth = 1366;
                game.frame.setBounds(game.actualX,game.actualY,game.actualwidth,game.actualheight);
            }
            //System.out.println(game.playOrPause);
            repaint();
        }
    }
}
