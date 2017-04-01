package MusicPlayerPackage;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
                            //game.lieder.liederImportieren();
                            //game.lieder.liederStarten();

                        }
                        else {
                            game.playOrPause = true;
                            //game.lieder.liederStoppen();
                        }
                    }
                }
            @Override
            public void mousePressed(MouseEvent e) {
                if(game.scrollBar.scollBarPointed(e.getX(), e.getY())){
                    game.scrollBar.getScrollerDistance(e.getY());
                    game.scrollBar.holding = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(true){
                    game.scrollBar.holding = false;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(game.scrollBar.holding = true){
                    game.scrollBar.holding = false;
                }
            }
        });
        game.frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {

                    if (game.scrollBar.fieldPointed(e.getX(), e.getY()))
                        game.scrollBar.scrollable = true;
                        game.scrollBar.scrollWithMouseWheel(e.getUnitsToScroll());
            }
        });
        Hintergrundbild.getHintergrund(game);

        try{
            hintergrundbild1 = ImageIO.read(new File("data/Pictures/Hintergrund.png"));
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
        game.lieder.liederAnzeigen(g, game.liederSuchen.mp3files);
        if(game.playOrPause){
            ButtonPictures.createPlay();
        }
        else {
            ButtonPictures.createPause();
        }
        //generelles Fenster:
        g.setColor(new Color(0.5f, 0.5f, 0.5f, 0.5f));
        g.fillRect(game.actualwidth/2, 0, game.actualwidth/2, 35);

        g.setColor(Color.BLACK);
        g.drawRect(game.actualwidth/2, 35, game.actualwidth, 1);
        g.drawLine(game.actualwidth/2, 0, game.actualwidth/2,game.actualheight);
        g.drawLine(game.actualwidth-25, 35, game.actualwidth-25,game.actualheight);
        g.setFont(new Font("Arial",Font.BOLD, 20));
        g.drawString("Lieder", game.actualwidth/2+10, 25);
        //Scrollbar
        game.scrollBar.renderScrollbar(g);
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
            game.scrollBar.scrolling(y);
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
