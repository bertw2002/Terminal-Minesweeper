import java.util.Random;
public class Board{
  public Tile[][] board; //makes the actual Board
  private int hsize; //horizontal size
  private int vsize; //vertical size
  public int numFlags; //number of flags remaining
  public int xZero; //x coordinate of the empty tile
  public int yZero; //y coordinate of the empty tile
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
	if(difficulty.toLowerCase() == "easy") {
		hsize = 8;
		vsize = 8;
		board = new Tile[hsize][vsize];
	}
	else if(difficulty.toLowerCase() == "medium") {
		hsize = 16;
		vsize = 16;
		board = new Tile[hsize][vsize];
	}
	else if(difficulty.toLowerCase() == "hard") {
		hsize = 26;
		vsize = 26;
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
  public int rowCount() {return hsize;}
  public int colCount() {return vsize;}
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
					if(board[q + 1][w - 1].isMine()) {tempNum++;}
					if(board[q + 1][w].isMine()) {tempNum++;}
					if(board[q + 1][w + 1].isMine()) {tempNum++;}
				}
			}
			if(q == board.length - 1) { //if time is in bottom row
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
  public Tile getTile(int xcor, int ycor) {
    return board[xcor][ycor];
  }
  public int isZero(int x, int y){
    int numZeros = 0;//number of zeros surrounding tile.
    boolean first = false;
    if (x != 0){
      if (board[x - 1][y].getTileNum() == 0){
        numZeros++;
        board[x-1][y].setOpen();
        if (first){
          xZero = x - 1;
          yZero = y;
          first = false;
        }
      }
    }
    if (y != 0){
      if (board[x][y - 1].getTileNum() == 0){
        numZeros++;
        board[x][y - 1].setOpen();
        if (first){
          xZero = x;
          yZero = y - 1;
          first = false;
        }
      }
    }
    if (x != hsize - 1){
      if (board[x + 1][y].getTileNum() == 0){
        numZeros++;
        board[x + 1][y].setOpen();
        if (first){
          xZero = x + 1;
          yZero = y;
          first = false;
        }
      }
    }
    if (y != vsize - 1){
      if (board[x][y + 1].getTileNum() == 0){
        numZeros++;
        board[x][y + 1].setOpen();
        if (first){
          xZero = x + 1;
          yZero = y;
          first = false;
        }
      }
    }
    if (x != 0 && y != 0){
      if (board[x - 1][y - 1].getTileNum() == 0){
        numZeros++;
        board[x - 1][y - 1].setOpen();
        if (first){
          xZero = x - 1;
          yZero = y - 1;
          first = false;
        }
      }
    }
    if (x != 0 && y != vsize - 1){
      if (board[x - 1][y + 1].getTileNum() == 0){
        numZeros++;
        board[x - 1][y + 1].setOpen();
        if (first){
          xZero = x - 1;
          yZero = y + 1;
          first = false;
        }
      }
    }
    if(x != vsize - 1 && y != vsize - 1){
      if (board[x + 1][y + 1].getTileNum() == 0){
        numZeros++;
        board[x + 1][y + 1].setOpen();
        if (first){
          xZero = x + 1;
          yZero = y + 1;
          first = false;
        }
      }
    }
    if(x != vsize - 1 && y != 0){
      if (board[x + 1][y - 1].getTileNum() == 0){
        numZeros++;
        board[x + 1][y - 1].setOpen();
        if (first){
          xZero = x + 1;
          yZero = y - 1;
          first = false;
        }
      }
    }

    return numZeros;
  }
  public void clearSpread(int x, int y){
    if (x > hsize - 1 || y > vsize - 1){
      throw new IndexOutOfBoundsException();
    }

  }
  public int numOpened() {
	 int no = 0;
	 for(int q = 0; q < board.length; q++) {
		for(int w = 0; w < board[q].length; w++) {
			if(board[q][w].isOpen()) {no++;}
		}
	 }
	 return no;
  }
  public String toString(){
    String sboard = "  "; //string version of board
    int counter = 1;
    char y1 = 'A'; //alphabet placed vertically first row
    char y2 = 'A'; //alphabet placed vertically second row
    int x1 = 0; //horizontal locators first row.
    int x2 = 0; //horizontal locators second row.
    for (int hor = 0; hor < hsize; hor ++){
      if (counter == 11){
        counter = 1;
        x1 ++;
      }
      if (hor != 0){
        sboard += " " + x1;
      }else{sboard += x1;}
      counter ++;
    }
    sboard += "\n";
    sboard += "  ";
    counter = 0;
    for (int hor = 0; hor < hsize; hor ++){
      if (counter == 10){
        counter = 0;
        x2 = 0;
      }
      if (hor != 0){sboard += " " + x2;}
      else{sboard += x2;}
      x2 ++;
      counter ++;
    }
    sboard += "\n";
    counter = 0;
    for (int x = 0; x < hsize; x ++){
      if (counter == 26){
        counter = 0;
        y1 ++;
      }
      sboard += y1; //creates vertical locator in letters
      sboard += y2;
      if (y1 == 'Z'){y1 = 'A' - 1;}
      if (y2 == 'Z'){y2 = 'A' - 1;}
      sboard += "|";
      for (int y = 0; y < vsize; y ++){
        if (y != hsize - 1){sboard += board[x][y].toString() + " ";}
        else{sboard += board[x][y].toString();}
      }
      y2 ++;
      sboard += "|" + "\n";
      counter ++;
    }
    return sboard;
  }

}
