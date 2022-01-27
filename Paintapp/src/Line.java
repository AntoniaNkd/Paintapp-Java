
/**
 *
 *  * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199

 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

//κλαση για το σχήμα της γραμμης που κληρονομει χαρακτηριστικα απο την κλαση Shape

public class Line extends Shape
{  
    public Line() {
        super();
    }
    
    public Line(int startX, int startY, int endX, int endY, Color color) {
        super(startX, startY, endX, endY, color);
    }
  
    
    public void draw( Graphics g ) {
        g.setColor(getColor());
        g.drawLine(getStartX(), getStartY(), getEndX(), getEndY());
    }

    @Override
    void move(MouseEvent e, Shape selectedShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}