/*============================================================* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingCircle                                   *
 * Decription: class for MovingCircle objects                 *
/*============================================================*/
import java.awt.*;
public class MovingCircle extends MovingEllipse{
    Point center = new Point();
    /*======Constructors======*/
    MovingCircle(int x, int y,int size, int marginX, int marginY,Color fill, Color border, int path){
        super(x,y,size,size,marginX,marginY,fill,border,path);
        center.setLocation(x+width/2,y+height/2);}
    MovingCircle(){
        this(0,0,50,50,50,Color.pink,Color.blue,0);}
    MovingCircle(int size){
        this(0,0,size,size,size,Color.pink,Color.blue,0);}
    /*======Accessors and mutators======*/
    public void setWidth(int nee){
        if(nee<width){
            width =nee;height =nee;
        }else
            height =width;
    }
    public void setHeight(int nee){
        if(nee<width){
            width =nee;height =nee;
        }else
            height =width;
    }
}