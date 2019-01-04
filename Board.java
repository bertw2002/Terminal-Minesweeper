public class Board{
  private Tile[][] board; //makes the actual Board
  private int hsize; //horizontal size
  private int vsize; //vertical size
  private int numMines; //number of mines
  private int numFlags; //number of flags remaining
  public Board(int minenum, int verticalsize, int horizontalsize){ //constructor for custom board specs
    hsize = horizontalsize;
    vsize = verticalsize;
    board = new Tile[hsize][vsize];
    numMines = minenum;
  }
  public Board(String difficulty) { //constructor that implements presets based on difficulty
	if(difficulty == "easy" || difficulty == "Easy") {
		hsize = 8;
		vsize = 8;
		board = new Tile[hsize][vsize];
		numMines = 10;
	}
	else if(difficulty == "medium" || difficulty == "Medium") {
		hsize = 16;
		vsize = 16;
		board = new Tile[hsize][vsize];
		numMines = 40;
	}
	else if(difficulty == "hard" || difficulty == "Hard") {
		hsize = 32;
		vsize = 32;
		board = new Tile[hsize][vsize];
		numMines = 160;
	}
	else {
		throw new IllegalArgumentException();
	}
  }
  public Tile getTile(int xcor, int ycor){
    return board[xcor][ycor];
  }


}
