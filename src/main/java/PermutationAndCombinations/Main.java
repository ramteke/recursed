package PermutationAndCombinations;

/**
 * Created by skynet on 15/04/17.
 */
class util {
    public static void SWAP(char[] arr, int index1, int index2) {
        char tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}

class PermutateStrings {

    public void recursed(char[] str, int index) {
        if (index >= str.length) {
            System.out.println(str);
        }

        for (int i = index; i < str.length; i++) {
            util.SWAP(str, i, index);
            recursed(str, index + 1);
            util.SWAP(str, i, index);
        }
    }
}

class Combination {

    public void recursed(char[] str, char outStr[], int index) {
        for (int i = index; i < str.length; i++) {

            outStr[i] = str[i];

            for (int ix = 0; ix <= i; ix++) {
                if (outStr[ix] != '-')
                    System.out.print(outStr[ix]);
            }
            System.out.println("");

            recursed(str, outStr, i + 1);
            outStr[i] = '-';

        }
    }

    //There is another approach for this which does not req. counting of data==R
    public void recursedForR(char[] str, char outStr[], int index, int R) {
        for (int i = index; i < str.length; i++) {

            outStr[i] = str[i];

            String printStr = "";
            for (int ix = 0; ix <= i; ix++) {
                if (outStr[ix] != '-') {
                    printStr += outStr[ix];
                }
            }
            if ( printStr.length() == R) {
                System.out.println(printStr);
            }


            recursedForR(str, outStr, i + 1, R);
            outStr[i] = '-';

        }
    }

}


public class Main {

    public static void main(String args[]) {

        char[] str = new char[]{'a', 'b', 'c', 'd'};

        System.out.println("---------------- All Permutations -----------------");
        new PermutateStrings().recursed(str, 0);

        System.out.println("---------------- All Combinations -----------------");
        char[] outStr = new char[str.length];
        for (int i = 0; i < outStr.length; i++) {
            outStr[i] = '-';
        }
        new Combination().recursed(str, new char[str.length], 0);

        System.out.println("---------------- All Combinations of length R -----------------");
        for (int i = 0; i < outStr.length; i++) {
            outStr[i] = '-';
        }
        new Combination().recursedForR(str, new char[str.length], 0, 3);

    }

}
