import java.util.Random;

public class Board {
  private String[][] grids = new String[10][10];
  private boolean[][] bombs = new boolean[10][10];
  private final int BOMB_COUNT = 10;

  public Board() {

    // assign 'x' onto my grid cells
    for (int col = 0; col < 10; col++) {
      for (int row = 0; row < 10; row++) {
        grids[col][row] = "*";
      }
    }
    generateBombs();

    System.out.println(bombs);
  }

  public void generateBombs() {
    Random random = new Random();
    int bombsPlaced = 0;

    while (bombsPlaced < BOMB_COUNT) {
      int row = random.nextInt(10); 
      int col = random.nextInt(10); 

     
      if (!bombs[row][col]) {
        bombs[row][col] = true;
        bombsPlaced++;
        System.out.println("Placed bomb at [" + row + "][" + col + "]");
      }
    }

  }

  public void displayBoard() {
    // print out grid
    System.out.print("   ");

    for (int i = 0; i < 10; i++) {
      // casting into char for Unicode/ASCII stored letters
      char label = (char) ('A' + i);
      System.out.print(label);
      System.out.print("  ");
    }
    System.out.println();

    for (int col = 0; col < 10; col++) {
      System.out.print(col);
      System.out.print(" |");
      for (int row = 0; row < 10; row++) {
        System.out.print(grids[col][row]);
        System.out.print("||");
      }
      System.out.println();
    }
  }

  public void updateCell(Coordinate coordinate) {
    grids[coordinate.number][coordinate.letter] = "x";
    // System.out.println(grids[coordinate.number][coordinate.letter]);

    // int row = coordinate.number;
    // int col = coordinate.letter;

    // if (bombs[row][col]) {
    //   grids[row][col] = "B"; // Mark as bomb
    //   System.out.println("BOOM! You hit a bomb!");
    // }
  }
}
