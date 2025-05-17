public class Board {

  public void generateBoard(int size) {
    
    if(size > 26) {
      System.out.println("Grid size too big!");
      return;
    }
    
    String[][] grids = new String[size][size];
    
    // assign 'x' onto my grid cells
    for (int col = 0; col < size; col++) {
      for (int row = 0; row < size; row++) {
        grids[col][row] = "x";
      }
    }

    // print out grid
    System.out.print("   ");

    for (int i = 0; i < size; i++) {
      // casting into char for Unicode/ASCII stored letters
      char label = (char) ('A'+ i);
      System.out.print(label);
      System.out.print(" ");
    }
    System.out.println();

    for (int col = 0; col < size; col++) {
      System.out.print(col);
      System.out.print("  ");
      for (int row = 0; row < size; row++) {
        System.out.print(grids[col][row]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
