import java.util.Random;
public class Board{
  private Tile[][] board; //makes the actual Board
  private int hsize; //horizontal size
  private int vsize; //vertical size
  private int numFlags; //number of flags remaining
  public Board(int verticalsize, int horizontalsize){ //constructor for custom board specs
	if(verticalsize < 2 || horizontalsize < 2) {throw new IllegalArgumentException();}
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
	if(difficulty.toLowerCase == "easy") {
		hsize = 8;
		vsize = 8;
		board = new Tile[hsize][vsize];
	}
	else if(difficulty.toLowerCase == "medium") {
		hsize = 16;
		vsize = 16;
		board = new Tile[hsize][vsize];
	}
	else if(difficulty.toLowerCase == "hard") {
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
  /*
  public void assignNumbers() {
	for(int q = 0; q < board.length; q++) {
		for(int w = 0; w < board[q].length; w++) {
			int tempNum = 0;
			if(q == 0) { //if tile is in top row
				if(w == 0) { //top left
					if(board[q][w + 1].isMine()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w + 1].isMine()) {tempNum++;}
				}
				else if(w == board[q].length - 1) { //top right
					if(board[q][w - 1].isMine()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w - 1].isMine()) {tempNum++;}
				}
				else { //top edge
					if(board[q][w - 1].isMine()) {tempNum++;}
					if(board[q][w + 1].isMine()) {tempNum++;}
					if(board[q + 1][w - 1].isMin){e()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w + 1].isMine()) {tempNum++;}
				}
			}
			else if(q == board.length - 1) { //if time is in bottom row
				if(w == 0) { //bottom left
					if(board[q - 1][w].isMine()) {tempNum++;}
					if(board[q - 1][w + 1].isMine()) {tempNum++;}
					if(board[q][w + 1].isMine()) {tempNum++;}
				}
				else if(w == board[q].length - 1) { //bottom right
					if(board[q - 1][w].isMine()) {tempNum++;}
					if(board[q - 1][w - 1].isMine()) {tempNum++;}
					if(board[q][w - 1].isMine()) {tempNum++;}
				}
				else { //bottom edge
					if(board[q][w - 1].isMine()) {tempNum++;}
					if(board[q][w + 1].isMine()) {tempNum++;}
					if(board[q - 1][w - 1].isMine()) {tempNum++;}
					if(board[q - 1][w].isMine()) {tempNum++;}
					if(board[q - 1][w + 1].isMine()) {tempNum++;}
				}
			}
			else { //if neither top nor bottom row
				if(w == 0) { //left edge
					if(board[q - 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q - 1][w + 1].isMine()) {tempNum++;}
					if(board[q][w + 1].isMine()) {tempNum++;}
					if(board[q + 1][w + 1].isMine()) {tempNum++;}
				}
				else if(w == board[q].length - 1) { //right edge
					if(board[q - 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q - 1][w - 1].isMine()) {tempNum++;}
					if(board[q][w - 1].isMine()) {tempNum++;}
					if(board[q + 1][w - 1].isMine()) {tempNum++;}
				}
				else { //middle
					if(board[q - 1][w - 1].isMine()) {tempNum++;}
					if(board[q - 1][w].isMine()) {tempNum++;}
					if(board[q - 1][w + 1].isMine()) {tempNum++;}
					if(board[q][w - 1].isMine()) {tempNum++;}
					if(board[q][w + 1].isMine()) {tempNum++;}
					if(board[q + 1][w - 1].isMine()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w + 1].isMine()) {tempNum++;}
				}
			}
			if(board[q][w].isMine()) {board[q][w].setTileNum(-1);} //if tile is mine, set number -1
			else {board[q][w].setTileNum(tempNum);} //if tile not mine, set number to the number of mines around it
		}
	}
  }
  */
  public Tile getTile(int xcor, int ycor){
    return board[xcor][ycor];
  }
  public String toString(){
    String sboard = "  "; //string version of board
    int counter = 1;
    char yalphabet = 'A'; //alphabet placed vertically
    char xalphabet = 'A'; //alphabet placed horizontally
    for (int hor = 0; hor < hsize; hor ++){
      if (hor != 0){
        sboard += " " + xalphabet; //creates horizontal locator in numbers
      }else{sboard += xalphabet;}
      xalphabet ++;
    }
    sboard += "\n";
    for (int x = 0; x < hsize; x ++){
      sboard += yalphabet; //creates vertical locator in letters
      sboard += "|";
      for (int y = 0; y < vsize; y ++){
        if (y != hsize - 1){sboard += board[x][y].toString() + " ";}
        else{sboard += board[x][y].toString();}
      }
      yalphabet ++;
      sboard += "|" + "\n";
    }
    return sboard;
  }
}
