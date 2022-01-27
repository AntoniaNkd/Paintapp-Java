
/**
 *
 * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199
 */
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

//κλαση frame  οποια περιεχει ολες της επιλογες μενου και τα γραφικά
public class Frame extends JFrame
{
  private JMenuBar menuBar = new JMenuBar();

  private JMenu fileMenu = new JMenu("File");
  private String[] fileOptions = {"Undo", "Redo", "Copy", "Paste", "Move", "Clear", "Export To", "Import From"};

  private JMenu shapeMenu = new JMenu("Shapes");
  private String[] shapeOptions = {"Line", "Rectangle", "Triagle", "Oval", "Ellipse", "Square"};

  private JMenu methodMenu = new JMenu("Method");
  private String[] methodOptions = {"Fill", "Draw"};

  private JPanel colorPanel = new JPanel();
  private String[] colors = {"Black", "Red", "Green", "Blue", "Magenta"};

  Panel panel = new Panel();
  
//constructor
  public Frame()
  {
    super("Paint Program");

    setJMenuBar(menuBar);

    colorPanel.setLayout(new GridLayout( 1, 6, 10, 10 ));
    add(colorPanel, BorderLayout.NORTH);
    
    add(panel, BorderLayout.CENTER);

    addButtonsToJPanel(colorPanel, colors);

    addMenuItemsToJMenu(fileMenu, fileOptions);
    addMenuItemsToJMenu(shapeMenu, shapeOptions);
    addMenuItemsToJMenu(methodMenu, methodOptions);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setVisible(true);
    
  };
    
  
//μεθοδος για εισαγωγη των μενου στο frame
 public void addMenuItemsToJMenu(JMenu menu, String[] arr) {
    MenuHandler handler = new MenuHandler();
    for (int i = 0; i < arr.length; i++) {
      JMenuItem menuItem = new JMenuItem(arr[i]);
      menu.add(menuItem);
      menuItem.addActionListener(handler);
    }
    menuBar.add(menu);
  }
//μεθοδος για εισαγωγη των buttons στο frame
   public void addButtonsToJPanel(JPanel panel, String[] arr) {
    ColorHandler handler = new ColorHandler();
    for (int i = 0; i < arr.length; i++) {
      JButton button = new JButton(arr[i]);
      button.addActionListener(handler);
      colorPanel.add(button);
    }
  }
//μεθοδος διαχειρισης χρωματων
  private class ColorHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String actionCommand = event.getActionCommand();
      switch (actionCommand) {
        case "Black":
          panel.setCurrentShapeColor(Color.BLACK);
          break;
        case "Red":
          panel.setCurrentShapeColor(Color.RED);
          break;
        case "Green":
          panel.setCurrentShapeColor(Color.GREEN);
          break;
        case "Blue":
          panel.setCurrentShapeColor(Color.BLUE);
          break;
       
        case "Magenta":
          panel.setCurrentShapeColor(Color.MAGENTA);
          break;
       
      }
    }
  }
//μεθοδος διαχειρισης επιλογων
 private class MenuHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        switch (actionCommand) {
            case "Undo":
                panel.clearLastShape();
                break;
            case "Redo":
                panel.redoLastShape();
                break;
            case "Copy":
                panel.copy();
                break;
            case "Paste":
                panel.setCopied("Paste");
                break;    
            case "Clear":
                panel.clearDrawing();
                break;
               
            case "Export To":
                panel.exportImageFromJPanel();
                break;
            case "Import From":
                panel.updatePaint();
                break;
            case "Line":
                panel.setCurrentShapeType("Line");
                break;
            case "Rectangle":
                panel.setCurrentShapeType("Rectangle");
                break;
            case "Triangle":
                panel.setCurrentShapeType("Triangle");
                break;
            case "Oval":
                panel.setCurrentShapeType("Oval");
                break;
            case "Ellipse":
                panel.setCurrentShapeType("Ellipse");
                break;
            case "Square":
                panel.setCurrentShapeType("Square");
                break;
            case "Fill":
                panel.setCurrentShapeFilled(true);
                break;
            case "Draw":
                panel.setCurrentShapeFilled(false);
                break;
        }
    }
  }
}
