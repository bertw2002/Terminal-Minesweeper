import java.util.Random;
public class Driver{
  public static void main(String[] args) {
    System.out.println("testing tostring tile");
    Tile newtile = new Tile(true, 1, 1);
    System.out.println("opening mine, should print mine");
    newtile.setOpen();
    System.out.println(newtile);
    System.out.println("should print a flag");
    Tile newertile = new Tile(1, 1);
    newertile.flag();
    System.out.println(newertile);
    System.out.println("testing out random int");
    int ri  = 0;
    Random rn = new Random();
    for(int q = 0; q < 3; q++) { //loops through board[][], initializes every tile and puts down a mine per every 6.4 tiles (ideally)
        for(int w = 0; w < 3; w++) {
            ri = rn.nextInt() % 64 + 1;
            System.out.println(ri);
        }
    }
    System.out.println("testing board class");
    Board board = new Board(30, 30);
    for (int x = 0; x < board.getHsize(); x++){
      for (int y = 0; y < board.getVsize();y++){
        board.getTile(x, y).setOpen();
      }
    }

    System.out.println("making all tiles open:");
    System.out.println(board);
    System.out.println("testing iszero should print 8, 4 4: " + board.isZero(4,4));
    System.out.println("testing iszero print 0, 4 4: " + board.isZero(4,4));
    System.out.println(board);
    System.out.println("testing clearspread");
    Board board2 = new Board(20, 20);
    board2.clearSpread(3, 3);
    System.out.println(board2);


  }
}
