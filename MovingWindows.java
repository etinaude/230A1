/*------------------------------------------------------------* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingWindows                                      *
 * Decription: Decription: extra, creates a windows image     *
/*------------------------------------------------------------*/
import java.awt.*;
import javax.swing.ImageIcon;
public class MovingWindows extends MovingSquare{
    Graphics g;
    /*======Constructors======*/
    MovingWindows(int x, int y,int size, int marginX, int marginY,Color fill, Color border, int path){
        super(x,y,size,marginX,marginY,fill,border,path);}
    MovingWindows(){
        this(0,0,50,50,50,Color.pink,Color.blue,0);}
    MovingWindows(int size){
        this(0,0,size,size,size,Color.pink,Color.blue,0);}
    /*======Draws from image======*/
    public void draw( Graphics g){
        ImageIcon icon = new ImageIcon("pics/win.gif");
        Image img = icon.getImage();
        g.drawImage(img, x, y, width, height,null,null);
        Graphics2D g2 = (Graphics2D)g;
        drawHandles(g2);
    }
}