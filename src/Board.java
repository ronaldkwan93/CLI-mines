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

  }

  public void generateBombs() {
    Random random = new Random();
    int bombsPlaced = 0;

    while (bombsPlaced < BOMB_COUNT) {
      int col = random.nextInt(10); 
      int row = random.nextInt(10); 

     
      if (!bombs[col][row]) {
        bombs[col][row] = true;
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

  public boolean updateCell(Coordinate coordinate) {
    // System.out.println(grids[coordinate.number][coordinate.letter]);

    int row = coordinate.letter;
    int col = coordinate.number;
System.err.println();
    if (bombs[col][row]) {
      grids[col][row] = "B"; // Mark as bomb
      System.out.println("BOOM! You hit a bomb!");
      revealAllBombs();
      displayBoard();
      return false;
    } else {
      // check the amount of bombs around the coorindate. 
  
    grids[col][row] = " ";
    System.out.println(row);
    System.out.println(col);
    return true;
    }
  }

  public void revealAllBombs() {
  for (int col = 0; col < 10; col++) {
    for (int row = 0; row < 10; row++) {
      if (bombs[col][row]) {
        grids[col][row] = "B";
      }
    }
  }
}
}
