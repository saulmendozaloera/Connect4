/*
 * Class TimesOut extends Thread and overrides the run method to start the 10 second timer. 
 */
public class TimesOut extends Thread
{
   public int seconds = 0;

   /*
    * Run method increments seconds and calls doNothing and run method.
    */
   @Override
   public void run()
   {
        seconds++;
        
        doNothing();
        run();
   }
   /*
    * doNothing method calls sleep method. 
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
   

}
