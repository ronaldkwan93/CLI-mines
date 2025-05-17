import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("l"); // purely for my own terminal format - no functionality.
        System.out.println(); // same as above
        
        System.out.println("Let's play Minesweeper! Choose a number to set your grid size:");
        Scanner scan = new Scanner(System.in);
        int gridSizeInput = scan.nextInt();


        Board board = new Board();
        board.generateBoard(gridSizeInput);

        scan.close();

    }
}
