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
            String coordinate = Input.getCoordinate("Enter a coordiante:");
            place(coordinate);
        }
    }

    private static void place(String coordinate) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        place(visit,coordinate);
    }
    private static void place(boolean[][] visit, String coordinate) {
        if(Coordinate.isCoordinateValid(coordinate)) {
            int fil = Coordinate.getRowFromCoordinate(coordinate);
            int col = Coordinate.getColumnFromCoordinate(coordinate);

            if (!visit[fil][col] && board[fil][col]!= BOMB){
                if(board[fil][col]=='0'){
                    board[fil][col]=' ';
                    showed[fil][col]=true;
                    place(visit, Coordinate.getUp(coordinate));
                    place(visit, Coordinate.getDown(coordinate));
                    place(visit, Coordinate.getRight(coordinate));
                    place(visit, Coordinate.getLeft(coordinate));

                    place(visit, Coordinate.getUpLeft(coordinate));
                    place(visit, Coordinate.getDownLeft(coordinate));
                    place(visit, Coordinate.getUpRight(coordinate));
                    place(visit, Coordinate.getDownRight(coordinate));

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
                c = Coordinate.getRandomCoordinate();
            } while (board[Coordinate.getRowFromCoordinate(c)][Coordinate.getColumnFromCoordinate(c)] == BOMB);
            placeBomb(c);
        }
    }
    public static void placeBomb(String c){
        board[Coordinate.getRowFromCoordinate(c)][Coordinate.getColumnFromCoordinate(c)] = Main.BOMB;

        if(Coordinate.isCoordinateValid(Coordinate.getUp(c)))
            incrementar(board, Coordinate.getUp(c));
        if(Coordinate.isCoordinateValid(Coordinate.getDown(c)))
            incrementar(board, Coordinate.getDown(c));
        if(Coordinate.isCoordinateValid(Coordinate.getRight(c)))
            incrementar(board, Coordinate.getRight(c));
        if(Coordinate.isCoordinateValid(Coordinate.getLeft(c)))
            incrementar(board, Coordinate.getLeft(c));

        if(Coordinate.isCoordinateValid(Coordinate.getUpRight(c)))
            incrementar(board, Coordinate.getUpRight(c));
        if(Coordinate.isCoordinateValid(Coordinate.getUpLeft(c)))
            incrementar(board, Coordinate.getUpLeft(c));
        if(Coordinate.isCoordinateValid(Coordinate.getDownRight(c)))
            incrementar(board, Coordinate.getDownRight(c));
        if(Coordinate.isCoordinateValid(Coordinate.getDownLeft(c)))
            incrementar(board, Coordinate.getDownLeft(c));

    }
    public static void incrementar(char[][] board, String c){
        int fil = Coordinate.getRowFromCoordinate(c);
        int col = Coordinate.getColumnFromCoordinate(c);

        if(board[fil][col]!=Main.BOMB){
            int value = board[fil][col] - '0';
            board[fil][col] = String.valueOf(value+1).charAt(0);
        }
    }



}
