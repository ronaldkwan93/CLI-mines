import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("l"); // purely for my own terminal format - no functionality.
        System.out.println(); // same as above

        boolean gameOn;

        gameOn = true;
        System.out.println("Let's play Minesweeper! Type play and press enter");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        
        Board board = new Board();
        board.displayBoard();

        while (gameOn) {
            System.out.println("Your move! Enter the next coordinate: e.g A0, B5, C4");

            String userCoordinate = scan.next();
            System.out.println(userCoordinate);
            Coordinate coord = Game.getCoordinates(userCoordinate);
            System.out.println(coord.letter);
            System.out.println(coord.number);
            // check if coordinates match bomb
            Game game = new Game();
            game.overWriteCoordinate(board, coord);
            board.displayBoard();
        }
        // Game.checkCoordinate();
        scan.close();

    }
}
