# TerminalMinesweeper
Julian Wong &amp; Albert Wan (APCS final project)





Development log
----------------------------
# 03.01.2019
Albert: Today, I added the isopen method to the tile class. Then I made the board class and created the fields and made the constructor and getTile() method.

Julian: Today, I made the tile class and I added the constructor and made the flag(), toString(), clear() (unsure), gTN(), and sTN() methods. 

# 04.01.2019
Julian: Today, I edited the constructors for the Board class, adding the Tile initialization function for the Tile[][] board, and fixed some bugs here and there.

Albert: Today, I made the Minesweeper class and started writing the class variables and started the constructor. I also made the toString for the board class. Not sure if it works though.

# 05.01.2019
Albert: Today, I made the driver class and tested the Tile class, and made some fixes so it should be fully working now. I also tweaked the board constructors so they don't include number of mines.

# 06.01.2019
Julian: Today, finished assignNumbers() (not tested) and and put some exception handling in the board constructor. Also, I added the scanner with currenttimemillis in the Minesweeper class.

Albert: Today, I fixed the board class so it should be fully working. (Haven't tested yet) I also fixed an error in the toString for the board class, but I still have to work on the horizontal locators. 

# 07.01.2019
Albert: Today, I decided to make the horizontal locators letters instead of numbers because they are too clunky and made the change. Also, I tweaked the board constructor so that capitals don't matter making life easier for the player.

Julian: Today, I updated the constructors for Board and Minesweeper, worked on user inputs for starting the game using args[] in MineSweeper's main method, and started writing the makeMove() method for MineSweeper which processes the user's moves

# 08.01.2019
Albert: Today, I changed the toString for board so it can include a much larger range. It can go from 27^2 vertically to 99 horizontally.

Julian: Today, I finished writing the makeMove() method in MineSweeper that processes the user's move input (what they type in to make a move) and wrote a new method isCleared() in Tile.

# 09.01.2019
Julian: Today, I finalized makeMove() (method that handles user's move inputs) and worked on receiving user inputs using the Scanner class in main().

# 10.01.2019
Albert: Today, I started the clearSpread() method which clears tiles with no mines around them. I also added a getx and gety to the tile class to make life easier. 

# 11.01.2019
Julian: Today, I wrote the case the winning the game in the minesweeper main() and edited the acess modifiers of some class variables to make writing code easier.

Albert: Today, I made a change to the tile class, adding isOpen. Also, I finished coding clearSpread and the helper method isZero. 
