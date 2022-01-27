
/**
 *
 *  * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199

 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;


//κλαση για το σχήμα τoυ κυκλου που κληρονομει χαρακτηριστικα απο την κλαση bBoundedShape
public class Oval extends BoundedShape 
{ 
    public Oval() {
        super();
    }
    
    public Oval(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color, fill);
    }

    public void draw( Graphics g ) {
        g.setColor(getColor());
        if (getFill()) {
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else {
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }   

    @Override
    void move(MouseEvent e, Shape selectedShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}