import java.util.Scanner;

/**
 * Input class contains all attributes and methods related to the user interaction via console
 */
public class Input {
    /**
     * Gets the coordinate from the console
     * @param text the message to show in order to get the coordinate
     * @return a valid coordinate as a String of length 2 (row and column)
     */
    public static String getCoordinate(String text){
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        String coordinate;
        do{
            coordinate = sc.nextLine().toUpperCase();
        }while (!Coordinate.isCoordinateValid(coordinate));

        return coordinate;
    }

    /**
     * Returns a random integer from a range
     * @param max upper limit of the range
     * @param min lower limit of the range
     * @return it returns an integer
     */
    public static int getRandomInteger(int max,int min){
        return (int)((Math.random()*(max-min+1))+min);
    }
}
