package AllPathsin2DArrayMatchingGivenPathSequence;

/**
 * Created by skynet on 14/04/17.
 */
public class Main {
    static String matchString = "RAMTEKE";

    public static boolean recursed(char arr[][], boolean result[][], int row, int col, int matchStringIndex) {
        if (row >= arr.length || col >= arr[0].length ) {
            if ( matchStringIndex == matchString.length()) {    //Reached END and matched Index also finished, //This is boundary condition.
                return true;
            } else {
                return false;  //This is our EXIT condition out of recursion
            }
        }

        if ( matchStringIndex == matchString.length()) {
            return true;  //Reached end of our matching string...We have a good path here.
        }

        if ( arr[row][col] != matchString.charAt(matchStringIndex) ) {
            return false;   //no point going forward on path.
        }


        boolean path1  = recursed(arr, result, row, col + 1,     matchStringIndex + 1);   //Horizontal
        boolean path2  = recursed(arr, result, row + 1, col,     matchStringIndex + 1);   //Vertical
        boolean path3  = recursed(arr, result, row + 1, col + 1, matchStringIndex + 1);   //Diagonal [left -> right ]

        return path1 || path2 || path3;

    }

    public static void main(String args[]) {
        char arr [][] = new char [10][];
        arr[0] = new char []  {  'A' , 'B' , 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        arr[1] = new char []  {  'R' , 'A' , 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};  //Start at 0
        arr[2] = new char []  {  'A' , 'M' , 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        arr[3] = new char []  {  'A' , 'T' , 'C', 'R', 'E', 'F', 'G', 'H', 'J', 'K'};  //Start at 3
        arr[4] = new char []  {  'R' , 'E' , 'C', 'D', 'A', 'F', 'G', 'H', 'J', 'K'};  //Start at 0
        arr[5] = new char []  {  'A' , 'K' , 'C', 'D', 'E', 'M', 'G', 'H', 'J', 'K'};
        arr[6] = new char []  {  'M' , 'E' , 'C', 'D', 'E', 'F', 'T', 'H', 'J', 'K'};
        arr[7] = new char []  {  'T' , 'B' , 'C', 'D', 'E', 'F', 'R', 'E', 'J', 'K'};  //False Start at 6
        arr[8] = new char []  {  'E' , 'B' , 'C', 'D', 'E', 'F', 'G', 'H', 'K', 'K'};
        arr[9] = new char []  {  'K' , 'R' , 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'E'};



        boolean results[][] = new boolean[arr.length][arr[0].length];  //For example sake, arr[0] is not NULL
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if ( matchString.charAt(0) == arr[row][col] ) {
                    //This index starts with 'R'...we will follow this trail
                    if ( recursed(arr, results, row, col, 0) == true ) {
                        System.out.println("GOOD  START: [" + row + ":" + col + "]");
                    } else {
                        System.out.println("FALSE START: [" + row + ":" + col + "]");
                    }
                }
            }

        }

    }
}
