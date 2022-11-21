import java.util.Scanner;

public class Input {
    public static String getCoordinate(String text){
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        String coordinate;
        do{
            coordinate = sc.nextLine().toUpperCase();
        }while (!Coordinate.isCoordinateValid(coordinate));

        return coordinate;
    }
    public static int getRandomInteger(int max,int min){
        return (int)((Math.random()*(max-min+1))+min);
    }
}
