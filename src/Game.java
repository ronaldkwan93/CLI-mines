public class Game {
    public static Coordinate getCoordinates(String coordinate) {
        int letter = coordinate.charAt(0) - 65;
        int number = Character.getNumericValue(coordinate.charAt(1));
        return new Coordinate(letter, number);
    }

    public void overWriteCoordinate(Board board, Coordinate input) {
        board.updateCell(input);
    }

}
