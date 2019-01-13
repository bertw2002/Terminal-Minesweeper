import java.util.Scanner;
import java.lang.*;
public class MineSweeper{
  private Board board; //the board (this is not a direct reference to the Tile[][] array)
  public double timer; //timer
  private String difficulty; //difficulty level if applicable
  private boolean gameOver; //is the game over?
  private double startTime; //time started
  public String prevMove; //user's previous move
  public int movesDone; //number of moves the user made so far
  public MineSweeper(String diff){
    difficulty = diff;
    board = new Board(difficulty);
	gameOver = false;
	startTime = System.currentTimeMillis();
	timer = System.currentTimeMillis() - startTime;
  movesDone = 0;
  }
  public MineSweeper(String hl, String vl) {
	 int horiz = Integer.parseInt(hl);
	 int vert = Integer.parseInt(vl);
	 board = new Board(horiz, vert);
	 gameOver = false;
	 startTime = System.currentTimeMillis();
	 timer = System.currentTimeMillis() - startTime;
   movesDone = 0;
  } //MAKE SURE TO ADD CONSTRUCTOR LETTING PLAYER CUSTOMIZE NUM OF MINES LATER!!!!!
  public boolean makeMove(String inp) {
	  if(inp.length() != 5) {System.out.println("Follow the correct move format! It's on the README"); return true;} //length of input correct?
    int rowSel = 0; //row selected
    rowSel += (inp.charAt(0) - 65) * 26; //first letter digit
    rowSel += inp.charAt(1) - 65; //second letter digit
    int colSel = 0; //col selected
    colSel += (Character.getNumericValue(inp.charAt(2))) * 10; //first num digit
    colSel += Character.getNumericValue(inp.charAt(3)); //second num digit
    if(inp.charAt(4) == 'f') { //if user chose to flag
      if(board.board[rowSel][colSel].isCleared()) {System.out.println("Tile already cleared"); return true;} //can't flag cleared tile
      board.numFlags--;
      board.board[rowSel][colSel].flag();
    }
    if(inp.charAt(4) == 'u') { //is user chose to unflag
      if(board.board[rowSel][colSel].isCleared()) {System.out.println("Can't unflag this tile"); return true;} //can't unflag clear tile
      board.numFlags++;
      board.board[rowSel][colSel].unflag();
    }
    if(inp.charAt(4) == 'c') { //if user chose to clear
      if(board.board[rowSel][colSel].isFlagged()) {System.out.println("Unflag this tile to clear"); return true;} //can't clear flagged tile
      gameOver = board.board[rowSel][colSel].clear(); //if mine hit, gameOver becomes false
	  return gameOver;
    }
    return true;
  }
  /* public void clearSpread(int x, int y){ //clears the area where the tile numbers are 0
    if (tile.getX != 0){

    }
  } */
  public String toString() {
	timer = (System.currentTimeMillis() - startTime) / 1000;
	 String s = "Time elapsed (seconds): " + timer + "\n";
	 s += board.toString();
	 s += "\n";
	 s += "Previous move: " + prevMove + "\n";
	 return s;
  }
  public static void main(String[] args) {
    String directions = ""; //prints if user does something wrong
    directions += "Requirements:" + "\n";
    directions += "1. If your input length is 1, make sure it states either hard, easy or medium. (capitals don't matter).\n";
    directions += "2. If your input length is 2, make sure it the sizes don't exceed 676 and are numbers.";
	MineSweeper game = null;
    try {
      if (args.length == 1){
		      game = new MineSweeper(args[0]);
      }
      else if (args.length == 2){
		      game = new MineSweeper(args[0], args[1]);
      }
      boolean moveVar = true; //turns false if player hits mine
	  System.out.println(game.toString());
	  System.out.print("Your move: ");
	  Scanner fm = new Scanner(System.in); //makes sure that first move is always a tile with no mines around
	  String firstmove = fm.nextLine();
	  
	  int firstmoverow = 0; //first move row selection
	  firstmoverow += (firstmove.charAt(0) - 65) * 26; //first letter digit
	  firstmoverow += firstmove.charAt(1) - 65; //second letter digit
	  int firstmovecol = 0; //first move col selection
	  firstmovecol += (Character.getNumericValue(firstmove.charAt(2))) * 10; //first num digit
      firstmovecol += Character.getNumericValue(firstmove.charAt(3)); //second num digit
	  game.board.board[firstmoverow][firstmovecol].unMine();
	  if(firstmoverow == 0) { //unMine all tiles around first tile
		 if(firstmovecol == 0) { //top left
			 
		 }
		 if(firstmovecol == (game.board.vsize - 1)) { //top right
			 
		 }
		 else { //general top
			 
		 }
	  }
	  if(firstmoverow == (game.board.hsize - 1)) {
		 if(firstmovecol == 0) { //bottom left
			 
		 }
		 if(firstmovecol == (game.board.vsize - 1)) { //bottom right
			 
		 }
		 else { //general bottom
			 
		 }
	  }
	  else {
		 if(firstmovecol == 0) {//general left
			 
		 }
		 if(firstmovecol == (game.board.vsize - 1)) { //general right
			 
		 }
		 else { //surrounded by tiles
			 
		 } 
	  }
	  
	  game.makeMove(firstmove);
	  game.prevMove = firstmove;
	  System.out.println(game.toString());
	  System.out.print("Your move: ");
      while(moveVar || (game.board.numFlags != 0 && game.board.numOpened() != (game.board.rowCount() * game.board.colCount()))) { //while the player hasn't hit a mine or hasn't opened all tiles
        Scanner sc = new Scanner(System.in);
		String nl = sc.nextLine();
        moveVar = game.makeMove(nl);
		game.prevMove = nl;
		System.out.println(game.toString());
		if(moveVar) {System.out.print("Your move: ");}
      }
	  if(!moveVar) { //if game over, mine hit
		  System.out.println("Game over! You hit a mine!");
	  }
	  else {
		 System.out.println("You win! Time: " + (game.timer / 1000) + " seconds");		 
	  }
    }
    catch (Exception e){
      System.out.println(directions);
    }
  }
}
