/*============================================================* /
 * UPI:        enau831                                        *
 * ID:         768485633                                      *
 * NAME:       Etienne Naude                                  *
 *                                                            *
 * File:       MovingShape                                    *
 * Decription: class for MovingShape objects                  *
/*============================================================*/
/*
 *	===============================================================================
 *	MovingShape.java : The superclass of all shapes.
 *	A shape has a point (top-left corner).
 *	A shape defines various properties, including selected, colour, width and height.
 *	===============================================================================
 */
import java.awt.*;
abstract class MovingShape implements Comparable<MovingShape>{
	Graphics g;
	public int marginWidth, marginHeight; // the margin of the animation panel area
	protected int x, y, width, height;			// the top left corner, width and height of shapes
	protected MovingPath path;			// the moving path of shapes
	protected Color borderColor, fillColor;		// the border colour of shapes
	protected boolean selected = false;	// draw handles if selected
	protected static final int DEFAULTWIDTH=100, DEFAULTHEIGHT=50, DEFAULTMARGINWIDTH=900, DEFAULTMARGINHEIGHT=600;
	protected static final Color DEFAULTFILLCOLOR=Color.blue, DEFAULTBORDERCOLOR=Color.pink;
	protected static final int DEFAULTPATH = 0;
	public MovingShape() {
		this(0, 0, DEFAULTWIDTH, DEFAULTHEIGHT, DEFAULTMARGINWIDTH, DEFAULTMARGINHEIGHT, DEFAULTBORDERCOLOR,DEFAULTFILLCOLOR, DEFAULTPATH); }
    public MovingShape(int defaultSize) { 
        this(0, 0, defaultSize, defaultSize, DEFAULTMARGINWIDTH, DEFAULTMARGINHEIGHT, DEFAULTBORDERCOLOR,DEFAULTFILLCOLOR, DEFAULTPATH);}
	public MovingShape(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		setMarginSize(marginWidth,marginHeight);
		this.x = x;this.y = y;width = w;height = h;marginWidth = mw;marginHeight = mh;borderColor = bc;fillColor = fc;setPath (pathType);}
	/*======Accessors and mutators======*/
	public int getX() { return this.x; }
	public int getY() { return this.y;}
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public int getWidth() { return width; }
	public void setWidth(int w) {width = w; }
	public int getHeight() { return height; }
	public void setHeight(int h) { height= h;}
	public boolean isSelected() { return selected; }
	public void setSelected(boolean s) { selected = s; }
	public Color getBorderColor() { return borderColor; }
	public void setBorderColor(Color c) { borderColor = c; }
	public Color getFillColor() { return fillColor; }
	public void setFillColor(Color fc) { fillColor = fc; }
	/*======returns a formatted string======*/
	public String toString() {
		return String.format("[%s: (%d, %d) of %d x %d, area=%.2f, fill=%s, border=%s, path=%s]", this.getClass().getName(), x, y, width, height, getArea(), fillColor, borderColor, path.getClass().getName());
	}
	public void setMarginSize(int w, int h) {
		marginWidth = w;
		marginHeight = h;
	}
	public int compareTo(MovingShape comp){
	    return (int) (this.getArea()-comp.getArea());
	}
	public void drawHandles(Graphics g) {
		// if the shape is selected, then draw the handles
		if (isSelected()) {
			g.setColor(Color.black);
			g.fillRect(x -2, y-2, 4, 4);
			g.fillRect(x + width -2, y + height -2, 4, 4);
			g.fillRect(x -2, y + height -2, 4, 4);
			g.fillRect(x + width -2, y-2, 4, 4);}
	}
	public abstract boolean contains(Point p);
	public abstract void draw(Graphics g);
	public abstract double getArea();
	public void setPath(int pathID) {
        switch (pathID) {
            case 0 : {
                path = new BouncingPath(1,6);
                break;}
             case 1 : {
                path = new FallingPath();
                break;}
            case 2:{
                path = new TestingPath();
                break;
            }}
    }
	public void move() {path.move();}
	abstract class MovingPath {
		protected int deltaX, deltaY; // moving distance
		public MovingPath() { }
		public abstract void move();}
	public class TestingPath extends MovingPath{
	    public void move(){
	        if (x+1 > 499){ x = 0;}
	        if (y+2 >600){y=0;}
	        x++;y+=2;
	    } 
	    TestingPath(){
	    }
	}
	public class FallingPath extends MovingPath {
		private double am = 0, stx =0, sinDeltax = 0;
		public FallingPath() {
			am = Math.random() * 20; //set amplitude variables
			stx = 0.5; //set step variables
			deltaY = 5;
			sinDeltax = 0;}
			public void move() {
		   sinDeltax = sinDeltax + stx;
		   x = (int) Math.round(x + am * Math.sin(sinDeltax));
		   y = y + deltaY;
		   if (y > marginHeight) // if it reaches the bottom of the frame, start again from the top
			   y = 0;}
	}
	public class BouncingPath extends MovingPath {
		public BouncingPath(int dx, int dy) {			deltaX = dx;			deltaY = dy;}
		public void move() {x = x + deltaX; y = y + deltaY;
			 if ((x < 0) && (deltaX < 0)) {				 
				 deltaX = -deltaX;				 x = 0;}
			 else if ((x + width > marginWidth) && (deltaX > 0)) {				 
				 deltaX = -deltaX;				 x = marginWidth - width;}
			 if ((y< 0) && (deltaY < 0)) {
				 deltaY = -deltaY;y = 0;}
			 else if((y + height > marginHeight) && (deltaY > 0)) {
				 deltaY = -deltaY; y = marginHeight - height;}}
	}

}