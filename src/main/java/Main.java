public class Main {

    public static final char BOMB = '\u2622';

    public static char[][] board = new char[10][10];
    public static boolean[][] showed = new boolean[10][10];

    public static void main(String[] args) {

        int bombs = 10;
        Screen.initializeBoard(board);
        Bomb.placeBombs(bombs, board);
        while (true) {
            Screen.show(board, showed);
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








}
