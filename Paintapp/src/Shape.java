

/**
 *
 *  * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199

 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

//κλαση γιαγενικα χαρακτηριστικα των σχημάτων

abstract class Shape {
  private int startX, startY, endX, endY;
  private Color color;

  public Shape() {
    startX = 0; startY = 0; endX = 0; endY = 0;
    color = Color.BLACK;
  }

  public Shape(int startX, int startY, int endX, int endY, Color color) {
      this.startX = startX;
      this.startY = startY;
      this.endX = endX;
      this.endY = endY;
      this.color = color;
  }

 //μεθοδοι set-get για διαχειριση συντεταγμένων και περιγραμματος

  public void setStartX(int startX) {
    this.startX = startX;
  }

  public void setEndX(int endX) {
    this.endX = endX;
  }

  public void setStartY(int startY) {
    this.startY = startY;
  }

  public void setEndY(int endY) {
    this.endY = endY;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  

  public int getStartX() {
    return startX;
  }

  public int getEndX() {
    return endX;
  }

  public int getStartY() {
    return startY;
  }

  public int getEndY() {
    return endY;
  }
 
  public Color getColor() {
      return color;
  }
  
  public int getX()
  {
      return startX + startY;
  }

  abstract public void draw( Graphics g );
  
  abstract void move(MouseEvent e, Shape selectedShape);
}
