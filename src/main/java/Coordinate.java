import java.util.Scanner;

public class Coordinate {
    public static String getRandomCoordinate(){
        return String.valueOf((char)Input.getRandomInteger('J','A'))+String.valueOf((char)Input.getRandomInteger('9','0'));
    }

    /**
     * Method checking whether a coordinate is valid or not - within the board bounds
     * @param coordinate the coordinate entered by user
     * @return whether the coordinate is valid (true) or not (false)
     */
    public static boolean isCoordinateValid(String coordinate){
        if(coordinate.length()!=2) return false;

        if(coordinate.charAt(0)>'J' || coordinate.charAt(0)<'A')
            return false;
        if(coordinate.charAt(1)>'9' || coordinate.charAt(1)<'0')
            return false;

        return true;
    }
    public static int getRowFromCoordinate(String coordinate){
        return coordinate.charAt(0)-'A';
    }
    public static int getColumnFromCoordinate(String coordinate){
        return coordinate.charAt(1)-'0';
    }
    public static String getUp(String coordinate){
        return String.valueOf((char)(coordinate.charAt(0)-1)) + coordinate.charAt(1);
    }
    public static String getDown(String coordinate){
        return String.valueOf((char)(coordinate.charAt(0)+1)) + coordinate.charAt(1);
    }
    public static String getRight(String coordinate){
        return String.valueOf((char)(coordinate.charAt(0))) + (char)(coordinate.charAt(1)+1);
    }
    public static String getLeft(String coordinate){
        return String.valueOf((char)(coordinate.charAt(0))) + (char)(coordinate.charAt(1)-1);
    }

    public static String getUpRight(String coordinate){
        return Coordinate.getUp(Coordinate.getRight(coordinate));
    }
    public static String getUpLeft(String coordinate){
        return Coordinate.getUp(Coordinate.getLeft(coordinate));
    }
    public static String getDownRight(String coordinate){
        return Coordinate.getDown(Coordinate.getRight(coordinate));
    }
    public static String getDownLeft(String coordinate){
        return Coordinate.getDown(Coordinate.getLeft(coordinate));
    }
}
