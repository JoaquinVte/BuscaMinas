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
        String coordinate;
        do{
            System.out.println(text);
            coordinate = sc.nextLine();
            if(!Coordinate.isCoordinateValid(coordinate))
                System.out.println("Coordenada no valida. El formato es Aa.");
        }while (!Coordinate.isCoordinateValid(coordinate));

        return coordinate;
    }
    public static int getOption(String txt,int max,int min){
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println(txt);
            while (!sc.hasNextInt()) {
                System.out.println("Only a integer number");
                System.out.println(txt);
                sc.next();
            }
            option = sc.nextInt();
            if(option>max || option<min)
                System.out.println("Only values between " + min + " and " + max);
        }while (option<=max && option>=min);

        return option;
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
