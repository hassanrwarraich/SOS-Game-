import java.util.Scanner;
import javax.swing.*;
import cs101.sosgame.SOS;
import java.awt.*;
/**
 * runs a sos game 
 * @author Hassan raza
 * @version 31/3/2018
 */ 
public class lab5
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      final int FRAME_WIDTH = 750;
      final int FRAME_HEIGHT = 750;
      
      // variables
      JFrame frame = new JFrame();
      String name, name2;
      int size;
      SOS game;
      SOSCanvas canvas;
      SOSGUIPanel pan;
      
      // program code
      //taking names and size
      name = JOptionPane.showInputDialog(" enter name 1");
      name2 = JOptionPane.showInputDialog(" enter name 2");
      size = Integer.parseInt(JOptionPane.showInputDialog(" enter grid size"));
      
      game = new SOS(size);
      canvas = new SOSCanvas(game);
      pan = new SOSGUIPanel(game, name, name2);
      //making frame
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.add(pan);
      frame.setVisible(true); 
   }
}
