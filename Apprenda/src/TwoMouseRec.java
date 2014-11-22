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
    	this.recStart = new JLabel();
    	getContentPane().add( this.recStart, BorderLayout.WEST );
    	this.recStop = new JLabel();
    	getContentPane().add( this.recStop, BorderLayout.EAST );
    	this.cords = new JLabel();
    	getContentPane().add( this.cords, BorderLayout.NORTH );
    	//if(count==3) getContentPane().add("Please restart", BorderLayout.SOUTH );
    	addMouseListener( this ); // listens for own mouse and
    	addMouseMotionListener( this ); // mouse-motion events
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
    	repaint();
    }

    public void mouseExited( final MouseEvent event ) {
    	repaint();
    }

    public void mouseDragged( final MouseEvent event ) {
    	this.mousePosition.setText( "Dragged at [" + ( this.x2 = event.getX() ) + ", " + ( this.y2 = event.getY() ) + "]" ); 
    	this.isNewRect = false;
    	repaint();
    }

    public void mouseMoved( final MouseEvent event ) {  	
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
    	if((first[0]<second[0]&&second[0]<first[2]
    	 &&first[0]<second[2]&&second[2]<first[2]
    	 &&first[1]<second[1]&&second[1]<first[3]
         &&first[1]<second[3]&&second[3]<first[3])
    	||(second[0]<first[0]&&first[0]<second[2]
    	 &&second[0]<first[2]&&first[2]<second[2]
    	 &&second[1]<first[1]&&first[1]<second[3]
    	 &&second[1]<first[3]&&first[3]<second[3]))
    	return true;
    	else return false;
    }
    
    @Override
    public void paint( final Graphics g ) {
    	int i=0;
    	super.paint( g ); 
    	Rectangle newRectangle = getRectangleFromPoints();
    	if ( !isNewRect) {
    		g.drawRect( newRectangle.x, newRectangle.y, newRectangle.width, newRectangle.height );
    	}
    	for( Rectangle rectangle : this.rectangles ) {
    		if(i==2) {
    			if(if_contain())this.cords.setText("contain, please restart");
    			isNewRect=true;
    		}
    		else{
	    		g.drawRect( rectangle.x, rectangle.y, rectangle.width, rectangle.height );
	    		i++;
	    		count=i+1;
	    		if(count==2) {
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
            		//this.cords.setText(" "+ second[3]);
            	}
	    		this.cords.setText("Rectangle "+ i);
    		}
    	}

    }
    public static void main( final String args[] ) {
    	TwoMouseRec application = new TwoMouseRec();
    	application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

} 


