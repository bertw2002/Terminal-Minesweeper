import java.util.Random;
public class Board{
  private Tile[][] board; //makes the actual Board
  private int hsize; //horizontal size
  private int vsize; //vertical size
  private int numFlags; //number of flags remaining
  public Board(int verticalsize, int horizontalsize){ //constructor for custom board specs
    hsize = horizontalsize;
    vsize = verticalsize;
    board = new Tile[hsize][vsize];
    int ri = 0;
    Random rn = new Random();
    boolean mineGen = false;
    for(int q = 0; q < hsize; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < vsize; w++) {
            ri = rn.nextInt() % 64 + 1;
            mineGen = false;
            if(ri < 10) {mineGen = true;}
            board[q][w] = new Tile(mineGen, q, w);
        }
    }

  }
  public Board(String difficulty) { //constructor that implements presets based on difficulty
	if(difficulty == "easy" || difficulty == "Easy") {
		hsize = 8;
		vsize = 8;
		board = new Tile[hsize][vsize];
	}
	else if(difficulty == "medium" || difficulty == "Medium") {
		hsize = 16;
		vsize = 16;
		board = new Tile[hsize][vsize];
	}
	else if(difficulty == "hard" || difficulty == "Hard") {
		hsize = 32;
		vsize = 32;
		board = new Tile[hsize][vsize];
	}
	else { //if the user types something bad
		throw new IllegalArgumentException();
	}
	int ri = 0; //same as constructor above, initializes each tile
    Random rn = new Random();
    boolean mineGen = false;
    for(int q = 0; q < hsize; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < vsize; w++) {
            ri = rn.nextInt() % 64;
            mineGen = false;
            if(ri < 10) {mineGen = true;}
            board[q][w] = new Tile(mineGen, q, w);
        }
    }

  }
  public Tile getTile(int xcor, int ycor){
    return board[xcor][ycor];
  }
  public String toString(){
    String sboard = "  "; //string version of board
    int counter = 1;
    char alphabet = 'A';
    for (int hor = 0; hor < hsize; hor ++){
      sboard += counter; //creates horizontal locator in numbers
      counter ++;
    }
    for (int x = 0; x < hsize; x ++){
      sboard += alphabet; //creates vertical locator in letters
      sboard += "|";
      for (int y = 0; y < vsize; y ++){
        sboard += board[x][y].toString();
      }
      alphabet ++;
      sboard += "|" + "\n";
    }
    return sboard;
  }

}
