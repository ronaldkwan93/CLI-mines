public class Game {
    public static Coordinate getCoordinates(String coordinate) {
        int letter = coordinate.charAt(0) - 65;
        int number = Character.getNumericValue(coordinate.charAt(1));
        return new Coordinate(letter, number);
    }

    public boolean overWriteCoordinate(Board board, Coordinate input) {
        boolean result = board.updateCell(input);
        return result;
    }

}
