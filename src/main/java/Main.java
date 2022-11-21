public class Main {
    public static final char bomb = '\u2622';

    public static void main(String[] args) {



        char[][] tablero = new char[10][10];
        int bombs = 10;

        fill(tablero);
        placeBombs(bombs,tablero);
        Screen.showDebug(tablero);

    }

    public static void fill(char[][] board){
        for(int fil=0;fil< board.length;fil++ )
            for(int col=0;col<board[fil].length;col++)
                board[fil][col]='0';
    }

    public static void placeBombs(int bombs, char[][] board){
        String c;
        for(int i=0;i<bombs;i++){
            do {
                c = Cordinate.getRandomCordinate();
            } while (board[Cordinate.getRowFromCoordinate(c)][Cordinate.getColumnFromCoordinate(c)] == bomb );
            placeBomb(board,c);
        }
    }
    public static void placeBomb(char[][] board, String c){
        board[Cordinate.getRowFromCoordinate(c)][Cordinate.getColumnFromCoordinate(c)] = Main.bomb;

        if(Cordinate.isCordinateValid(Cordinate.getUp(c)))
            incrementar(board,Cordinate.getUp(c));
        if(Cordinate.isCordinateValid(Cordinate.getDown(c)))
            incrementar(board,Cordinate.getDown(c));
        if(Cordinate.isCordinateValid(Cordinate.getRight(c)))
            incrementar(board,Cordinate.getRight(c));
        if(Cordinate.isCordinateValid(Cordinate.getLeft(c)))
            incrementar(board,Cordinate.getLeft(c));

        if(Cordinate.isCordinateValid(Cordinate.getUpRight(c)))
            incrementar(board,Cordinate.getUpRight(c));
        if(Cordinate.isCordinateValid(Cordinate.getUpLeft(c)))
            incrementar(board,Cordinate.getUpLeft(c));
        if(Cordinate.isCordinateValid(Cordinate.getDownRight(c)))
            incrementar(board,Cordinate.getDownRight(c));
        if(Cordinate.isCordinateValid(Cordinate.getDownLeft(c)))
            incrementar(board,Cordinate.getDownLeft(c));

    }
    public static void incrementar(char[][] board, String c){
        int fil = Cordinate.getRowFromCoordinate(c);
        int col = Cordinate.getColumnFromCoordinate(c);

        if(board[fil][col]!=Main.bomb){
            int value = board[fil][col] - '0';
            board[fil][col] = String.valueOf(value+1).charAt(0);
        }
    }



}
