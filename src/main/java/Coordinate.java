/**
 * Class Coordinate containing all attributes and methods to manage the board coordinates
 */
public class Coordinate {

    /**
     * Method to get a random coordinate
     * @return it returns a valid coordinate (string of length 2) having the row and the column
     */
    public static String getRandomCoordinate(){
        return (char) Input.getRandomInteger('A' + Main.boardSize - 1, 'A') +String.valueOf((char)Input.getRandomInteger('a'+Main.boardSize-1,'a'));
    }

    /**
     * Method checking whether a coordinate is valid or not - within the board bounds
     * @param coordinate the coordinate entered by user
     * @return whether the coordinate is valid (true) or not (false)
     */
    public static boolean isCoordinateValid(String coordinate){
        if(coordinate.length()!=2) return false;

        if(coordinate.charAt(0)>='A'+Main.boardSize || coordinate.charAt(0)<'A')
            return false;

        return coordinate.charAt(1) < 'a' + Main.boardSize && coordinate.charAt(1) >= 'a';
    }

    /**
     * returns the row coordinate as an integer
     * @param coordinate the String coordinate
     * @return the row value as an integer
     */
    public static int getRowFromCoordinate(String coordinate){
        return coordinate.charAt(0)-'A';
    }

    /**
     * returns the column coordinate as an integer
     * @param coordinate the String coordinate
     * @return the column value as an integer
     */
    public static int getColumnFromCoordinate(String coordinate){
        return coordinate.charAt(1)-'a';
    }

    /**
     * Method to return the upper row coordinate
     * @param coordinate current coordinate
     * @return the coordinate at the upper row
     */
    public static String getUp(String coordinate){
        return String.valueOf((char)(coordinate.charAt(0)-1)) + coordinate.charAt(1);
    }

    /**
     * Method to return the lower row coordinate
     * @param coordinate current coordinate
     * @return the coordinate at the lower row
     */
    public static String getDown(String coordinate){
        return String.valueOf((char)(coordinate.charAt(0)+1)) + coordinate.charAt(1);
    }

    /**
     * Method to return the right column coordinate
     * @param coordinate current coordinate
     * @return the coordinate at the right column
     */
    public static String getRight(String coordinate){
        return String.valueOf(coordinate.charAt(0)) + (char)(coordinate.charAt(1)+1);
    }

    /**
     * Method to return the left column coordinate
     * @param coordinate current coordinate
     * @return the coordinate at the left column
     */
    public static String getLeft(String coordinate){
        return String.valueOf(coordinate.charAt(0)) + (char)(coordinate.charAt(1)-1);
    }

    /**
     * Method to return the up right coordinate
     * @param coordinate current coordinate
     * @return the up right coordinate
     */
    public static String getUpRight(String coordinate){
        return Coordinate.getUp(Coordinate.getRight(coordinate));
    }

    /**
     * Method to return the up left coordinate
     * @param coordinate current coordinate
     * @return the up left coordinate
     */
    public static String getUpLeft(String coordinate){
        return Coordinate.getUp(Coordinate.getLeft(coordinate));
    }

    /**
     * Method to return the down right coordinate
     * @param coordinate current coordinate
     * @return the down right coordinate
     */
    public static String getDownRight(String coordinate){
        return Coordinate.getDown(Coordinate.getRight(coordinate));
    }

    /**
     * Method to return the down left coordinate
     * @param coordinate current coordinate
     * @return the down left coordinate
     */
    public static String getDownLeft(String coordinate){
        return Coordinate.getDown(Coordinate.getLeft(coordinate));
    }
}
