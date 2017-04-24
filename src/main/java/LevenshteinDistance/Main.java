package LevenshteinDistance;

/**
 * Created by skynet on 24/04/17.
 */
public class Main {

    /*
       https://people.cs.pitt.edu/~kirk/cs1501/Pruhs/Spring2006/assignments/editdistance/Levenshtein%20Distance.htm

       Levenshtein distance (LD) is a measure of the similarity between two strings, which we will refer to as the source string (s) and the target string (t).
       The distance is the number of deletions, insertions, or substitutions required to transform s into t.

       The greater the Levenshtein distance, the more different the strings are.

       The Levenshtein distance algorithm has been used in: Spell checking, Speech recognition, DNA analysis, Plagiarism detection


     */

    public static int getMinimumDistance(String str1, String str2 ) {
        int distance[][] = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                //Check initialization
                if (i == 0)
                    distance[i][j] = j;   //If i is zero, minimum diff between two words is 2nd word's length
                else if (j == 0)
                    distance[i][j] = i;   //If j is zero, minimum diff between two words is 1st word's length

                else if (str1.charAt(i - 1) == str2.charAt(j - 1))  // Words were similar earlier..so current distance is old distance
                    distance[i][j] = distance[i - 1][j - 1];

                else //Words not same.  minimum distance is Min of previous left, right OR diagonal
                    distance[i][j] = 1 + Math.min(distance[i][j - 1], Math.min(distance[i - 1][j], distance[i - 1][j - 1]));
            }
        }
        return distance[str1.length() - 1][str2.length() - 1];
    }


    public static void main(String args[]) {

        System.out.println(getMinimumDistance("refactor", "refaor"));  //2
        System.out.println(getMinimumDistance("refactor", "refacor"));  //1
        System.out.println(getMinimumDistance("refactor", "cto"));  //5

    }

}
