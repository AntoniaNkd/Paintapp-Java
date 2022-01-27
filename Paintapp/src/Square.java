/**
 *
 *  * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

//κλαση για το σχήμα του ορθογωνιου που κληρονομει χαρακτηριστικα απο την κλαση bBoundedShape
public class Square extends BoundedShape
{ 
    public Square() {
        super();
    }

    public Square(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color, fill);
    }
    
 
    public void draw( Graphics g ) {
        g.setColor(getColor());
        if (getFill()) {
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else {
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }

    @Override
    void move(MouseEvent e, Shape selectedShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

