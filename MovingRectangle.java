/*============================================================* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingRectangle                                *
 * Decription: class for MovingRectangle objects              *
/*============================================================*/
import java.awt.*;
class MovingRectangle extends MovingShape{
    /*======Constructors======*/
    MovingRectangle(int x, int y,int width, int height, int xmarg, int ymarg,Color fill, Color border, int path){
        super(x,y,width,height,xmarg,ymarg,fill,border,path);}
    MovingRectangle(){
        this(0,0,100,50,1000,2000,Color.blue,Color.pink,0);}
    MovingRectangle(int size){
        this(0,0,size,size,0,0,Color.blue,Color.pink,0);}
    /*======Draws a fill rect and an outline rect======*/
    public void draw( Graphics g){
        g.setColor(fillColor);
        g.fillRect((int)x, (int) y, width,height);   
        g.setColor(borderColor);
        g.drawRect((int)x, (int) y, width,height);   
        Graphics2D g2 = (Graphics2D)g;
        drawHandles(g2);
    }
    /*======returns the area======*/
    public double getArea(){return width*height;}
    /*======returns a boolean for if a point is in the rectangle======*/
    public boolean contains(Point other){
        if(other.getX() > x && other.getY() > y)
        if(other.getX() < x+width && other.getY()-height < y){
            System.out.println(other);
            System.out.println(y);
                return true;}
        return false;
    }
}