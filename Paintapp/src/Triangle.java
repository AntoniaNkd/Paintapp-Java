
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199
*/
//bibliografia https://www.techwalla.com/articles/how-to-draw-triangles-in-java
//κλαση για το σχήμα του τριγώνου που κληρονομει χαρακτηριστικα απο την κλαση Shape
public class Triangle extends Shape
{ 
    
    protected int height;
	protected int width;
        protected Color color;
	
	public Triangle(int width, int height, Color color)
	{
		this.height = height;
		this.width= width;
		this.color= color;
		
		
	}
	public void draw(Graphics g, Point location)
	{
		g.setColor(color);
		Point point2 = new Point(location.x+width,location.y);
		Point point3 = new Point(location.x+(width/2),location.y - height);
		g.drawLine(location.x,location.y,point2.x,point2.y);
		g.drawLine(location.x,location.y,point3.x,point3.y);
		g.drawLine(point2.x,point2.y,point3.x,point3.y);
					
	}

    
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void move(MouseEvent e, Shape selectedShape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}