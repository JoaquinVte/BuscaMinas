import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * Screen class contains all attributes and methods related to showing information in the display and managing the boards
 */
public class Screen {
    /**
     * Showing the board at the console
     * @param board the board containing all the information
     * @param showed the showed board matrix
     */
    public static void show(char[][] board, boolean[][] showed){
        //First row showing the column coordinates
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board.length;i++)
            System.out.print(colorize(" " + i + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));

        //to display the actual board
        for(int fil=0;fil< board.length;fil++ ) {
            //in every row, we display the row coordinate at the first column
            System.out.print(colorize(" " +(char)('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));

            //Display the board content depending on what is actually showed
            for (int col = 0; col < board[fil].length; col++) {
                if(showed[fil][col]) {
                    if(board[fil][col]==' ')
                        System.out.print(colorize(" " + board[fil][col] + " ",Attribute.BLUE_BACK(),Attribute.WHITE_TEXT()));
                    else
                        System.out.print(colorize(" " + board[fil][col] + " ",Attribute.YELLOW_BACK(),Attribute.RED_TEXT()));
                } else
                    System.out.print(colorize("   ",Attribute.GREEN_BACK()));
            }

            //in every row, we display the row coordinate at the last column
            System.out.println(colorize(" " + (char) ('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        }

        //Final row showing the column coordinates
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board.length;i++)
            System.out.print(colorize(" " + i + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
    }

    /**
     * Initializes the board to 0
     * @param board the board matrix
     */
    public static void initializeBoard(char[][] board){
        for(int fil=0;fil< board.length;fil++ )
            for(int col=0;col<board[fil].length;col++)
                board[fil][col]='0';
    }

}
