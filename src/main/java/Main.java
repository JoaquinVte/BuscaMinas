public class Main {

    public static final char BOMB = '\u2622';

    public static char[][] board = new char[10][10];
    public static boolean[][] showed = new boolean[10][10];

    public static void main(String[] args) {

        int bombs = 10;
        Bomb.initializeBoard(board);
        Bomb.placeBombs(bombs, board);
        while (countCellsNotShowed()>bombs) {
            Screen.show(board, showed);
            String coordinate = Input.getCoordinate("Enter a coordiante:");
            place(coordinate);
        }
        markToShowAll();
        Screen.show(board,showed);

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

    private static int countCellsNotShowed(){
        int sum = 0;
        for(boolean[] rows : showed)
            for(boolean cell : rows)
                sum+=(!cell)?1:0;

        return sum;
    }
    private static void markToShowAll(){
        for(int fil=0;fil< showed.length;fil++ )
            for(int col=0;col<showed[fil].length;col++)
                showed[fil][col]=true;
    }






}
