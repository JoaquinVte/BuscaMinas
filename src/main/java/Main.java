public class Main {

    public static void main(String[] args) {

        char[][] tablero = new char[10][10];

        for(int i=0;i<100;i++)
        System.out.println(Input.getRandomCordinate());

    }

    public static void fill(char[][] board){
        for(int fil=0;fil< board.length;fil++ )
            for(int col=0;col<board[fil].length;col++)
                board[fil][col]=0;
    }


}
