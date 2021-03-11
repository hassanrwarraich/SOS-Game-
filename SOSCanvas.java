import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;

/**
 * class making grid for sos game
 */
public class SOSCanvas extends JComponent
{
   // properties
   private SOS sos;
   
   // constructors
   /**
    * constructor
    * @param a SOS object
    */
   public SOSCanvas(SOS dim)
   {
      sos = dim;
      repaint();
   }
   
   // methods
   /**
    * method making the grid
    * @param Graphics object
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      final int LABEL_LENGTH = 50;
      final int LABEL_WIDTH = 50;
      int rowS = 100;
      int colS = 100;
      int dotX = 50;
      int dotY = 50;
      //loop for rows
      for (int i = 0; i < sos.getDimension(); i++)
      {
         //loop for cols
         for (int j = 0; j < sos.getDimension(); j++)
         {
            g.drawRect(i * rowS, j * colS, rowS, colS);
            //setting what is written inside rectangle (s or o)
            JLabel label = new JLabel();
            label.setText("" + sos.getCellContents(i, j));
            label.setBounds(dotX, dotY, LABEL_LENGTH, LABEL_WIDTH);
            this.add(label);
            dotX = dotX + 100; 
         }
         dotX = 50;
         dotY = dotY + 100;
      }
      
      repaint();
   }
}


