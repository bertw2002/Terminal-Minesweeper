import java.util.Random;
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
    int ri = 0;
    Random rn = new Random();
    boolean mineGen = false;
    for(int q = 0; q < hsize; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < vsize; w++) {
            ri = rn.nextInt() % 64;
            if(numMines == 0) {break;}
            mineGen = false;
            if(ri < 10) {mineGen = true; numMines--;}
            board[q][w] = new Tile(mineGen, q, w);
        }
        if(numMines == 0) {break;}
    }
    if(numMines > 0) {// if there are still mines left to place down, run through board[][] again and place the rest down
        for(int q = 0; q < hsize; q++) {
            for(int w = 0; w < vsize; w++) {
                if(numMines == 0) {break;}
                ri = rn.nextInt() % 64;
                if(!board[q][w].isMine()) {
                    if(ri < 20) {board[q][w].setMine(); numMines--;}
                }
            }
            if(numMines == 0) {break;}
        }
    }
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
	else { //if the user types something bad
		throw new IllegalArgumentException();
	}
	int ri = 0; //same as constructor above, initializes each tile
    Random rn = new Random();
    boolean mineGen = false;
    for(int q = 0; q < hsize; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < vsize; w++) {
            ri = rn.nextInt() % 64;
            if(numMines == 0) {break;}
            mineGen = false;
            if(ri < 10) {mineGen = true; numMines--;}
            board[q][w] = new Tile(mineGen, q, w);
        }
        if(numMines == 0) {break;}
    }
    if(numMines > 0) {// if there are still mines left to place down, run through board[][] again and place the rest down
        for(int q = 0; q < hsize; q++) {
            for(int w = 0; w < vsize; w++) {
                if(numMines == 0) {break;}
                ri = rn.nextInt() % 64;
                if(!board[q][w].isMine()) {
                    if(ri < 20) {board[q][w].setMine(); numMines--;}
                }
            }
            if(numMines == 0) {break;}
        }
    }
  }
  public Tile getTile(int xcor, int ycor){
    return board[xcor][ycor];
  }


}
