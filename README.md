# TerminalMinesweeper
Julian Wong &amp; Albert Wan 

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


