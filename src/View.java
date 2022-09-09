import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Font;
/*
 * Class View extends JFrame. Class sets the GUI. 
 */
public class View extends JFrame
{
   private JPanel theGame, theDisks, theOther;
   private ImageIcon gameBoard, redDisk, yellowDisk;
   
   public JLabel[][] grid; 
   public JLabel disk, winner;
   public JButton playAgain;
   /*
    * Constructor create the ImageIcons, JFrame, JPanels, JLabels and JButtons
    */
   public View()
   {
      super();
      
      //Set ImageIcons
      gameBoard = new ImageIcon("images/board.png");
      redDisk = new ImageIcon("images/redDisk.png");
      yellowDisk = new ImageIcon("images/yellowDisk.png");
      
      //Set size of GUI
      setSize(gameBoard.getIconWidth()*7,gameBoard.getIconHeight()*7);
      setResizable(false);
      
      //Set layout, location, and default close operation of GUI
      setLayout(new BorderLayout());
      
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      //Create the board
      theGame = new JPanel();
      
      theGame.setLayout(new GridLayout(6,7));
      theGame.setSize(gameBoard.getIconWidth()*7,gameBoard.getIconHeight()*6);
   
      grid = new JLabel[6][7];
      
      //Setting up the board. 
      for(int row=0; row<6; row++)
      {
         for(int col=0; col<7; col++)
         {
            grid[row][col] = new JLabel();
            grid[row][col].setIcon(gameBoard);
            theGame.add(grid[row][col]);
         }
      }
      
      add(theGame, BorderLayout.CENTER);
      
      //Create the bottom panel that will display the Winner and Play Again button. 
      theOther = new JPanel();
      
      theOther.setLayout(new GridLayout(1,2));
      
      winner = new JLabel();
      winner.setText("Winner: ");
      winner.setFont(new Font("Verdana", Font.BOLD, 20));
      
      playAgain = new JButton();
      playAgain.setText("Play Again");
      playAgain.setFont(new Font("Verdana", Font.BOLD, 20));
      
      theOther.add(winner);
      theOther.add(playAgain);

      add(theOther, BorderLayout.SOUTH);
      
      //Create the top panel that will display the moving red and yellow disk. 
      theDisks = new  JPanel();
      
      disk = new JLabel();
      theDisks.setLayout(new GridLayout());
     
      disk.setIcon(redDisk);
      
      //Set the keystrokes for the moving disks
      disk.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
      disk.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
      disk.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
      
      theDisks.add(disk);
      add(theDisks, BorderLayout.NORTH);
      
   } 
   /*
    * setRed sets the red disk on the board.
    * 
    * @param row
    * @param column
    */
   public void setRed(int row, int column)
   {
      grid[row][column].setBackground(Color.RED);
      grid[row][column].setOpaque(true);
      grid[row][column].revalidate();
      grid[row][column].repaint();
   }
   /*
    * setYellow sets the yellow disk on the board
    * 
    * @param row
    * @param column
    */
   public void setYellow(int row, int column)
   {
      grid[row][column].setBackground(Color.YELLOW);
      grid[row][column].setOpaque(true);
      grid[row][column].revalidate();
      grid[row][column].repaint();
   }
   /*
    * setDisk sets the correct colored disk based on the player's turn. 
    * 
    * @param player
    */
   public void setDisk(int player)
   {
      if(player == 1)
      {
         disk.setIcon(redDisk);
      }
      else
      {
         disk.setIcon(yellowDisk);
      }
   }
   /*
    * displayWinner displays the winner if they got 4 disks in a row. 
    * 
    * @param player
    */
   public void displayWinner(int player)
   {
      if(player == 1)
      {
         winner.setText("Winner: " + "Player 1!");
      }
      else if (player == 2)
      {
         winner.setText("Winner: " + "Player 2!");
      }
      else
      {
         winner.setText("Tie!");
      }
      
      disk.setVisible(false);
   }
}
