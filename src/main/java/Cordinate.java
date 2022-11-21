import java.util.Scanner;

public class Cordinate {
    public static String getRandomCordinate(){
        return String.valueOf((char)Input.getRandomInteger('J','A'))+String.valueOf((char)Input.getRandomInteger('9','0'));
    }
    public static String getCordinate(String text){
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        String cordinate;
        do{
            cordinate = sc.nextLine();
        }while (Cordinate.isCordinateValid(cordinate));

        return cordinate;
    }
    public static boolean isCordinateValid(String cordinate){
        if(cordinate.length()!=2) return false;

        if(cordinate.charAt(0)>'J' || cordinate.charAt(0)<'A')
            return false;
        if(cordinate.charAt(1)>'9' || cordinate.charAt(1)<'0')
            return false;

        return true;
    }
    public static int getRowFromCoordinate(String cordinate){
        return cordinate.charAt(0)-'A';
    }
    public static int getColumnFromCoordinate(String cordinate){
        return cordinate.charAt(1)-'0';
    }
    public static String getUp(String cordinate){
        return String.valueOf((char)(cordinate.charAt(0)-1)) + cordinate.charAt(1);
    }
    public static String getDown(String cordinate){
        return String.valueOf((char)(cordinate.charAt(0)+1)) + cordinate.charAt(1);
    }
    public static String getRight(String cordinate){
        return String.valueOf((char)(cordinate.charAt(0))) + (char)(cordinate.charAt(1)+1);
    }
    public static String getLeft(String cordinate){
        return String.valueOf((char)(cordinate.charAt(0))) + (char)(cordinate.charAt(1)-1);
    }

    public static String getUpRight(String cordinate){
        return Cordinate.getUp(Cordinate.getRight(cordinate));
    }
    public static String getUpLeft(String cordinate){
        return Cordinate.getUp(Cordinate.getLeft(cordinate));
    }
    public static String getDownRight(String cordinate){
        return Cordinate.getDown(Cordinate.getRight(cordinate));
    }
    public static String getDownLeft(String cordinate){
        return Cordinate.getDown(Cordinate.getLeft(cordinate));
    }
}
