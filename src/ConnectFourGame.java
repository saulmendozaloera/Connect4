/*
 * Class ConnectFourGame creates the objects View, Model, TimesOut, and Controller.
 * Calls the method from the controller, startThreads, to start the multithreading. 
 * Sets GUI visible. 
 */
public class ConnectFourGame
{

   public static void main(String[] args)
   {
      View theView = new View();
      Model theModel = new Model();
      TimesOut theTimer = new TimesOut();
      Controller theController = new Controller(theView, theModel, theTimer);
      
      theController.startThreads();
      
      theView.setVisible(true);

   }

}
