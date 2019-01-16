import java.util.Random;
public class Board{
  public Tile[][] board; //makes the actual Board
  private int hsize; //horizontal size
  private int vsize; //vertical size
  private int numFlags; //number of flags remaining
  private int numMines; //number of mines in board
  private int xZero; //x coordinate of the empty tile
  private int yZero; //y coordinate of the empty tile
  //finds actual tile num, counting the number of mines around it.
  public int findTileNum(int x, int y){
    int minecounter = 0;
    if (x != 0){
      if (board[y][x - 1].getTileNum() == -1){
        minecounter++;
      }
    }
    if (y != 0){
      if (board[y - 1][x].getTileNum() == -1){
        minecounter++;
      }
    }
    if (x != vsize - 1){
      if (board[y][x + 1].getTileNum() == -1){
        minecounter++;
      }
    }
    if (y != hsize - 1){
      if (board[y + 1][x].getTileNum() == -1){
        minecounter++;
      }
    }
    if (x != 0 && y != 0){
      if (board[y - 1][x - 1].getTileNum() == -1){
        minecounter++;
      }
    }
    if (x != 0 && y != hsize - 1){
      if (board[y + 1][x - 1].getTileNum() == -1){
        minecounter++;
      }
    }
    if(x != vsize - 1 && y != hsize - 1){
      if (board[y + 1][x + 1].getTileNum() == -1){
        minecounter++;
      }
    }
    if(x != hsize - 1 && y != 0){
      if (board[y - 1][x + 1].getTileNum() == -1){
        minecounter++;
      }
    }
    return minecounter;
  }
  public int boardNumFlags() {
	 return numFlags;
  }
  public int numMines() {
	 return numMines;
  }
  public Board(int verticalsize, int horizontalsize){ //constructor for custom board specs
	if(verticalsize < 2 || horizontalsize < 2) {throw new IllegalArgumentException();}
    hsize = horizontalsize;
    vsize = verticalsize;
    board = new Tile[hsize][vsize];
    int ri = 0;
    numMines = 0;
    Random rn = new Random();
    boolean mineGen = false;
    for(int q = 0; q < hsize; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < vsize; w++) {
            ri = rn.nextInt() % 32;
            mineGen = false;
            if(ri < -20) {
              mineGen = true;
              numMines++;
            }
            board[q][w] = new Tile(mineGen, q, w);
            if (mineGen == true){board[q][w].setTileNum(-1);}
        }
    }
    for(int q = 0; q < vsize; q++) {
        for(int w = 0; w < hsize; w++) {
          if (board[w][q].getTileNum() != -1){
            board[w][q].setTileNum(findTileNum(q, w));
          }
        }
    }
  }
  public Board(String difficulty) { //constructor that implements presets based on difficulty
  	if(difficulty.toLowerCase().equals("easy")) {
  		hsize = 8;
  		vsize = 8;
  		board = new Tile[hsize][vsize];
  	}
  	else if(difficulty.toLowerCase().equals("medium")) {
  		hsize = 16;
  		vsize = 16;
  		board = new Tile[hsize][vsize];
  	}
  	else if(difficulty.toLowerCase().equals("hard")) {
  		hsize = 26;
  		vsize = 26;
  		board = new Tile[hsize][vsize];
  	}
  	else { //if the user types something bad
  		throw new IllegalArgumentException();
  	}
    int ri = 0;
    Random rn = new Random();
    numMines = 0;
    boolean mineGen = false;
    for(int q = 0; q < hsize; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < vsize; w++) {
            ri = rn.nextInt() % 32;
            mineGen = false;
            if(ri < -20) {
              mineGen = true;
              numMines++;
            }
            board[q][w] = new Tile(mineGen, q, w);
            if (mineGen == true){board[q][w].setTileNum(-1);}
        }
    }
    for(int q = 0; q < vsize; q++) {
        for(int w = 0; w < hsize; w++) {
          if (board[w][q].getTileNum() != -1){
            board[w][q].setTileNum(findTileNum(q, w));
          }
        }
    }
  }
  public int rowCount() {return hsize;}
  public int colCount() {return vsize;}
  public boolean allFlaggedOrCleared() {
    boolean afoc = true;
    for(int q = 0; q < board.length; q++) {
        for(int w = 0; w < board[q].length; w++) {
          if(!(board[q][w].isFlagged() || board[q][w].isCleared())) {afoc = false;}
        }
    }
    return afoc;
  }
  public boolean allMinesFlagged() {
    boolean amf = true;
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        if(board[q][w].isMine()) {
          if(!board[q][w].isFlagged()) {amf = false;}
        }
      }
    }
    return amf;
  }
  public Tile getTile(int xcor, int ycor) {
    return board[xcor][ycor];
  }
  public int isZero(int x, int y){
    if (x > hsize - 1 || y > vsize - 1){
      throw new IndexOutOfBoundsException();
    }

    if(!board[y][x].isFlagged()){
      if (board[y][x].isOpen() == false){
        board[y][x].clear();
      }
    }else{
      return 0;
    }
    if (board[y][x].getTileNum() > 0){
      return 0;
    }
    int numZeros = 0;//number of zeros surrounding tile.
    boolean first = true;
    if (x != 0){
      if ((board[y][x - 1].getTileNum() == 0|| (!board[y][x - 1].isOpen() && board[y][x - 1].getTileNum() != -1)) && !board[y][x - 1].isFlagged()){
        numZeros++;

        if (first && (!board[y][x - 1].isOpen() && board[y][x - 1].getTileNum() == 0)){
          xZero = x - 1;
          yZero = y;
          first = false;
        }
        board[y][x - 1].clear();
      }
    }
    if (y != 0){
      if ((board[y - 1][x].getTileNum() == 0|| (!board[y - 1][x].isOpen()&& board[y - 1][x].getTileNum() != -1)) && !board[y - 1][x].isFlagged()){
        numZeros++;

        if (first && (!board[y - 1][x].isOpen() && board[y - 1][x].getTileNum() == 0)){
          xZero = x;
          yZero = y - 1;
          first = false;
        }
        board[y - 1][x].clear();

      }
    }
    if (x != vsize - 1){
      if ((board[y][x + 1].getTileNum() == 0|| (!board[y][x + 1].isOpen()&& board[y][x + 1].getTileNum() != -1)) && !board[y][x + 1].isFlagged()){
        numZeros++;

        if (first && (!board[y][x + 1].isOpen() && board[y][x + 1].getTileNum() == 0)){
          xZero = x + 1;
          yZero = y;
          first = false;
        }
        board[y][x + 1].clear();
      }
    }
    if (y != hsize - 1){
      if ((board[y + 1][x].getTileNum() == 0|| (!board[y + 1][x].isOpen()&& board[y + 1][x].getTileNum() != -1)) && !board[y + 1][x].isFlagged()){
        numZeros++;

        if (first && (!board[y + 1][x].isOpen() && board[y + 1][x].getTileNum() == 0)){
          xZero = x + 1;
          yZero = y;
          first = false;
        }
        board[y + 1][x].clear();
      }
    }
    if (x != 0 && y != 0){
      if ((board[y - 1][x - 1].getTileNum() == 0|| (!board[y - 1][x - 1].isOpen()&& board[y - 1][x - 1].getTileNum() != -1)) && !board[y - 1][x - 1].isFlagged()){
        numZeros++;

        if (first && (!board[y - 1][x - 1].isOpen() && board[y - 1][x - 1].getTileNum() == 0)){
          xZero = x - 1;
          yZero = y - 1;
          first = false;
        }
        board[y - 1][x - 1].clear();
      }
    }
    if (x != 0 && y != hsize - 1){
      if ((board[y + 1][x - 1].getTileNum() == 0 || (!board[y + 1][x - 1].isOpen() && board[y + 1][x - 1].getTileNum() != -1)) && !board[y + 1][x - 1].isFlagged()){
        numZeros++;

        if (first && (!board[y + 1][x - 1].isOpen() && board[y + 1][x - 1].getTileNum() == 0)){
          xZero = x - 1;
          yZero = y + 1;
          first = false;
        }
        board[y + 1][x - 1].clear();
      }
    }
    if(x != vsize - 1 && y != hsize - 1){
      if ((board[y + 1][x + 1].getTileNum() == 0 || (!board[y + 1][x + 1].isOpen()&& board[y + 1][x + 1].getTileNum() != -1)) && !board[y + 1][x + 1].isFlagged()){
        numZeros++;

        if (first && (!board[y + 1][x + 1].isOpen() && board[y + 1][x + 1].getTileNum() == 0)){
          xZero = x + 1;
          yZero = y + 1;
          first = false;
        }
        board[y + 1][x + 1].clear();

      }
    }
    if(x != vsize - 1 && y != 0){
      if ((board[y - 1][x + 1].getTileNum() == 0 || (!board[y - 1][x + 1].isOpen()&& board[y - 1][x + 1].getTileNum() != -1)) && !board[y - 1][x + 1].isFlagged()){
        numZeros++;

        if (first && (!board[y - 1][x + 1].isOpen() && board[y - 1][x + 1].getTileNum() == 0)){
          xZero = x + 1;
          yZero = y - 1;
          first = false;
        }
        board[y - 1][x + 1].clear();
      }
    }

    if (first){
      numZeros = 0;
    }
    return numZeros;
  }
  public int getHsize(){
    return hsize;
  }
  public int getVsize(){
    return vsize;
  }
  public void clearSpread(int x, int y){
    if (x > hsize - 1 || y > vsize - 1){
      throw new IndexOutOfBoundsException();
    }


    while (isZero(x, y) != 0){
      if (x != 0){clearSpread(x - 1, y);}
      if (x != vsize - 1 && y != 0){clearSpread(x + 1, y - 1);}
      if (x != vsize - 1 && y != hsize - 1){clearSpread(x + 1, y + 1);}
      if (x != 0 && y != hsize - 1){clearSpread(x - 1, y + 1);}
      if (y != 0){clearSpread(x, y - 1);}
      if (y != 0 && x != 0){clearSpread(x - 1,y - 1);}
      if (x != vsize - 1){clearSpread(x + 1, y);}
      if (y != hsize - 1){clearSpread(x, y + 1);}
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
    String sboard = " "; //string version of board
    int counter = 1;
    char y1 = 'A'; //alphabet placed vertically first row
    char y2 = 'A'; //alphabet placed vertically second row
    int x1 = 0; //horizontal locators first row.
    int x2 = 0; //horizontal locators second row.
    for (int hor = 0; hor < vsize; hor ++){
      if (counter == 11){
        counter = 1;
        x1 ++;
      }
      if (hor != 0){
        sboard += " " + x1;
      }else{sboard += "  " + x1;}
      counter ++;
    }
    sboard += "\n";
    sboard += "  ";
    counter = 0;
    for (int hor = 0; hor < vsize; hor ++){
      if (counter == 10){
        counter = 0;
        x2 = 0;
      }
      if (hor != 0){sboard += " " + x2;}
      else{sboard += " "+ x2;}
      x2 ++;
      counter ++;
    }
    sboard += "\n";
    sboard += "   ";
    //makes a line between the locators and board to make it more aesthetic.
    for (int x = 0;x < vsize; x++){
      if (x != vsize - 1){sboard += "__";}
      else{sboard += "_";}
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
        if (y != vsize - 1){sboard += board[x][y].toString() + " ";}
        else{sboard += board[x][y].toString();}
      }
      y2 ++;
      sboard += "|" + "\n";

      counter ++;
    }
    sboard += "   ";
    //line under box to make it more aesthetic
    for (int x = 0;x < vsize; x++){
      if (x != vsize - 1){sboard += "__";}
      else{sboard += "_";}
    }
    return sboard;
  }

}
