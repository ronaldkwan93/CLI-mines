import java.util.Random;

public class Board {
  private String[][] grids = new String[10][10];
  private boolean[][] bombs = new boolean[10][10];
  private final int BOMB_COUNT = 10;
  private int cellsRevealed = 0;

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
        // System.out.println("Placed bomb at [" + row + "][" + col + "]");
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
      int bombCount = countSurroundingBombs(col, row);

      // System.out.printf("bombs %d", bombCount);
      // System.out.println();
      if (bombCount > 0) {
        grids[col][row] = Integer.toString(bombCount);
      } else {
        grids[col][row] = " ";

      }
      cellsRevealed++;
      if (cellsRevealed == 90) {
        revealAllBombs();
        System.out.println("Congratulations! You have finished the game!");

      }
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

  public int countSurroundingBombs(int col, int row) {
    int count = 0;

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        int newCol = col + i;
        int newRow = row + j;

        if (i == 0 && j == 0) {
          continue;
        }

        if (newCol >= 0 && newCol < 10 && newRow >= 0 && newRow < 10) {
          if (bombs[newCol][newRow]) {
            count++;
          }

        }
      }
    }
    return count;
  }
}
