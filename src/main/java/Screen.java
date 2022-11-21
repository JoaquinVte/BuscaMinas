import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Screen {
    public static void showDebug(char[][] board){
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board.length;i++)
            System.out.print(colorize(" " + i + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int fil=0;fil< board.length;fil++ ) {
            System.out.print(colorize(" " +(char)('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
            for (int col = 0; col < board[fil].length; col++)
                    System.out.print(" "+ board[fil][col] + " ");

            System.out.println(colorize(" " + (char) ('A'+fil) + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        }
        System.out.print(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        for(int i=0;i<board.length;i++)
            System.out.print(colorize(" " + i + " ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
        System.out.println(colorize("   ",Attribute.BLACK_BACK(),Attribute.WHITE_TEXT()));
    }

    public static void show(char[][] board){
        System.out.print("  ");
        for(int i=0;i<board.length;i++)
            System.out.print(" " + i + " ");
        System.out.println();
        for(int fil=0;fil< board.length;fil++ ) {
            System.out.print((char)('A'+fil) + " ");
            for (int col = 0; col < board[fil].length; col++) {
                if(board[fil][col] == ' '){
                    System.out.print(colorize("   ", Attribute.BACK_COLOR(6,11,95)));
                } else {
                    System.out.print(colorize("   ", Attribute.BACK_COLOR(66,24,8)));
                }

                //System.out.print(" " + board[fil][col] + " ");
            }
            System.out.println(" " + (char) ('A'+fil));
        }
        System.out.print("  ");
        for(int i=0;i<board.length;i++)
            System.out.print(" " + i + " ");
        System.out.println();
    }
}
