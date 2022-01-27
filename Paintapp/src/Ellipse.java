
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;


/**
 *
 * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199
 */

//κλαση για το σχήμα της ελλειψης που κληρονομει χαρακτηριστικα απο την κλαση bBoundedShape
public class Ellipse extends BoundedShape{
	
	
    public Ellipse() {
        super();
    }
    
    public Ellipse(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color, fill);
    }

    public void draw( Graphics g ) {
        g.setColor(getColor());
       
       
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
       
    }  

    @Override
    void move(MouseEvent e, Shape selectedShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}