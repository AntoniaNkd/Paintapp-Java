
/**
 *
 * @author USER * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199
 */
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.nio.file.FileAlreadyExistsException;

//κλαση Panel που ειναι ο καμβας
public class Panel extends JPanel {

    public Shape thisShape;
    private LinkedList<Shape> shapes;
    private LinkedList<Shape> myShapes; // dynamic stack of shapes
    private LinkedList<Shape> clearedShapes; // dynamic stack of cleared shapes from undo

    // current shape variables
    private String currentShapeType; // allowed values are "Line", "Rectangle", and "Oval"
    private Shape currentShapeObject; // stores the current Shape being used
    private Color currentShapeColor; // current shape color
    private boolean currentShapeFilled; // determines whether shape is filled or not
    private String currentCopiedType;

    private JLabel statusLabel;


  //constructor
  public Panel() {
        shapes = new LinkedList<Shape>();
        myShapes = new LinkedList<Shape>();
        clearedShapes = new LinkedList<Shape>();

        // Initialize default Shape variables
        currentShapeType = "Line";
        currentShapeObject = null;
        currentShapeColor = Color.BLACK;
        currentShapeFilled = false;
        currentCopiedType = "Line";
        statusLabel = new JLabel("");

        setLayout(new BorderLayout(200, 200));
        setBackground(Color.WHITE);
        add(statusLabel, BorderLayout.SOUTH);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }


  @Override
  //μεθοδος για σχεδιαση σχηματων
  public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth(), height = getHeight();

        ArrayList<Shape> shapeArr = myShapes.getArray();
        for (int counter = shapeArr.size() - 1; counter >= 0; counter--) {
            shapeArr.get(counter).draw(g);
        }

        if (currentShapeObject != null) {
            currentShapeObject.draw(g);
        }
    }
  // μεθοδος εκκαθαρισης ολοκληρου του panel
  public void clearDrawing() {
    myShapes.makeEmpty();
    clearedShapes.makeEmpty();
    repaint();
  }

  // μεθοδος undo
  public void clearLastShape() {
    if (!myShapes.isEmpty()) {
        clearedShapes.addFront(myShapes.removeFront());
        repaint();
    }
  }

  // μεθοδος redo
  public void redoLastShape() {
    if (!clearedShapes.isEmpty()) {
        myShapes.addFront(clearedShapes.removeFront());
        repaint();
    }
  }
  
  //βιβλιογραφια https://www.dreamincode.net/forums/topic/290877-java-paint-application/
  //https://www.titanwolf.org/Network/q/c3fe5c55-807e-4d7d-9cb7-621089edd084/y
    // μεθοδος copy
   public void copy() {
        if (myShapes != null) {
            myShapes.addFront(currentShapeObject);
        } else {
            System.err.println("Nothing Selected");
        }

    }

      // μεθοδος paste
public void paste() {
        myShapes.addFront(currentShapeObject);
        currentShapeObject.draw(getGraphics());

    }

      // μεθοδος move
 /**   public void move(MouseEvent e) {
		if (thisShape != null) {
			if (thisShape.getName() == "circle") {
				cir.move(e, thisShape);
			} else if (thisShape.getName() == "rectangle") {
				rect.move(e, thisShape);
			} else if (thisShape.getName()== "line") {
				l.move(e, thisShape);
			}
			repaint();
		}
	}**/ //βιβλιοπγραφια https://www.youtube.com/watch?v=HYqODAQ2lQw
	
  // μεθοδος update νος αρχειου ζωγραφικης
  public void updatePaint(){
      
      try {
     
      String fileName = JOptionPane.showInputDialog("Enter a file name:");
    
      
      if (fileName.equals(null) || fileName.trim().equals("") ) {
        throw new Exception("Please enter a file name!");
      }

      BufferedImage image = ImageIO.read(new File("./" + fileName + ".png"));
      add(new JLabel(new ImageIcon(image)));
      image.getGraphics();
      repaint();
      
      

        
    
    }
    catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "The file was not found!");
    }
    catch (IOException e) {
      JOptionPane.showMessageDialog(null, "There was an error reading the file!");
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
       
    }
  
  
