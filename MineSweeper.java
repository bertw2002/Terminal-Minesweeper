import java.util.Scanner;
import java.lang.*;
public class MineSweeper{
  private Board board;
  private double timer;
  private String difficulty;
  private boolean gameOver;
  private double startTime;
  public MineSweeper(String diff){
    difficulty = diff;
    board = new Board(difficulty);
	gameOver = false;
	startTime = System.currentTimeMillis();
	timer = System.currentTimeMillis() - startTime;
  }
  public MineSweeper(String hl, String vl) {
	 int horiz = Integer.parseInt(hl);
	 int vert = Integer.parseInt(vl);
	 board = new Board(horiz, vert);
	 gameOver = false;
	 startTime = System.currentTimeMillis();
	 timer = System.currentTimeMillis() - startTime;
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
      board.numFlags--;
      board[rowSel][colSel].flag();
    }
    if(inp.charAt(4) == 'u') {
      if(board[rowSel][colSel].isCleared()) {System.out.println("Can't unflag this tile"); return true;}
      board.numFlags++;
      board[rowSel][colSel].unflag();
    }
    if(inp.charAt(4) == 'c') {

    }
    return true;
  }
  public static void main(String[] args) {
    String directions = "";
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
    }
    catch (Exception e){
      System.out.println(directions);
    }
  }
}
