public class Main {

    public static final char BOMB = '\u2622';

    public static char[][] board = new char[10][10];
    public static boolean[][] showed = new boolean[10][10];

    public static void main(String[] args) {

        int bombs = 10;

        fill();
        placeBombs(bombs);
        while (true) {
            Screen.show();
            String cordinate = Cordinate.getCordinate("Enter a cordiante:");
            place(cordinate);
        }
    }

    private static void place(String cordinate) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        place(visit,cordinate);
    }
    private static void place(boolean[][] visit, String cordinate) {
        if(Cordinate.isCordinateValid(cordinate)) {
            int fil = Cordinate.getRowFromCoordinate(cordinate);
            int col = Cordinate.getColumnFromCoordinate(cordinate);

            if (!visit[fil][col] && board[fil][col]!= BOMB){
                if(board[fil][col]=='0'){
                    board[fil][col]=' ';
                    showed[fil][col]=true;
                    place(visit,Cordinate.getUp(cordinate));
                    place(visit,Cordinate.getDown(cordinate));
                    place(visit,Cordinate.getRight(cordinate));
                    place(visit,Cordinate.getLeft(cordinate));

                    place(visit,Cordinate.getUpLeft(cordinate));
                    place(visit,Cordinate.getDownLeft(cordinate));
                    place(visit,Cordinate.getUpRight(cordinate));
                    place(visit,Cordinate.getDownRight(cordinate));

                } else {
                    showed[fil][col]=true;
                }
            }
        }
    }


    public static void fill(){
        for(int fil=0;fil< board.length;fil++ )
            for(int col=0;col<board[fil].length;col++)
                board[fil][col]='0';
    }

    public static void placeBombs(int bombs){
        String c;
        for(int i=0;i<bombs;i++){
            do {
                c = Cordinate.getRandomCordinate();
            } while (board[Cordinate.getRowFromCoordinate(c)][Cordinate.getColumnFromCoordinate(c)] == BOMB);
            placeBomb(c);
        }
    }
    public static void placeBomb(String c){
        board[Cordinate.getRowFromCoordinate(c)][Cordinate.getColumnFromCoordinate(c)] = Main.BOMB;

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

        if(board[fil][col]!=Main.BOMB){
            int value = board[fil][col] - '0';
            board[fil][col] = String.valueOf(value+1).charAt(0);
        }
    }



}