//μεθοδος για εισαγωγη αρχειου για προβολη και επεξεργασια
  public void importImageToJPanel() {
    try {
      String fileName = JOptionPane.showInputDialog("Enter a file name:");
      if (fileName.equals(null) || fileName.trim().equals("") ) {
        throw new Exception("Please enter a file name!");
      }

      BufferedImage image = ImageIO.read(new File("./" + fileName + ".png"));
      add(new JLabel(new ImageIcon(image)));
    }
    catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "The file was not found!");
    }
    catch (IOException e) {
      JOptionPane.showMessageDialog(null, "There was an error reading the file!");
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }

  //μεθοδος για αποθήκευση εικονας
  public void exportImageFromJPanel() {
    try {
      String fileName = JOptionPane.showInputDialog("Enter a file name:");

      if (fileName.equals(null) || fileName.trim().equals("") ) {
        throw new Exception("Please enter a file name!");
      }

      File file = new File("./" + fileName + ".png");
      
      if (file.exists()) {
        throw new FileAlreadyExistsException("File already exists.");
      }

      BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
      paint(img.createGraphics());
      
      ImageIO.write(img, "PNG", file);
    }
    catch (FileAlreadyExistsException e) {
      JOptionPane.showMessageDialog(null, "This file already exists");
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }

  //μεθοδοι σχετικα με ταχαρακτηριστικα του σχηματος και την αντιγραφη σχημτος

  public void setCurrentShapeType(String type) {
    currentShapeType = type;
  }

  public void setCurrentShapeColor(Color color) {
      currentShapeColor = color;
  }

  public void setCurrentShapeFilled(boolean filled) {
      currentShapeFilled = filled;
  }
  public void setCopied(String type) {
        currentCopiedType = type;
    }


    
//κλαση για διαχειριση συντεταγμενων
   private class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent event) {
            switch (currentShapeType) {
                case "Line":
                    currentShapeObject = new Line(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor);
                    break;
                case "Rectangle":
                    currentShapeObject = new Rectangle(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
                    break;
                case "Oval":
                    currentShapeObject = new Oval(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
                    break;
                case "Ellipse":
                    currentShapeObject = new Ellipse(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
                    break;
                case "Square":
                    currentShapeObject = new Square(event.getX(), event.getY(),
                            event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
                    break;
            }
            //ελεγχος για την επικολληση με τις νεες συντεταγμενες
            if (currentCopiedType.equals("Paste")) {
                ArrayList<Shape> myArray = myShapes.getArray();
                if (currentShapeType == "Line") {
                    currentShapeObject = new Line(event.getX(), event.getY(), event.getX() + myArray.get(0).getEndX() - myArray.get(0).getStartX(), event.getY() + myArray.get(0).getEndY() - myArray.get(0).getStartY(), myArray.get(0).getColor());
                } else if (currentShapeType == "Rectangle") {
                    currentShapeObject = new Rectangle(event.getX(), event.getY(), event.getX() + myArray.get(0).getEndX() - myArray.get(0).getStartX(), event.getY() + myArray.get(0).getEndY() - myArray.get(0).getStartY(), myArray.get(0).getColor(), currentShapeFilled);
                } else if (currentShapeType == "Oval") {
                    currentShapeObject = new Oval(event.getX(), event.getY(), event.getX() + myArray.get(0).getEndX() - myArray.get(0).getStartX(), event.getY() + myArray.get(0).getEndY() - myArray.get(0).getStartY(), myArray.get(0).getColor(), currentShapeFilled);
                } else if (currentShapeType == "Ellipse") {
                    currentShapeObject = new Ellipse(event.getX(), event.getY(), event.getX() + myArray.get(0).getEndX() - myArray.get(0).getStartX(), event.getY() + myArray.get(0).getEndY() - myArray.get(0).getStartY(), myArray.get(0).getColor(), currentShapeFilled);
                }
                else if (currentShapeType == "Square") {
                    currentShapeObject = new Square(event.getX(), event.getY(), event.getX() + myArray.get(0).getEndX() - myArray.get(0).getStartX(), event.getY() + myArray.get(0).getEndY() - myArray.get(0).getStartY(), myArray.get(0).getColor(), currentShapeFilled);
                }
                myShapes.addFront(currentShapeObject);
                currentShapeObject = null;
                currentCopiedType=null;
                clearedShapes.makeEmpty();
                repaint();

            }
        }


    public void mouseReleased(MouseEvent event)
    {
        currentShapeObject.setEndX(event.getX());//το σχημα που ζωγραφιζει ο χρηστης παιρνει τις συντεταγμενες του mouse
        currentShapeObject.setEndY(event.getY());
        
        myShapes.addFront(currentShapeObject);//το σχημα αποθηκευεται σε λισταΣ
        
        currentShapeObject = null;
        clearedShapes.makeEmpty();
        repaint();
    }

    public void mouseMoved(MouseEvent event)
    {
        statusLabel.setText(String.format("Mouse Coordinates X: %d Y: %d", event.getX(), event.getY()));//συντεταγμενες του mouse
    }

    public void mouseDragged(MouseEvent event)
    {
        currentShapeObject.setEndX(event.getX());//το σχημα που ζωγραφιζει ο χρηστης παιρνει τις συντεταγμενες του mouse
        currentShapeObject.setEndY(event.getY());
        
        statusLabel.setText(String.format("Mouse Coordinates X: %d Y: %d", event.getX(), event.getY()));
        
        repaint();
    }
  }
}
