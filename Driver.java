import java.util.Random;
public class Driver{
  public static void main(String[] args) {
    /*
    System.out.println("testing tostring tile");
    Tile newtile = new Tile(true, 1, 1);
    System.out.println("opening mine, should print mine");
    newtile.setOpen();
    System.out.println(newtile);
    System.out.println("should print a flag");
    Tile newertile = new Tile(1, 1);
    newertile.flag();
    System.out.println(newertile);

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
    System.out.println("testing board difficulty");
    Board board3 = new Board("hard");
    System.out.println(board3);
    System.out.println("testing flags");
    System.out.println(board.getTile(0, 0).isOpen());
    board.getTile(0, 0).flag();
    System.out.println("tests if it flagged true");
    System.out.println(board.getTile(0, 0).isFlagged());
    System.out.println(board.getTile(0, 0).isOpen());
    System.out.println(board.getTile(0, 0));
    System.out.println(board3);
    */
    System.out.println("testing minesweeper class");

    MineSweeper ms1 = new MineSweeper("hard");
    System.out.println(ms1);
    System.out.println();
    System.out.println();

  }

}
