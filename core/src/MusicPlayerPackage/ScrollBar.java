package MusicPlayerPackage;

import java.awt.*;

/**
 * Created by Daniel on 01.04.2017.
 */
public class ScrollBar {
    MainMusicPlayer game;
    int totalLengthinPx = 0;
    int actualscrollerposition = 35;
    int bottomscrollerposition;
    int scrollerDistance;
    boolean holding = false;
    boolean scrollable = false;
    ScrollBar(MainMusicPlayer game){
        this.game = game;
        bottomscrollerposition = actualscrollerposition+totalLengthinPx/(game.actualheight-35);
    }
    public void renderScrollbar(Graphics2D g) {
        updateScrollbar();
        g.setColor(new Color(0.2f,0.2f,0.2f,0.5f));
        g.fillRect(game.actualwidth-24, 35,23,totalLengthinPx);
        g.setColor(Color.BLACK);
        g.drawRect(game.actualwidth-25, 35,23,totalLengthinPx);
        g.setColor(new Color(0.1f,0.1f,0.1f,0.7f));
        g.fillRect(game.actualwidth-24, actualscrollerposition, 24, totalLengthinPx/(game.actualheight-35));
    }

    public void updateScrollbar(){
        totalLengthinPx = game.lieder.totalSizeInPx;
    }
    public void scrolling(int mouseY){
        int oldMouseY = mouseY;
        if (holding){
            if(actualscrollerposition< 35){
                actualscrollerposition = 35;
                bottomscrollerposition = (actualscrollerposition+totalLengthinPx/(game.actualheight-35));
                holding = false;
                return;
            }
            if(bottomscrollerposition > game.actualheight-37){
                actualscrollerposition = game.actualheight-37-(totalLengthinPx/(game.actualheight-35));
                bottomscrollerposition = (actualscrollerposition+totalLengthinPx/(game.actualheight-35));
                holding = false;
                return;
            }
            actualscrollerposition = mouseY-35-scrollerDistance;
            bottomscrollerposition = (actualscrollerposition+totalLengthinPx/(game.actualheight-35));}

    }

    public void scrollWithMouseWheel(int a){
        System.out.println(a);
        if(scrollable){
            if(a<0){
                if(actualscrollerposition > 35){
                actualscrollerposition = actualscrollerposition-2;
                bottomscrollerposition = bottomscrollerposition-2;
                }
                else{
                    actualscrollerposition = 35;
                    bottomscrollerposition = (actualscrollerposition+totalLengthinPx/(game.actualheight-35));
                    scrollable = false;
                }

            }
            else if(a>0){
                if(bottomscrollerposition < game.actualheight-37){
                    actualscrollerposition = actualscrollerposition+2;
                    bottomscrollerposition = bottomscrollerposition+2;
                }
                else {
                    actualscrollerposition = game.actualheight-37-(totalLengthinPx/(game.actualheight-35));
                    bottomscrollerposition = (actualscrollerposition+totalLengthinPx/(game.actualheight-35));
                    scrollable = false;
                }
            }

        }

    }
    public void getScrollerDistance(int mouseY){
        scrollerDistance = mouseY-actualscrollerposition-35;
    }

    public boolean scollBarPointed(int mouseX,int mouseY){
        if(mouseX> game.actualwidth-20 && mouseX<game.actualwidth && mouseY> actualscrollerposition+30 && mouseY<actualscrollerposition+totalLengthinPx/(game.actualheight-35)+30){
            return true;
        }
        else{
        }
        return false;
    }

    public boolean fieldPointed(int mouseX, int mouseY){
        if(mouseX> game.actualwidth/2 && mouseX<game.actualwidth && mouseY> 0 && mouseY<game.actualheight){
            return true;
        }
        else{
        }
        return false;
    }
}
