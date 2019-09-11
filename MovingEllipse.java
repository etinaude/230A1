/*============================================================* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                        FIX THIS CLASS                      *
 * File:       MovingEllipse                                  *
 * Decription: class for MovingEllipse objects                *
/*============================================================*/
import java.awt.*;
public class MovingEllipse extends MovingShape{
    Point center = new Point();
    Graphics g;
    /*======Constructors======*/
    MovingEllipse(int x, int y,int width, int height, int marginX, int marginY,Color fill, Color border, int path){
        super(x,y,width,height,marginX,marginY,fill,border,path);
        center.setLocation(x+width/2,y+height/2);}
    MovingEllipse(){
        this(0,0,100,50,100,50,Color.blue,Color.pink,0);}
    MovingEllipse(int size){
        this(0,0,size,size,size,size,Color.pink,Color.blue,0);}
    /*======draws oval fill and outline======*/
    public void draw(Graphics g){
        g.setColor(borderColor);
        g.drawOval((int)x, (int) y, width,height); 
        g.setColor(fillColor);
        g.fillOval((int)x, (int) y, width,height);  
        Graphics2D g2 = (Graphics2D)g;
        drawHandles(g2); 
    }
    public double getArea(){return Math.PI*((width/2*height/2));}
    public boolean contains(Point other){
        if(other.getX() > x && other.getY() > y)
            if(other.getX() < x+width && other.getY() < this.y+height){
                double dx, dy;
                Point EndPt = new Point((int)x + width, (int)y + height);
                dx = (2 * other.getX() - x - EndPt.x) / (double) width;
                dy = (2 * other.getY() - y - EndPt.y) / (double) height;
                return dx * dx + dy * dy < 1.0; 
            }
        return false;
    }
}