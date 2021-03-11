import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;
/**
 * panel making complete panel of sos game
 */
public class SOSGUIPanel extends JComponent 
{
   // properties
   private JRadioButton s;
   private JRadioButton o;
   private ButtonGroup bg;
   private SOSCanvas canvas;
   private SOS sos;
   private JPanel panel;
   private JLabel label, label2;
   private MyMouseListener mouse;
   private String name, name2;
   
   // constructors
   /**
    * constructor
    * @param a SOS object and names of players
    */
   public SOSGUIPanel (SOS dim, String nam, String nam2)
   {
      name = nam;
      name2 = nam2;
      sos = dim;
      
      this.setLayout(new BorderLayout());
      
      
      //setting rdio buttons
      s = new JRadioButton("s");
      o = new JRadioButton("o");
      bg = new ButtonGroup();
      bg.add(s);
      bg.add(o);
      o.setSelected(true);
      
      //setting labels for names and scores
      label = new JLabel(name + " : " + sos.getPlayerScore1());
      label2 = new JLabel(name2 + " : " + sos.getPlayerScore2());
      label.setOpaque(true);
      label.setBackground(Color.pink);
      //panel to which scores and names are added
      panel = new JPanel();
      panel.setLayout(new GridLayout(1, 4));
      panel.add(label);
      panel.add(s);
      panel.add(o);
      panel.add(label2);
      
      //making the sosCanvas
      canvas = new SOSCanvas(dim);
      mouse = new MyMouseListener();
      canvas.addMouseListener(mouse);
      
      //adding every thing to frame
      this.add(canvas, BorderLayout.CENTER);
      this.add(panel, BorderLayout.SOUTH);
      
      repaint();
      
   }
   
   // methods
   /**
    * @returns the char of currently selected radio button 
    */
   public char getSelected()
   {
      if (s.getModel() == bg.getSelection())
         return 's';
      else
         return 'o';
   }
   
   /**
    * inner class of mouse listener when mouse is clicked 
    */
   public class MyMouseListener implements MouseListener
   {
      /**
       * method when mouse ýs clicked
       * @param the mouse event
       */
      public void mousePressed(MouseEvent e)
      {
         int row = 0;
         int col = 0;
         //getting square in which mouse clicked
         row = ((e.getX() / 100) + 1);
         col = ((e.getY() / 100) + 1);
         //playing the turn
         sos.play(getSelected(), col, row);
         
         //getting which players turn it is and seting its name color
         if (sos.getTurn() == 1)
         {
            label2.setBackground(Color.white);
            label.setBackground(Color.pink);
         }
         else {
            label2.setOpaque(true);
            label.setBackground(Color.white);
            label2.setBackground(Color.pink);
         }
         
         //updating score and turn
         label.setText(name + " : " + sos.getPlayerScore1());
         label2.setText(name2 + " : " + sos.getPlayerScore2());
         
         
         //when game is over giving the winners
         if (sos.isGameOver())
         {
            //if player 1 is winner
            if (sos.getPlayerScore1() > sos.getPlayerScore2())
            {
               JOptionPane.showConfirmDialog(null,
                                             "winner is: " + name + "\n Press ok to exit.",
                                             "Game Over!",
                                             JOptionPane.DEFAULT_OPTION,
                                             JOptionPane.PLAIN_MESSAGE);
            }
            //if player 2 is winner
            if (sos.getPlayerScore1() < sos.getPlayerScore2())
            {
               JOptionPane.showConfirmDialog(null,
                                             "winner is: " + name2 + "\n Press ok to exit.",
                                             "Game Over!",
                                             JOptionPane.DEFAULT_OPTION,
                                             JOptionPane.PLAIN_MESSAGE);
            }
            //if it is a draw
            if (sos.getPlayerScore1() == sos.getPlayerScore2())
            {
               JOptionPane.showConfirmDialog(null,
                                             "it is a draw \n Press ok to exit.",
                                             "Game Over!",
                                             JOptionPane.DEFAULT_OPTION,
                                             JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
         }
         
         repaint();
      }
      
      public void mouseReleased(MouseEvent e)
      {}
      public void mouseEntered(MouseEvent e)
      {}
      public void mouseExited(MouseEvent e)
      {}
      public void mouseClicked(MouseEvent e)
      {}
   }
   
}
