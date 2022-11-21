public class Input {

    public static String getRandomCordinate(){
        return String.valueOf((char)getRandomInteger('Z','A'))+String.valueOf((char)getRandomInteger('9','0'));
    }

    private static int getRandomInteger(int max,int min){
        return (int)((Math.random()*(max-min+1))+min);
    }
}
