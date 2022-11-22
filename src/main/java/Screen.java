import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * Screen class contains all attributes and methods related to showing information in the display and managing the boards
 */
public class Screen {
    /**
     * Showing the board at the console
     * @param board the board containing all the information
     */
    public static void show(char[][][] board){
        //First row showing the column coordinates
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board[0].length;i++)
            System.out.print(colorize(" " +(char)('a'+i) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));

        //to display the actual board
        for(int fil=0;fil< board[0].length;fil++ ) {
            //in every row, we display the row coordinate at the first column
            System.out.print(colorize(" " +(char)('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));

            //Display the board content depending on what is actually showed
            for (int col = 0; col < board[0][fil].length; col++) {
                if(board[1][fil][col]=='1') {
                    if(board[0][fil][col]==' ')
                        System.out.print(colorize(" " + board[0][fil][col] + " ",Attribute.BLUE_BACK(),Attribute.WHITE_TEXT()));
                    else if(board[0][fil][col]==Main.BOMB)
                        System.out.print(colorize(" " + board[0][fil][col] + " ",Attribute.RED_BACK(),Attribute.YELLOW_TEXT()));
                    else
                        System.out.print(colorize(" " + board[0][fil][col] + " ",Attribute.YELLOW_BACK(),Attribute.RED_TEXT()));
                } else
                    System.out.print(colorize("   ",Attribute.GREEN_BACK()));
            }

            //in every row, we display the row coordinate at the last column
            System.out.println(colorize(" " + (char) ('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        }

        //Final row showing the column coordinates
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board[0].length;i++)
            System.out.print(colorize(" " +(char)('a'+i) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
    }
    public static void clean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showMenu(){
        System.out.println("1 - Place flag");
        System.out.println("2 - Discover cell");
    }

}
