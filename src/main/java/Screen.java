import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Screen {
    public static void show(){

        char[][] board = Main.board;
        boolean[][] showed = Main.showed;

        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board.length;i++)
            System.out.print(colorize(" " + i + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int fil=0;fil< board.length;fil++ ) {
            System.out.print(colorize(" " +(char)('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
            for (int col = 0; col < board[fil].length; col++) {
                if(showed[fil][col]) {
                    if(board[fil][col]==' ')
                        System.out.print(colorize(" " + board[fil][col] + " ",Attribute.BLUE_BACK(),Attribute.WHITE_TEXT()));
                    else
                        System.out.print(colorize(" " + board[fil][col] + " ",Attribute.YELLOW_BACK(),Attribute.RED_TEXT()));
                } else
                    System.out.print(colorize("   ",Attribute.GREEN_BACK()));
            }

            System.out.println(colorize(" " + (char) ('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        }
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board.length;i++)
            System.out.print(colorize(" " + i + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
    }

}
