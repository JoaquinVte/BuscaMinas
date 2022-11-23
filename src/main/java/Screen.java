import com.diogonunes.jcolor.Attribute;

import java.util.concurrent.TimeUnit;

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
        for(int i=0;i<board[Main.VIEW_DIM].length;i++)
            System.out.print(colorize(" " +(char)('a'+i) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));

        //to display the actual board
        for(int fil=0;fil< board[Main.VIEW_DIM].length;fil++ ) {
            //in every row, we display the row coordinate at the first column
            System.out.print(colorize(" " +(char)('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));

            //Display the board content depending on what is actually showed and the flags placed
            for (int col = 0; col < board[Main.VIEW_DIM][fil].length; col++) {
                if(board[Main.VIEW_DIM][fil][col]==Main.TRUE) {
                    if(board[Main.FLAG_DIM][fil][col]==Main.FALSE) {
                        if (board[Main.BOMBS_DIM][fil][col] == Main.FALSE)
                            System.out.print(colorize(" " + Main.FREE + " ", Attribute.BLUE_BACK(), Attribute.WHITE_TEXT()));
                        else if (board[Main.BOMBS_DIM][fil][col] == Main.BOMB)
                            System.out.print(colorize(" " + board[Main.BOMBS_DIM][fil][col] + " ", Attribute.RAPID_BLINK(),Attribute.RED_BACK(), Attribute.WHITE_TEXT()));
                        else
                            System.out.print(colorize(" " + board[Main.BOMBS_DIM][fil][col] + " ", Attribute.YELLOW_BACK(), Attribute.RED_TEXT()));
                    }else{
                        System.out.print(colorize(" " + Main.FLAG + " ", Attribute.MAGENTA_BACK(), Attribute.WHITE_TEXT()));
                    }
                } else
                    System.out.print(colorize("   ",Attribute.GREEN_BACK()));
            }

            //in every row, we display the row coordinate at the last column
            System.out.println(colorize(" " + (char) ('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        }

        //Final row showing the column coordinates
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board[Main.VIEW_DIM].length;i++)
            System.out.print(colorize(" " +(char)('a'+i) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
    }

    /**
     * Clean the screen
     */
    public static void clean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Display error messages in the console
     * @param errorText error to show
     */
    public static void showError(String errorText){
        System.out.println(colorize(errorText,Attribute.RED_TEXT()));
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display infomartion messages in the console
     * @param infoText information to show
     */
    public static void showInfo(String infoText){
        System.out.println(colorize(infoText,Attribute.YELLOW_TEXT()));
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display a menu in the console to discover a position or place/remove a flag
     */
    public static void showMenu(){
        System.out.println("1 - Discover cell");
        System.out.println("2 - Place/Remove flag");
    }

}
