/*============================================================* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingPixelArt                                 *
 * Decription: class for MovingPixelArt objects               *
/*============================================================*/
import java.awt.*;
public class MovingPixelArt extends MovingSquare{
    /*======values for color matrix======*/
    private String[] values={"01234","12340","23401","34012","40123"};
    private Color[] colors = {Color.white,Color.green,Color.blue,Color.red,Color.black};
    Graphics g;
    /*======Constructors======*/
    MovingPixelArt(int x, int y,int size, int marginX, int marginY,Color fill, Color border, int path){
        super(x,y,size,size,size,fill,border,path);
        size = x/values.length;
    }
    MovingPixelArt(){this(0,0,50,50,50,Color.pink,Color.blue,0);}
    MovingPixelArt(int size){this(0,0,size,size,size,Color.pink,Color.blue,0);}
    /*======draws the pixel array======*/
    public void draw(Graphics g){
        int wid = width/values[0].length();
        int hei = height/values.length;
        Graphics2D g2 = (Graphics2D)g;
        drawHandles(g2);
        for (int i=0;i<values.length;i++){
            for (int k=0; k< values[i].length();k++){
                int here = Integer.parseInt(values[i].substring(k,k+1));
                g.setColor(colors[here]);
                g.fillRect(x+(wid*k), y+(hei*i), wid,hei);}}
    }
}