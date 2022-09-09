/*
 * class Model holds the data of the game. It stores the number of disks per player and distinguishes
 * where the player places their disks per round. 
 */
public class Model
{
   public int redDisks, yellowDisks;
   public String [][] grid;
   
   /*
    * Constructor initializes the in variables and 2 dimensional string array. 
    */
   Model()
   {
      redDisks = 21;
      yellowDisks = 21;
      grid = new String[6][7];
      
      for(int row = 0; row < 6; row++)
      {
         for(int col = 0; col < 7; col++)
         {
            grid[row][col] = "empty";
         }
      }
   }
   /*
    * resetBoard "resets" the board when a new game starts. 
    */
   public void resetBoard()
   {
      redDisks = 21;
      yellowDisks = 21;
      
      grid = new String [6][7];
      
      for(int row = 0; row < 6; row++)
      {
         for(int col = 0; col < 7; col++)
         {
            grid[row][col] = "empty";
         }
      }
   }
   /*
    * redDisk sets the disk in the game board based on the column that the player or timer picks. 
    * 
    * @param column
    */
   public int redDisk(int column)
   {
      int row = 0; 
      
      boolean empty = true;
      
    
      for(int r = 5; r >= 0; r--)
      {
         if(grid[r][column] == "empty" && empty == true)
         {
            grid[r][column] = "red";
            row = r;
            empty = false;
            redDisks --;
         }     
      }
 
      return row;
   }
   /*
    * yellowDisk sets the disk in the game board based on the column that the player or timer picks. 
    * 
    * @param column
    */
   public int yellowDisk(int column)
   {
      int row = 0; 
      
      boolean empty = true;
      
      for(int r = 5; r >= 0; r--)
      {
            
         if(grid[r][column] == "empty" && empty == true)
         {
            grid[r][column] = "yellow";
            row = r;
            empty = false;
            yellowDisks --;
          }
       }
      return row;
   }
   /*
    * checkVerticalHorizontal checks if there are 4 connected disks either vertically or horizontally based 
    * on a selected player's disk by using for loops. Returns true if found 4 connect disks. False is not found.
    * 
    * @param disk
    */
   public boolean checkVerticalHorizontal(String disk)
   {
      int fourDisks = 0;
      
      for(int row = 0; row < 6; row++ )
      {
        
         for(int column = 0; column < 7; column ++)
         {  
            if(grid[row][column] == disk)
            {
              fourDisks ++;
              
              if(fourDisks == 4)
              {
                 return true;
              }
            }
            else
            {
               fourDisks = 0;
            }
         }
      }

      fourDisks = 0;
       
      for(int column = 0; column < 7; column++ )
      {
            
         for(int row = 0; row < 6; row ++)
         {
            if(grid[row][column] == disk)
            {
               fourDisks++;
                  
               if(fourDisks == 4)
               {
                  return true;
               }
            }
            else
            {
               fourDisks = 0;
            }
         }
      }
      
      return false;
   }
   /*
    * checkMinDiagonally checks if there are 4 connected disks minimum diagonally based 
    * on a selected player's disk by using for loops. Returns true if found 4 connect disks. False is not found.
    * 
    * @param disk
    */
   public boolean checkMinDiagonally(String disk)
   {
      int fourDisks = 0;
      
      for(int row = 0; row < 6; row++ )
      {
        if(grid[row][row] == disk)
        {   
          fourDisks++;
          
          if(fourDisks == 4)
          {
             return true;
          }
        }
        else
        {
           fourDisks = 0;
        }
      }
      
      fourDisks = 0;

      for(int row = 1; row < 6; row++ )
      {
           
            
         if(grid[row][row] == disk)
         {
            fourDisks++;
            if(fourDisks == 4)
            {
               return true;
            }
         } 
         else
         {
            fourDisks = 0;
         }
      }
    
      fourDisks = 0;
         
      for(int row = 2; row < 6; row++ )
      {
           
         if(grid[row][Math.abs(2-row)] == disk)
         {
            fourDisks++;
            if(fourDisks == 4)
            {
               return true;
            }
         }
         else
         {
            fourDisks = 0;
         }

      }
        
      fourDisks = 0;
 

      for(int row = 0; row < 6; row++ )
      {
            
         if(grid[row][row+1] == disk)
         {
            fourDisks++;
            if(fourDisks == 4)
            {
               return true;
            }
         }
         else
         {
            fourDisks = 0;
         }
      }

      fourDisks = 0;
            
      for(int row = 0; row < 5; row++ )
      {
            
         if(grid[row][row+1] == disk)
         {
            fourDisks++;
            if(fourDisks == 4)
            {
               return true;
            }
         }
         else
         {
            fourDisks = 0;
         }
      }

      fourDisks = 0;
         
      for(int row = 0; row < 4; row++ )
      {
            
         if(grid[row][row+1] == disk)
         {
            fourDisks++;
              
            if(fourDisks == 4)
            {
               return true;
            }
         }
         else
         {
            fourDisks = 0;
         }
      }

      return false;
   }
   /*
    * checkMaxDiagonally checks if there are 4 connected disks maximum diagonally based 
    * on a selected player's disk by using for loops. Returns true if found 4 connect disks. False is not found.
    * 
    * @param disk
    */
   public boolean checkMaxDiagonally(String disk)
   {
      int fourDisks = 0;
      
      for(int row = 0; row < 6; row++ )
      {
         
         
        if(grid[row][6-row] == disk)
        {
           fourDisks++;
           
           if(fourDisks == 4)
           {
              return true;
           }
        }
        else
        {
           fourDisks = 0;
        }
      }

      fourDisks = 0;
      
      for(int row = 1; row < 6; row++ )
      {
        if(grid[row][7-row] == disk)
        {
           fourDisks++;
           
           if(fourDisks == 4)
           {
              return true;
           }
        }
        else
        {
           fourDisks = 0;
        }
      }
      
      fourDisks = 0;
      
      for(int row = 2; row < 6; row++ )
      {
        
        if(grid[row][8-row] == disk)
        {
           fourDisks++;
           
           if(fourDisks == 4)
           {
              return true;
           }
        }
        else
        {
           fourDisks = 0;
        }
      }

      fourDisks = 0;
      
      
      for(int row = 0; row < 6; row++ )
      {
       
        if(grid[row][5-row] == disk)
        {
           fourDisks++;
           
           if(fourDisks == 4)
           {
              return true;
           }
        }
        else
        {
           fourDisks = 0;
        }

      }
      
  
      fourDisks = 0;

      for(int row = 0; row < 5; row++ )
      {
         
        if(grid[row][4-row] == disk)
        {
           fourDisks++;
           
           if(fourDisks == 4)
           {
              return true;
           }
        }
        else
        {
           fourDisks = 0;
        }

      }

      fourDisks = 0;
      
      for(int row = 0; row < 4; row++ )
      {
        if(grid[row][3-row] == disk)
        {
           fourDisks++;
           
           if(fourDisks == 4)
           {
              return true;
           }
        }
        else
        {
           fourDisks = 0;
        }

      }   
   
      return false;
   }
}
   



