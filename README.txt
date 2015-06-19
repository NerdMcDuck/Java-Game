Name of Game: Knight McKrispie

LONG README PLEASE READ BEFORE DOING ANYTHING!!! 
***HERE I'M ASSUMING THAT YOU KNOW HOW TO SAVE AND COMPILE IN JAVA SINCE THIS IS WRITTEN IN JAVA***

I originally made this because we had to create a game for my Comp Sci class. Now that that's done with, I will keep working on it as a side project. Furthermore, game will not run unless lines 16, 29 and 41 are changed to the location of the folder. So, it would be "/XX/XX/Java Project Game/Zelda_Main_Theme_Song.wav". Same goes for the other lines mentioned above. I would just be easier to save the folder to the Desktop and just change the name after "Users/". Then save and compile. 

: I have a windows PC but it should work on MAC also. To run  just compile it like any other java program -javac Movie.java- and run it the same way -java Movie- . Must be compiled in the same folder that all the resources are located in. Easy way to open command Prompt  on a PC in the same folder, SHIFT + right click + "open command window here".

:No outside packages requirements. Just the IO, Animation, and Sprite java files given to us by the proffessor. Those are in the folder as well. 

: The game is a mix of cinematic and interactivity. The interactivity is very limited. All prompts and game events will show up on the console (command prompt). You interact with the game by typing where you want the player to move, "right", "left", "up", "down". The command prompt will tell you which commands are valid depending on where you are in the game. 

:The goal of the player is to get to the end, defeat the final boss and get your rice krispies back. 

: You win when you defeat the final boss and get your rice krispies.

: You lose if you touch the first enemy after acquiring your sword. You will be given options, you must overcome that enemy without touching him or else you lose. Hint: The first enemy is more like a puzzle, you must input the correct combinations of commands or else you lose THERE ARE MULTIPLE WAYS TO GET ON THE SAME SPACE AS THE ENEMY SPRITE. 
When you reach the first enemy, to overcome the enemy, here is the command:

right(mandatory command), right, up, right, down, right, up, right, right

You may also lose if you don't move correctly during the final boss fight. 

In order to beat this boss, you MUST move forward (answer YES - not case sensitive) or else you lose.

You will know you lost because you will get a "Game Over" screen. 

: The only issue that I couldn't figure out is at the first enemy counter (not the knight). Here if you go "right" then go "left" then jump which is the "up" command then fall "down" command, the game will get stuck in the loop. THERE IS MORE THAN ONE WAY TO BREAK THE GAME!!! I'm still working out the bugs in it. If you after going "right" you go "left" then "right" again, it won't break the game. 

Also, on top of the Hill, if you go "down" instead of "right", IT WILL NOT WORK. This is intended. You must be on top of the hill then give the "right" command. The sprite will go down and proceed. If you do give the "down" command, you give the "up" command to get back to the top of the hill. 
HAVE FUN!