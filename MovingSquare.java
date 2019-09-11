/*============================================================* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingSquare                                   *
 * Decription: class for MovingSquare objects                 *
/*============================================================*/
import java.awt.*;
class MovingSquare extends MovingRectangle{
    /*======Constructors======*/
    MovingSquare(int x, int y,int size, int marginX, int marginY,Color fill, Color border, int path){
        super(x,y,size,size,size,size,fill,border,path);}
    MovingSquare(){
        this(0,0,50,50,50,Color.pink,Color.blue,0);}
    MovingSquare(int size){
        this(0,0,size,size,size,Color.pink,Color.blue,0);}
    /*======Accessors and mutators======*/
        public void setWidth(int nee){
        if(nee<height){
            width =nee;height =nee;
        }else
            width =height;
    }
    public void setHeight(int nee){
        if(nee<width){
            width =nee;height =nee;
        }else
            height =width;
    }
}