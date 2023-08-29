# Connect4
Implemented graphic user interface, mode-view-controller design pattern, multi-threading, and Java to recreate the classic board game Connect 4. 

__Game Settings/Rules:__ This is a two player game in which each player gets 21 one color disks. This means one player gets the red disks while the other player gets the yellow disks. The goal of this game is to drop a disk into any column in order to connect four of your disks. This means there are 3 ways you can connect the four disks: vertically, horizontally, and diagonally. This program will have a rule added. That is the users only have 10 seconds to decide where the disk should drop. After 10 seconds the disk will drop on the column currently below it. In this game player 1 holds the red disks while player 2 holds the yellow disks. If each player plays their disk before the 10 seconds the timer will restart and count to 10 when the next round starts. 

There will be 8 classes to implement. Here is a brief description of what each class will do:

**View:** A class that implements the Graphic User Interface

**Model:** A class that holds the data of the game. The class will hold the data of the disks for each player and will hold the data on where players place their disks. 

**Controller:** A class that will extend Thread and implement ActionListener. This classic controls the game operation and checks when the game should end. 

**LeftArrow:** A class that extends AbstractAction that moves the disk to the left of the GUI. 

**RightArrow:** A class that extends AbstractAction that moves the disk to the right of the GUI.

**DownArrow:** A class that extends AbstractAction that moves the disk down to a column. 

**TimesOut:** A class that extends Thread and acts like a timer. It will hold the ability to count to 10 in order to drop the disk in the column if the user does not decide where to place their disk. 

**ConnectFourGame:** A class that creates the View, Model, TimesOut, and Controller objects. The class starts the threads and sets the GUI visible.

