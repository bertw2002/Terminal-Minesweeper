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
  public int getmovesDone(){
    return movesDone;
  }
  public void minusmovesDone(){
    movesDone--;
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
	  if(inp.length() != 5) {System.out.println("Follow the correct move format! It's on the README"); minusmovesDone();return false;} //length of input correct?
    int rowSel = 0; //row selected
    rowSel += (inp.charAt(0) - 65) * 26; //first letter digit
    rowSel += inp.charAt(1) - 65; //second letter digit
    int colSel = 0; //col selected
    colSel += (Character.getNumericValue(inp.charAt(2))) * 10; //first num digit
    colSel += Character.getNumericValue(inp.charAt(3)); //second num digit
    if(inp.charAt(4) == 'f') { //if user chose to flag
      if(board.board[rowSel][colSel].isCleared()) {System.out.println("Tile already cleared"); minusmovesDone(); return false;} //can't flag cleared tile
      board.numFlags--;
      board.board[rowSel][colSel].flag();
    }
    if(inp.charAt(4) == 'u') { //is user chose to unflag
      if(board.board[rowSel][colSel].isCleared()) {System.out.println("Can't unflag this tile"); minusmovesDone(); return false;} //can't unflag clear tile
      board.numFlags++;
      board.board[rowSel][colSel].unflag();
    }
    if(inp.charAt(4) == 'c') { //if user chose to clear
      if (board.board[rowSel][colSel].isFlagged()) {System.out.println("Unflag this tile to clear"); minusmovesDone(); return false;} //can't clear flagged tile
      if (movesDone == 0){
        int x = board.getHsize();
        int y = board.getVsize();
        while (board.board[rowSel][colSel].isMine() || board.board[rowSel][colSel].getTileNum() != 0){
          board = new Board(x, y);
        }

      }else{
        if (board.board[colSel][rowSel].isMine()){

          return true; //if mine hit, gameOver becomes false
        }
      }


      board.clearSpread(colSel, rowSel);
      movesDone++;
	    return false;
    }

    return false;
  }
/*
  public int turnindex(String twonumber){ //turns the input value into a readable index. Number version.
    int firstnum = Integer.parseInt(twonumber.substring(0, 1));
    int secnum = Integer.parseInt(twonumber.substring(1, 2));
    int returnval = 0;
    returnval += firstnum * 10;
    returnval += secnum;
    return returnval;
  }
  public int turnindexalph(String twoalph){//turns the input value into a readable index. alphabet version.
    char firstc = twoalph.charAt(0);
    char sec = twoalph.charAt(1);
    int firstnum = Character.getNumericValue(firstc) % 65;
    int secnum = Character.getNumericValue(sec) % 65;
    int returnval = 0;
    returnval += firstnum * 10;
    returnval += secnum;
    return returnval;
  }*/
  public String toString() {
	 String s = "Time elapsed (seconds): " + timer + "\n";
	 s += board.toString();
	 s += "\n";
	 s += "Previous move: " + prevMove + "\n";
	 return s;
  }

//--------
  // need function to display all mines after loss
//--------
  public void allOpen(){
    for (int x = 0; x < board.getHsize(); x++){
      for (int y = 0; y < board.getVsize();y++){
        board.getTile(x, y).setOpen();
      }
    }

  }

  public static void main(String[] args) {
    String directions = ""; //prints if user does something wrong
    directions += "Requirements for starting the game:" + "\n";
    directions += "1. If your input length is 1, make sure it states either hard, easy or medium. (capitals don't matter).\n";
    directions += "2. If your input length is 2, make sure it the sizes don't exceed 27 or are letters.\n\n";
    directions += "Requirements during the game:\n";
    directions += "1. String input needs to be 5 characters long.\n";
    directions += "2. First 2 inputs are capital letters and next 2 are numbers, and last is either f, u, or c.\n";

	  MineSweeper game = null;
    try {
      if (args.length == 1){
		      game = new MineSweeper(args[0]);
      }
      else if (args.length == 2){
		      game = new MineSweeper(args[0], args[1]);
      }
      boolean moveVar = false; //turns false if player hits mine
	    System.out.println(game.toString());
      while(!moveVar) { //while the player hasn't hit a mine or hasn't opened all tiles
      //^^ still have to make more restrictions. Dont forget.
        Scanner sc = new Scanner(System.in);
		    String nl = sc.nextLine();
        moveVar = game.makeMove(nl);

		    game.prevMove = nl;
		    System.out.println(game.toString());
        //still have to implement a congrats if they win.
      }
      game.allOpen();
      System.out.println(game.toString());
		  System.out.println("Game over! You hit a mine!");

    }
    catch (Exception e){
      System.out.println(directions);
    }
  }

}
