package CombineMultipleStringsInSequence;

import java.util.*;

/**
 * Created by skynet on 14/04/17.
 */
public class Main {

    public static void recursed(List<String> allLines, Map<Integer, Integer> allIndexs, String outStr) {
        //Check if all Indexs have reached limit
        boolean limitReached = true;
        for ( Integer index : allIndexs.keySet()) {
            if (allIndexs.get(index) < allLines.get(index).length()) {
                limitReached = false;
                break;
            }
        }

        if ( limitReached ) {
            System.out.println(outStr);
            return;  //EXIT Condition
        }

        for (Integer index : allIndexs.keySet()) {
            int currLength = allIndexs.get(index);
            if ( currLength < allLines.get(index).length()) {
                allIndexs.put(index, currLength + 1);
                recursed(allLines, allIndexs, outStr + allLines.get(index).charAt(currLength));
                allIndexs.put(index, currLength);
            }
        }
    }

    public static void main(String args[]) {
        List<String> allLines = new LinkedList<String>();
        Map<Integer, Integer> allIndex = new HashMap<Integer,Integer>();
        allLines.add("abcd");
        allLines.add("xyz");
        allLines.add("123");

        for (int i = 0; i < allLines.size(); i++) {
            allIndex.put(i, 0);
        }

        recursed(allLines, allIndex, "");
    }



}
