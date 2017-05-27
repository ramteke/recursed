package EightQueen;

/**
 * Created by skynet on 27/05/17.
 */
public class Main {
    public static int[][] board;
    public static int MAX = 8;

    public  static boolean isValidPosition(int[][] board, int currRow, int currCol) {

        //Basic check
        for (int col = 0; col < currCol; col++) {
            if (board[currRow][col] == 1) {
                return false;
            }
        }

        // check upper diagonal
        for (int row = currRow, col = currCol; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1) {
                return false;
            }
        }

        // check lower diagonal
        for (int row = currRow, col = currCol; row < MAX && col >= 0; row++, col--) {
            if (board[row][col] == 1) {
                return false;
            }
        }

        return true;
    }




    public static boolean placeQueens(int colNo) {
        if(colNo== MAX){
            return true;
        }

        for (int row = 0; row < MAX; row++) {
            if (isValidPosition(board, row, colNo)) {

                board[row][colNo] = 1;

                if(placeQueens(colNo+1)){
                    return true;
                }

                board[row][colNo]=0;   //Cannot place...reset this position for other iterations to solve
            }
        }

        return false;

    }


    public static void main(String[] args) {

        board = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                board[i][j] = 0;
            }
        }

        boolean status = placeQueens(0);  //start at col 0

        //Print result
        if ( status ) {
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    System.out.print(" " + board[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println("No Solution !!!");
        }

    }
}

