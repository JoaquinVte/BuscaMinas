public class Main {

    public static final char BOMB = '\u2622';
    public static int boardSize = 15;
    public static int bombs = 30;
    public static final char FALSE = '0';
    public static final char TRUE = '1';

    public static char[][][] board = new char[3][boardSize][boardSize];
    public static boolean alive = true;

    public static void main(String[] args) {
int option;
        Bomb.initializeBoard(board);
        Bomb.placeBombs(bombs,board);

        while (countCellsNotShowed()>bombs && alive) {
            Screen.clean();
            Screen.show(board);
            Screen.showMenu();
            option = Input.getOption("Enter option:",2,1);
            switch (option){
                case 1:placeFlag();
                    break;
                case 2:discoverCell();
                    break;
            }
        }

        markToShowAll();
        Screen.show(board);

        if(alive)
            System.out.println("You win.");
        else
            System.out.println("Loooooooser!!");

    }

    private static void placeFlag() {

    }

    private static void discoverCell() {
        String coordinate = Input.getCoordinate("Enter a coordiante:");
        place(coordinate);
    }

    private static void place(String coordinate) {
        if(Coordinate.isCoordinateValid(coordinate)) {
            int fil = Coordinate.getRowFromCoordinate(coordinate);
            int col = Coordinate.getColumnFromCoordinate(coordinate);

            if (board[1][fil][col]==FALSE && board[0][fil][col]!= BOMB){
                if(board[0][fil][col]=='0'){
                    board[0][fil][col]=' ';
                    board[1][fil][col]=TRUE;
                    place( Coordinate.getUp(coordinate));
                    place( Coordinate.getDown(coordinate));
                    place( Coordinate.getRight(coordinate));
                    place( Coordinate.getLeft(coordinate));

                    place( Coordinate.getUpLeft(coordinate));
                    place( Coordinate.getDownLeft(coordinate));
                    place( Coordinate.getUpRight(coordinate));
                    place( Coordinate.getDownRight(coordinate));

                } else {
                    board[1][fil][col]=TRUE;
                }
            }else if (board[0][fil][col]==BOMB)
                alive = false;
        }
    }

    private static int countCellsNotShowed(){
        int sum = 0;
        for(char[] rows : board[1])
            for(char cell : rows)
                sum+=(cell== FALSE)?1:0;

        return sum;
    }
    private static void markToShowAll(){
        for(int fil=0;fil< board[0].length;fil++ )
            for(int col=0;col<board[0].length;col++)
                board[1][fil][col]= TRUE;
    }
}
