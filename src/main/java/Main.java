import java.util.concurrent.TimeUnit;

public class Main {

    public static final char BOMB = '☢';
    public static final char FLAG = '⚑';
    public static final char FREE = ' ';


    public static final int BOMBS_DIM = 0;
    public static final int FLAG_DIM = 1;
    public static final int VIEW_DIM = 2;

    public static final char FALSE = '0';
    public static final char TRUE = '1';

    public static int boardSize = 15;
    public static int bombs = 30;

    public static char[][][] board = new char[3][boardSize][boardSize];
    public static boolean alive = true;

    public static void main(String[] args) {
        int option;
        Bomb.initializeBoard(board);
        Bomb.placeBombs(bombs, board);

        do{
            Screen.clean();
            Screen.show(board);
            Screen.showMenu();
            option = Input.getOption("Enter option:", 2, 1);
            switch (option) {
                case 1:
                    discoverCell();
                    break;
                case 2:
                    placeOrRemoveFlag();
                    break;
            }
        }while (countCellsNotShowed() > bombs && alive);

        markToShowAll();
        Screen.show(board);

        if (alive)
            System.out.println("You win.");
        else
            System.out.println("Loooooooser!!");

    }

    private static void placeOrRemoveFlag() {
        String coordinate = Input.getCoordinate("Enter a coordinate to place a flag");
        int row = Coordinate.getRowFromCoordinate(coordinate);
        int col = Coordinate.getColumnFromCoordinate(coordinate);

        if (board[FLAG_DIM][row][col] == TRUE) {
            board[FLAG_DIM][row][col] = FALSE;
            board[VIEW_DIM][row][col] = FALSE;
            Screen.showInfo("Removing flag...");
        } else {
            board[FLAG_DIM][row][col] = TRUE;
            board[VIEW_DIM][row][col] = TRUE;
            Screen.showInfo("Placing flag...");
        }

    }

    private static void discoverCell() {
        String coordinate = Input.getCoordinate("Enter a coordiante:");
        int row = Coordinate.getRowFromCoordinate(coordinate);
        int col = Coordinate.getColumnFromCoordinate(coordinate);
        if (board[FLAG_DIM][row][col] == FLAG)
            Screen.showError("There are a flag in this place!");
        else if (board[VIEW_DIM][row][col] == TRUE)
            Screen.showError("This place has already been discovered.");
        else {
            discover(coordinate);
            Screen.showInfo("Discovering ...");
        }
    }

    private static void discover(String coordinate) {
        if (Coordinate.isCoordinateValid(coordinate)) {
            int fil = Coordinate.getRowFromCoordinate(coordinate);
            int col = Coordinate.getColumnFromCoordinate(coordinate);

            if (board[VIEW_DIM][fil][col] == FALSE && board[BOMBS_DIM][fil][col] != BOMB) {
                if (board[BOMBS_DIM][fil][col] == FALSE) {
                    board[VIEW_DIM][fil][col] = TRUE;
                    discover(Coordinate.getUp(coordinate));
                    discover(Coordinate.getDown(coordinate));
                    discover(Coordinate.getRight(coordinate));
                    discover(Coordinate.getLeft(coordinate));

                    discover(Coordinate.getUpLeft(coordinate));
                    discover(Coordinate.getDownLeft(coordinate));
                    discover(Coordinate.getUpRight(coordinate));
                    discover(Coordinate.getDownRight(coordinate));

                } else {
                    board[VIEW_DIM][fil][col] = TRUE;
                }
            } else if (board[BOMBS_DIM][fil][col] == BOMB)
                alive = false;
        }
    }

    private static int countCellsNotShowed() {
        int sum = 0;
        for (char[] rows : board[VIEW_DIM])
            for (char cell : rows)
                sum += (cell == FALSE) ? 1 : 0;

        return sum;
    }

    private static void markToShowAll() {
        for (int fil = 0; fil < board[VIEW_DIM].length; fil++)
            for (int col = 0; col < board[VIEW_DIM].length; col++)
                board[VIEW_DIM][fil][col] = TRUE;
    }
}
