package TripleRecursion;

/**
 * Created by skynet on 27/05/17.
 */
public class Main {

    private static int countSteps(int n) {
        if ( n < 0 ) return 1;
        if ( n == 0 ) return 1;
        return countSteps(n-1) + countSteps(n-2) + countSteps(n-3);
    }

    public static void main(String args[]) {
        System.out.println("Possible Ways: " + countSteps(10));  //Given 10 steps
    }
}
