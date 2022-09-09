import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionListener;
/*
 * Class Controller extends Thread and implements Actionlistener. The class calls methods from the View and Model objects. Controls
 * the two thread (this and TimesOut). Lastly, it hold classes that creates the key actions.
 */
public class Controller extends Thread implements ActionListener
{
   private View theView;
   private Model theModel;
   private TimesOut theTimer;
   
   private Action LeftArrow;
   private Action RightArrow;
   private Action DownArrow;

   private int col = 0;
   private int player = 1;
   
   /*
    * Constructor sets the objects (View, Model, Timer) and sets up the key bindings to move the disks. 
    */
   Controller(View view, Model model, TimesOut timer)
   {
      theView = view;
      theModel = model;
      theTimer = timer;
      
      LeftArrow = new LeftArrow();
      RightArrow  = new RightArrow();
      DownArrow = new DownArrow();
      theView.disk.getActionMap().put("left", LeftArrow);
      theView.disk.getActionMap().put("right", RightArrow);
      theView.disk.getActionMap().put("down", DownArrow);
      theView.playAgain.addActionListener(this);

   }
   /*
    * starts Controller and TimesOut thread
    */
   public void startThreads()
   {
      this.start();
      theTimer.start();
   }
   /*
    * run method when Controller thread starts.
    */
   @Override
   public void run()
   { 
      if(theTimer.seconds == 10)
      {
         timesOut();
         theTimer.seconds = 0;
      }   
      
      doNothing();
      run();
   }
   /*
    * doNothing calls sleep method
    */
   public void doNothing()
   {
      try
      {
         Thread.sleep(1000);
         
      }
      catch(InterruptedException e){
        
      }
   }
   /*
    * checkGrid checks to see if a player has connected four disks. Displays winner and
    * suspends Controller and TimesOut thread if there is a winner.
    * 
    * @param player
    */
   public void checkGrid(int player)
   {
      if(player == 1)
      {
         if(theModel.checkVerticalHorizontal("red"))
         {
            theView.displayWinner(player);
            theTimer.suspend();
            this.suspend();
         }
         else if (theModel.checkMinDiagonally("red"))
         {
            theView.displayWinner(player);
            theTimer.suspend();
            this.suspend();
         }
         else if (theModel.checkMaxDiagonally("red"))
         {
            theView.displayWinner(player);
            theTimer.interrupt();
            theTimer.suspend();
            this.suspend();
         }
 
      }
      else
      {
         if(theModel.checkVerticalHorizontal("yellow"))
         {
            theView.displayWinner(player);
            theTimer.suspend();
            this.suspend();
         }
         else if (theModel.checkMinDiagonally("yellow"))
         {
            theView.displayWinner(player);  
            theTimer.suspend();
            this.suspend();
         }
         else if (theModel.checkMaxDiagonally("yellow"))
         {
            theView.displayWinner(player);
            theTimer.suspend();
            this.suspend();
         }
      }
      
      if(theModel.redDisks == 0 || theModel.yellowDisks == 0)
      {
         theView.displayWinner(0);
         theTimer.suspend();
         this.suspend();
      }
     
   }
   /*
    * timesOut places the disk in the column below the disk at 10 seconds if player has not picked a column. 
    */
   public void timesOut()
   {
      if(player == 1)
      {
         if(theModel.grid[0][Math.abs(col)] == "empty" && theModel.redDisks !=0)
         {
            theView.setRed(theModel.redDisk(col), col);
            checkGrid(player);
 
         }
         player = 2;
         theView.setDisk(player);
         col = 0;
      }
      
      else
      {
         if(theModel.grid[0][Math.abs(col)] == "empty" && theModel.yellowDisks !=0)
         {
            theView.setYellow(theModel.yellowDisk(col), col);
            checkGrid(player);
         }
       
         player = 1;
         theView.setDisk(player);
         col = 0;
      }
      
      if(theModel.redDisks == 0 || theModel.yellowDisks ==0)
      {
         theView.displayWinner(0);
         theTimer.suspend();
         this.suspend();
      }
   }
   /*
    * actionPerformed for button "Play Again" will resume thread and "reset" the game. 
    */
   @Override
   public void actionPerformed(ActionEvent e)
   {
      //Resetting timer
      theTimer.seconds = 0;
      theTimer.resume();
      this.resume();
      
      //Resetting data board
      theModel.resetBoard();
      
      //Restarting GUI
      theView.dispose();
      theView = new View();
      
      
      theView.disk.setVisible(true);
      theView.disk.getActionMap().put("left", LeftArrow);
      theView.disk.getActionMap().put("right", RightArrow);
      theView.disk.getActionMap().put("down", DownArrow);
      theView.playAgain.addActionListener(this);

      theView.setVisible(true);
   }
   
   /*
    * Class LeftArrow extends AbstractAction to implements the key action of moving the 
    * disk to the left of the GUI. 
    */
   public class LeftArrow extends AbstractAction
   {

      @Override
      public void actionPerformed(ActionEvent e)
      {
         // TODO Auto-generated method stub
        if(theView.disk.getX()-98 >=0)
        {
           theView.disk.setLocation(theView.disk.getX()-98,theView.disk.getY());    
           col -= 1; 
        }
        else
        {
           theView.disk.setLocation(theView.disk.getX(),theView.disk.getY());
           col = 0;
        }
      }
      
   }
   /*
    * Class RightArrow extends AbstractAction to implement the key action of moving
    * the disk to the right of the GUI.
    */
   public class RightArrow extends AbstractAction
   {

      @Override
      public void actionPerformed(ActionEvent e)
      {
         // TODO Auto-generated method stub
         
         if(theView.disk.getX()+98 <= 588)
         {
            theView.disk.setLocation(theView.disk.getX()+98,theView.disk.getY());
            col += 1;
         }
         else
         {
            theView.disk.setLocation(theView.disk.getX(),theView.disk.getY());
            col = 6;
         }              
      }
   }
   /*
    * DownArrow extends AbstractAction to implement the key action of moving the disk down the column "Game Board."
    * 
    */
   public class DownArrow extends AbstractAction
   {

      @Override
      public void actionPerformed(ActionEvent e)
      {
       
         // TODO Auto-generated method stub
         if(player == 1)
         {
            if(theModel.grid[0][Math.abs(col)] == "empty")
            {
               theView.setRed(theModel.redDisk(col), col);
               checkGrid(player);
               player = 2;
               theView.setDisk(player);
               theModel.checkMinDiagonally("red");
               col = 0;
            }
            else
            {
               col = Math.abs(col);
            }
         }
         else
         {
            if(theModel.grid[0][Math.abs(col)] == "empty")
            {
               theView.setYellow(theModel.yellowDisk(col), col);
               checkGrid(player);
               player = 1;
               theView.setDisk(player);
               theModel.checkMinDiagonally("yellow");
               col = 0;
               
            }
            else
            {
               col = Math.abs(col);
            }
         }
         theTimer.seconds = 0;
      }
   }
}
