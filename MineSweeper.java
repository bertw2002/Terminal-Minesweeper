public class MineSweeper{
  public String toString(){
    String board = "  ";
    int counter = 1;
    char alphabet = 'A';
    for (int hor = 0; hor < hsize; hor ++){
      board += counter;
      counter ++;
    }
    for (int x = 0; x < hsize; x ++){
      board += alphabet;
      board += "|";
      for (int y = 0; y < vsize; y ++){
        board += Tile(x, y).toString();
      }
      alphabet ++;
      board += "|";
    }
  }
  public MineSweeper(int difficulty, int ){

  }
  public static void main(String[] args){

  }
}
