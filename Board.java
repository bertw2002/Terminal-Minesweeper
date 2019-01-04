public class Board{
  private Tile[][] board; //makes the actual Board
  private int hsize; //horizontal size
  private int vsize; //vertical size
  private int numMines; //number of mines
  private int numFlags; //number of flags remaining
  public Board(int minenum, int flagnum, int verticalsize, int horizontalsize){
    hsize = horizontalsize;
    vsize = verticalsize;
    board = new Tile[hsize][vsize];
    numMines = minenum;
    numFlags = flagnum;
  }
  public Tile getTile(int xcor, int ycor){
    return board[xcor][ycor];
  }


}
