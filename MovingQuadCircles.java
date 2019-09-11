/*------------------------------------------------------------* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingQuadCircles                              *
 * Decription: class for MovingQuadCircles objects            *
/*------------------------------------------------------------*/
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
public class MovingQuadCircles extends MovingCircle{
    Graphics g;
    /*======Constructors======*/
    MovingQuadCircles(int x, int y,int size, int marginX, int marginY,Color fill, Color border, int path){
        super(x,y,size,marginX,marginY,fill,border,path);
        center.setLocation(x+width/2,y+height/2);}
    MovingQuadCircles(){
        this(0,0,50,50,50,Color.pink,Color.blue,0);}
    MovingQuadCircles(int size){
        this(0,0,size,size,size,Color.pink,Color.blue,0);}
    /*======Draws from image======*/
    public void draw( Graphics g){
        Area c1,c2,c3,c4;
        Area b1,b2;
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(borderColor);
        //vertical
        g.drawOval((int)x+width/4, (int) y, width/2,height/2);
        c1 = new Area(new Ellipse2D.Double((int)x+width/4, (int) y, width/2,height/2));
        b1 = new Area(new Ellipse2D.Double((int)x+width/4, (int) y, width/2,height/2));
        g.drawOval((int)x+width/4, (int) y+height/2, width/2,height/2); 
        c2 = new Area(new Ellipse2D.Double((int)x+width/4, (int) y+height/2, width/2,height/2));
        b2 = new Area(new Ellipse2D.Double((int)x+width/4, (int) y+height/2, width/2,height/2));
        //horizontal
        g.drawOval((int)x+width/2, (int) y+height/4, width/2,height/2);
        c3 = new Area(new Ellipse2D.Double((int)x+width/2, (int) y+height/4, width/2,height/2));
        g.drawOval((int)x, (int) y+height/4, width/2,height/2); 
        c4 = new Area(new Ellipse2D.Double((int)x, (int) y+height/4, width/2,height/2));

        g.setColor(fillColor); 
        b1.intersect(c3);
        g2.fill(b1);
        c1.intersect(c4);
        g2.fill(c1);
        b2.intersect(c3);
        g2.fill(b2);
        c2.intersect(c4);
        g2.fill(c2);
        drawHandles(g2); 
    }
}