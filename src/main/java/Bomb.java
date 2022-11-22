/**
 * Class Bomb to manage the bombs
 */
public class Bomb {

    /**
     * Method to place the bombs at the board avoiding to place more than one bomb in the same coordinate
     * @param bombs the bombs amount
     * @param board the board matrix
     */
    public static void placeBombs(int bombs, char[][] board){
        String c;
        for(int i=0;i<bombs;i++){
            do {
                c = Coordinate.getRandomCoordinate();
            } while (board[Coordinate.getRowFromCoordinate(c)][Coordinate.getColumnFromCoordinate(c)] == Main.BOMB);
            placeBomb(c, board);
        }
    }

    /**
     * Placing the bomb and increasing the number of bombs in all the related coordinates
     * @param c the coordinate
     * @param board the board matrix
     */
    public static void placeBomb(String c, char[][] board){
        board[Coordinate.getRowFromCoordinate(c)][Coordinate.getColumnFromCoordinate(c)] = Main.BOMB;

        //it increases the value of the cross coordinate
        if(Coordinate.isCoordinateValid(Coordinate.getUp(c)))
            increase(board, Coordinate.getUp(c));
        if(Coordinate.isCoordinateValid(Coordinate.getDown(c)))
            increase(board, Coordinate.getDown(c));
        if(Coordinate.isCoordinateValid(Coordinate.getRight(c)))
            increase(board, Coordinate.getRight(c));
        if(Coordinate.isCoordinateValid(Coordinate.getLeft(c)))
            increase(board, Coordinate.getLeft(c));

        //it increases the value of the corners coordinate
        if(Coordinate.isCoordinateValid(Coordinate.getUpRight(c)))
            increase(board, Coordinate.getUpRight(c));
        if(Coordinate.isCoordinateValid(Coordinate.getUpLeft(c)))
            increase(board, Coordinate.getUpLeft(c));
        if(Coordinate.isCoordinateValid(Coordinate.getDownRight(c)))
            increase(board, Coordinate.getDownRight(c));
        if(Coordinate.isCoordinateValid(Coordinate.getDownLeft(c)))
            increase(board, Coordinate.getDownLeft(c));

    }

    /**
     * It increases the number of bombs at its range
     * @param board the board matrix
     * @param c the coordinate to check
     */
    private static void increase(char[][] board, String c){
        int fil = Coordinate.getRowFromCoordinate(c);
        int col = Coordinate.getColumnFromCoordinate(c);

        if(board[fil][col]!=Main.BOMB){
            int value = board[fil][col] - '0';
            board[fil][col] = String.valueOf(value+1).charAt(0);
        }
    }


}
