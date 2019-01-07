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
  public static void main(String[] args){
  }
}
