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

    System.out.println("testing board class");
    Board board = new Board("hard");
    for (int x = 0; x < board.getHsize(); x++){
      for (int y = 0; y < board.getVsize();y++){
        board.getTile(x, y).setOpen();
      }
    }

    System.out.println("making all tiles open:");
    System.out.println(board);




  }

}
