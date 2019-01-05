public class MineSweeper{
  private Board board;
  private double timer;
  private String difficulty;
  public MineSweeper(String diff){
    difficulty = diff;
    board = new Board(difficulty);
  }
  public static void main(String[] args){
  }
}
