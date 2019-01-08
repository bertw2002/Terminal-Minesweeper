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
    ri = rn.nextInt() % 3;
    System.out.println("" +ri);
    System.out.println(""+rn.nextInt(5));
    System.out.println(""+rn.nextInt(5));
    System.out.println("testing board class");
    Board board = new Board(50, 50);
    System.out.println(board);
  }
}
