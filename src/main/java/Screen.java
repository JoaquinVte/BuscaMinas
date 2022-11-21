public class Screen {
    public static void show(char[][] board){
        for(int fil=0;fil< board.length;fil++ ) {
            for (int col = 0; col < board[fil].length; col++)
                System.out.println(board[fil][col] + " ");
            System.out.println();
        }
    }
}
