# TerminalMinesweeper
Julian Wong &amp; Albert Wan (APCS final project)

# Directions

# Starting a game
How to start a game:
After compiling the MineSweeper.java class, choose your game settings.
There are two options:
java MineSweeper (difficulty), (i.e. java MineSweeper easy) or
java MineSweeper (row count) (column count), (i.e. java MineSweeper 40 40)

-------------
Difficulties:
Easy: 8x8 board

Medium: 16x16 board

Hard: 26x26 board

Custom board dimensions:
Any integer greater than 1 and less than 676 for both rows and columns.

# Playing the game

How to play:
After each move and after you start the game, the board will print on your terminal screen.
This is when you type in your move.

The rows are labeled AA, AB, AC, AD... AZ, BA, BB, BC, etc.

The columns are numbered 01, 02, 03...

Move syntax is as follows:
(row)(column)(action)

Flags placed before the first clear move don't count.

-------------
There are three actions:

Clear: clears a tile, similarly to left-clicking it. If you clear a mine tile, the game is over. (In move syntax this is 'c')

Flag: Places a flag on a tile. (In move syntax this is 'f')

Unflag: Removes a flag from a tile. (In move syntax this is 'u')

-------------
Example moves:

AJ14c (This means that you cleared tile in row AJ and in column 14.)

BK35f (This means that you put a flag down on tile in row BK and in column 35.)

AN26u (This means that you removed a flag from tile in row AN and in column 26.)

-------------
What each tile character means on the board:

(_): Unopened tile

(>): Flagged tile

(@): Mine (only shows up at game over)

( ): Zero tile (tile with no mines around it)
 
(number 1-8): Tile with (number) mines around it

-------------
That's all, enjoy!

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

Julian: Today, I had to rewrite some code because the changes I pushed in school didn't push to this repo for some reason.

# 11.01.2019
Julian: Today, I wrote the case the winning the game in the minesweeper main() and edited the acess modifiers of some class variables to make writing code easier.

Albert: Today, I made a change to the tile class, adding isOpen. Also, I finished coding clearSpread and the helper method isZero. I haven't tested it yet.

# 12.01.2019
Albert: Today, I fixed some errors in the tile class, fixed the horizontal locators in the tostring in the board class, fixed tile numbers so it is displayed correctly, and the clearSpread finally works. I merged my branch into the main.

# 13.01.2019
Julian: Today, I organized the minesweeper code and started writing the code that makes the first move always result in a clear tile. I also wrote Tile method unMine() which turns a tile into a non-mine.

Albert: Today, I finished Julian's code so that minesweeper runs without errors and clearSpread can run without errors. Also, I added a method which makes all tiles open after hitting a mine.

# 14.01.2019
Julian: Today, I wrote the Minesweeper gameOverClear() method and changed the characters for flagged tiles and mine tiles. I also wrote some code that was later fixed by Albert that had an intended purpose of ensuring that the first selected tile would always be a clear, zero tile.
