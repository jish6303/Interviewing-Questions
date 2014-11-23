/*
 Problem Description:

You are required to write code in the language of your choice implementing certain algorithms that 

analyze rectangles and features that exist among rectangles. Your implementation is required to cover 

the following:

1. Intersection: You must be able to determine whether two rectangles have one or more 

intersecting lines and produce a result identifying the points of intersection. For your 

convenience, the scenario is diagrammed in Appendix 1.

2. Containment: You must be able to determine whether a rectangle is wholly contained within 

another rectangle. For your convenience, the scenario is diagrammed in Appendix 2.

3. Adjacency: Implement the ability to detect whether two rectangles are adjacent. Adjacency is 

defined as the sharing of a side. Side sharing may be proper or sub-line, where a sub-line share 

is one where one side of rectangle A is a line that exists as a set of points wholly contained on 

some other side of rectangle B. For your convenience, the scenario is diagrammed in Appendix 

3.

Your implementation should capture the rectangle entity as well as the operations listed above. Feel 

free to expand on this problem as you wish. Document any expansion and provide it as part of your 

submission.

Your submitted source code must compile (if necessary) and the resulting executable must run on the 

Windows platform. Please document any library or framework dependencies.
 */
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class TwoMouseRec extends JFrame implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
    private final JLabel mousePosition;
    int x1, x2, y1, y2;
    int x, y, w, h;
    int count;
    int[] first = new int[4];
    int[] second = new int[4];
    private final JLabel recStart;
    private final JLabel recStop;
    private final JLabel cords; 
    private final ArrayList< Rectangle > rectangles = new ArrayList< Rectangle >();
    boolean isNewRect = true;
    public TwoMouseRec(){
    	super( "Rectangle Drawer" );
    	this.mousePosition = new JLabel();
        getContentPane().add( mousePosition, BorderLayout.SOUTH );
    	this.recStart = new JLabel();
    	getContentPane().add( this.recStart, BorderLayout.WEST );
    	this.recStop = new JLabel();
    	getContentPane().add( this.recStop, BorderLayout.EAST );
    	this.cords = new JLabel();
    	getContentPane().add( this.cords, BorderLayout.NORTH );
    	addMouseListener( this ); 
    	addMouseMotionListener( this );
    	setSize( 800, 600 );
    	setVisible( true );
    }
    public void mouseClicked( final MouseEvent event ) {
    	repaint();
    }

    public void mousePressed( final MouseEvent event ) {
    	this.mousePosition.setText( "Pressed at [" + ( this.x1 = event.getX() ) + ", " + ( this.y1 = event.getY() ) + "]" );
    	if(count<3) {
    		this.recStart.setText( "Start:  [" + this.x1 + ", " + this.y1 + "]" );
    	}
    	repaint();
    }

    public void mouseReleased( final MouseEvent event ) {
    	this.mousePosition.setText( "Released at [" + ( this.x2 = event.getX() ) + ", " + ( this.y2 = event.getY() ) + "]" );
    	if(count<3) {
    		this.recStop.setText( "End:  [" + this.x2 + ", " + this.y2 + "]" );
    	}
    	Rectangle rectangle = getRectangleFromPoints();
    	this.rectangles.add( rectangle );
    	this.w = this.h = this.x1 = this.y1 = this.x2 = this.y2 = 0;
    	this.isNewRect = true;
    	repaint();
    }

    public void mouseEntered( final MouseEvent event ) {
    	mousePosition.setText( "Mouse entered at [" + event.getX() + ", " + event.getY() + "]" );
    	repaint();
    }

    public void mouseExited( final MouseEvent event ) {
    	mousePosition.setText( "Mouse outside window" );
    	repaint();
    }

    public void mouseDragged( final MouseEvent event ) {
    	this.mousePosition.setText( "Dragged at [" + ( this.x2 = event.getX() ) + ", " + ( this.y2 = event.getY() ) + "]" ); 
    	this.isNewRect = false;
    	repaint();
    }

    public void mouseMoved( final MouseEvent event ) {
    	mousePosition.setText( "Moved at [" + event.getX() + ", " + event.getY() + "]" );
    	repaint();
    }
    private Rectangle getRectangleFromPoints() {
    	int width = this.x1 - this.x2;
    	int height = this.y1 - this.y2;
    	Rectangle rectangle = new Rectangle( width < 0 ? this.x1
    		: this.x2, height < 0 ? this.y1
    		: this.y2, Math.abs( width ), Math.abs( height ) );
    	return rectangle;
    }
    
    public boolean if_contain(){
    	if((first[0]<=second[0]&&second[0]<=first[2]
    	  &&first[0]<=second[2]&&second[2]<=first[2]
    	  &&first[1]<=second[1]&&second[1]<=first[3]
          &&first[1]<=second[3]&&second[3]<=first[3])
    	||(second[0]<=first[0]&&first[0]<=second[2]
    	 &&second[0]<=first[2]&&first[2]<=second[2]
    	 &&second[1]<=first[1]&&first[1]<=second[3]
    	 &&second[1]<=first[3]&&first[3]<=second[3]))
    	return true;
    	else return false;
    }
    public int inside(int x1, int y1, int x2, int y2, int m, int n, int p, int q){
    	int inside=0;
    	if(x1<=m&&m<=x2&&y1<=n&&n<=y2) inside++;
    	if(x1<=m&&m<=x2&&y1<=q&&q<=y2) inside++;
    	if(x1<=p&&p<=x2&&y1<=n&&n<=y2) inside++;
    	if(x1<=p&&p<=x2&&y1<=q&&q<=y2) inside++;
    	return inside;
    }
    public boolean if_section(){
    	if(((inside(first[0],first[1],first[2],first[3],second[0],second[1],second[2],second[3])<3)&&(inside(first[0],first[1],first[2],first[3],second[0],second[1],second[2],second[3])>0))
    	||((inside(second[0],second[1],second[2],second[3],first[0],first[1],first[2],first[3])<3)&&(inside(second[0],second[1],second[2],second[3],first[0],first[1],first[2],first[3])>0)))	      
    	return true;
    	else if (inside(first[0],first[1],first[2],first[3],second[0],second[1],second[2],second[3])==0){
    		if((second[0]<first[0]&&first[2]<second[2]&&first[1]<second[1]&&second[3]<first[3])
    		 ||(first[0]<second[0]&&second[2]<first[2]&&second[1]<first[1]&&first[3]<second[3]))
        return true;
    	else return false;
    	}
    	else return false;
    }
    public boolean if_adjacent(){
    	if(((second[0]==first[2]||second[2]==first[0])&&(second[3]>first[1]&&second[1]<first[3]))
    	 ||((second[1]==first[3]||second[3]==first[1])&&(second[2]>first[0]&&second[0]<first[2]))) return true;
    	else return false;
    }
    
    @Override
    public void paint( final Graphics g ) {
    	int i=0;
    	super.paint( g ); 
    	Rectangle newRectangle = getRectangleFromPoints();
    	this.cords.setText("Please draw rectangles");
    	if ( !isNewRect) {
    		g.drawRect( newRectangle.x, newRectangle.y, newRectangle.width, newRectangle.height );
    	}
    	for( Rectangle rectangle : this.rectangles ) {
    		if(i==2) {
    			isNewRect=true;
    		}
    		else{
	    		g.drawRect( rectangle.x, rectangle.y, rectangle.width, rectangle.height );
	    		i++;
	    		count=i+1;
	    		if(count==2) {
	    			this.cords.setText("First rectangles drawn.");
            		first[0]=rectangle.x;
            		first[1]=rectangle.y;
            		first[2]=rectangle.x+rectangle.width;
            		first[3]=rectangle.y+rectangle.height;
            	}
            	else if(count==3){
            		second[0]=rectangle.x;
            		second[1]=rectangle.y;
            		second[2]=rectangle.x+rectangle.width;
            		second[3]=rectangle.y+rectangle.height;
            		if(if_contain())this.cords.setText("Containment of two rectangles.");
            		else if(if_adjacent()) this.cords.setText("Adjacent of two rectangles.");
    	    		else if(if_section()) this.cords.setText("Intersection of two rectangles.");
    	    		else this.cords.setText("The two rectangles are outside of each other, no containment, adjacent or intersection found.");
            		this.mousePosition.setText("Both rectangles drawn. See result above and exit by closing the window." );
            	}
    		}
    	}

    }
    public static void main( final String args[] ) {
    	TwoMouseRec application = new TwoMouseRec();
    	application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

} 