package KeyPressToStringsCombinations;

import java.util.*;

/**
 * Created by skynet on 14/04/17.
 */
public class Main {
    static Map<String, String> key2ValueMap = new HashMap<String, String>();
    static String keyPressIndex [] ;

    public static void recursed(int levelCounter[], int levelMax[], int level) {
        if ( level >= levelCounter.length) {
            return;     //The EXIT condition out of recursion
        }

        for (int i = 0; i < levelMax[level]; i++) {
            printLevel(levelCounter);
            recursed(levelCounter, levelMax, level  + 1);     //Go to one level up

            levelCounter[level]++;                            //This level is done..so increment its counter. For 'abc', it will take you from 'a' to 'b'
            resetLevels(levelCounter, level+1);               //Next level needs equal changce to iterate again from 0. So reset it to 0th index
        }

    }


    public static void resetLevels(int levelCounter[] , int level) {
        //All leveles at level and till end to be 0'd
        for (int i = level; i < levelCounter.length; i++) {
            levelCounter[level] = 0;
        }
    }

    public static void main(String args[]) {
        key2ValueMap.put("1", "ABC");
        key2ValueMap.put("2", "DEF");
        key2ValueMap.put("3", "GHI");
        key2ValueMap.put("4", "JKL");
        key2ValueMap.put("5", "MNO");
        key2ValueMap.put("6", "PQR");
        key2ValueMap.put("7", "STU");
        key2ValueMap.put("8", "VWX");
        key2ValueMap.put("9", "YZ");

        String keyPressed = "259";

        int levelCounter [] = new int[keyPressed.length()];
        int levelMax [] = new int[keyPressed.length()];
        keyPressIndex = new String[keyPressed.length()];
        for (int i = 0; i < keyPressed.length(); i++) {
            levelCounter[i] = 0;
            String str = keyPressed.charAt(i) + "";
            keyPressIndex[i] = str;
            levelMax[i] = key2ValueMap.get(str).length();
        }
        recursed(levelCounter, levelMax, 0);

    }


    public static void printLevel(int levelCounter[]) {
        for (int i = 0; i < levelCounter.length; i++) {
            String key = keyPressIndex[i];
            String possibleCharacters = key2ValueMap.get(key);

            System.out.print(possibleCharacters.charAt(levelCounter[i]));
        }
        System.out.println("");
    }


}
