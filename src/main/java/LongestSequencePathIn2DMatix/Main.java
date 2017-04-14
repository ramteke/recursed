package LongestSequencePathIn2DMatix;

/**
 * Created by skynet on 14/04/17.
 */
public class Main {

    public static int recursed(char arr[][], int row, int col, int pathLength, char prev) {
        if   ( row >= arr.length && col >= arr[0].length) {
            return pathLength;
        }
        char c = arr[row][col];

        if ( prev != '-' && arr[row][col] != prev + 1) { //ASCII match
            return pathLength ;
        }

        int sidePathLength = 0;
        if ( col + 1 < arr[0].length ) {
            sidePathLength = recursed(arr, row, col + 1, pathLength + 1, arr[row][col]);

        }

        int downPathLength = 0;
        if ( row + 1 < arr.length ) {
            downPathLength = recursed(arr, row + 1, col, pathLength + 1, arr[row][col]);
        }


        return Math.max(pathLength,  Math.max(sidePathLength, downPathLength));
    }

    public static void main(String args[]) {

        char arr [][] = new char [10][];
        arr[0] = new char []  {  'A' , 'D' , 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        arr[1] = new char []  {  'R' , 'A' , 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        arr[2] = new char []  {  'A' , 'M' , 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'L'};
        arr[3] = new char []  {  'A' , 'T' , 'A', 'B', 'E', 'F', 'G', 'H', 'J', 'K'}; //10 len at [3][2]
        arr[4] = new char []  {  'R' , 'E' , 'C', 'C', 'A', 'F', 'G', 'H', 'J', 'K'};
        arr[5] = new char []  {  'A' , 'K' , 'C', 'D', 'E', 'M', 'G', 'H', 'J', 'K'};
        arr[6] = new char []  {  'M' , 'E' , 'C', 'E', 'E', 'F', 'T', 'H', 'J', 'K'};
        arr[7] = new char []  {  'T' , 'B' , 'C', 'F', 'E', 'F', 'R', 'E', 'J', 'K'};
        arr[8] = new char []  {  'E' , 'B' , 'C', 'G', 'E', 'F', 'G', 'H', 'K', 'K'};
        arr[9] = new char []  {  'K' , 'R' , 'C', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};

        int maxLength = 0;



        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                maxLength = Math.max(maxLength, recursed(arr, i, j, 0, '-'));
            }
        }

        System.out.println("MAX PATH LANGTH: " + maxLength);

    }


}
