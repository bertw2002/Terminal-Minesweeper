import java.util.Scanner;
import java.lang.*;
public class MineSweeper{
  private Board board; //the board (this is not a direct reference to the Tile[][] array)
  public double timer; //timer
  private String difficulty; //difficulty level if applicable
  private boolean gameOver; //is the game over?
  private double startTime; //time started
  private String prevMove; //user's previous move
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
    }
    return true;
  }
  public void clearSpread(int x, int y){ //clears the area where the tile numbers are 0
    if (tile.getX != 0){

    }
  }
  public static void main(String[] args) {
    String directions = ""; //prints if user does something wrong
    directions += "Requirements:" + "\n";
    directions += "1. If your input length is 1, make sure it states either hard, easy or medium. (capitals don't matter).\n";
    directions += "2. If your input length is 2, make sure it the sizes don't exceed 27 or are letters.";
    try {
      if (args.length == 1){
		      MineSweeper game = new MineSweeper(args[0]);
      }
      else if (args.length == 2){
		      MineSweeper game = new MineSweeper(args[0], args[1]);
      }
      boolean moveVar = true; //turns false if player hits mine
      while(moveVar) {
        Scanner sc = new Scanner(System.in);
        moveVar = game.makeMove(sc.nextLine());
      }
    }
    catch (Exception e){
      System.out.println(directions);
    }
  }
}
