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
    	if(count<3) this.recStart.setText( "Start:  [" + this.x1 + ", " + this.y1 + "]" );
    	repaint();
    }

    public void mouseReleased( final MouseEvent event ) {
    	this.mousePosition.setText( "Released at [" + ( this.x2 = event.getX() ) + ", " + ( this.y2 = event.getY() ) + "]" );
    	if(count<3) this.recStop.setText( "End:  [" + this.x2 + ", " + this.y2 + "]" );
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

    @Override
    public void paint( final Graphics g ) {
    	int i=0;
    	super.paint( g ); 
    	g.drawString( "Start Rec Here", this.x1, this.y1 );
    	g.drawString( "End Rec Here", this.x2, this.y2 );

    	Rectangle newRectangle = getRectangleFromPoints();
    	if ( !isNewRect && i<2 ) {
    		g.drawRect( newRectangle.x, newRectangle.y, newRectangle.width, newRectangle.height );
    	}
    	
    	for( Rectangle rectangle : this.rectangles ) {
    		if(i==2) {
    			this.cords.setText("Please Restart");
    			isNewRect=true;
    		}
    		else{
	    		g.drawRect( rectangle.x, rectangle.y, rectangle.width, rectangle.height );
	    		i++;
	    		count=i+1;
	    		this.cords.setText("Iteration: "+ i);
    		}
    	}

    }
    public static void main( final String args[] ) {
    	TwoMouseRec application = new TwoMouseRec();
    	application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

} 


