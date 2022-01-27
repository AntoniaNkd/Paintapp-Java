
/**
 *
 * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199
 */
import java.awt.Color;
import java.awt.Graphics;

/**
 * Ειναι μια abstract κλαση ηη οποια περιέχει δεδομενα σχετικα με την σχεδιαση του τετραγωνου του ορθογωνιου
 * και του κυκλου.
 * 
 */
abstract class BoundedShape extends Shape
{
    private boolean fill; // boolean μεταβλητη για γεμισμα του σχηματος με χρωμα
    
    public BoundedShape() {
        super();
        fill = false;
    }
    
    public BoundedShape(int startX, int startY, int endX, int endY, Color color, boolean fill) {
        super(startX, startY, endX, endY, color);
        this.fill = fill;
    }
    
    

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    //μεθοδοι για ορισμο συντεταγμένων καθως και για το γεμισμα του σχήματος
  
    public int getUpperLeftX() {
        return Math.min(getStartX(), getEndX());
    }

    public int getUpperLeftY() {
        return Math.min(getStartY(), getEndY());
    }
    
    public int getWidth() {
        return Math.abs(getStartX() - getEndX());
    }
  
    public int getHeight() {
        return Math.abs(getStartY() - getEndY());
    }
    
    public boolean getFill() {
        return fill;
    }
    
    abstract public void draw( Graphics g );
}
