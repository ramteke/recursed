package MultipleCriteriaOrdering;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by skynet on 28/01/17.
 */
public class BoxRecursion {
    static class Box {
        public String name;
        public int height;
        public int weight;

        public Box(String name, int a, int b) {
            this.name = name;
            this.height = a;
            this.weight = b;
        }

        public boolean isValidBoxOnThisBaseBox(Box box2) {
            if ( box2.weight < this.weight) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static int addBox(List<Box> boxes, Box baseBox, int insertIndex, int size[]) {
        if ( insertIndex >= boxes.size()) {
            return 0;
        }

        int withBase = 0;
        Box newBox = boxes.get(insertIndex);
        if ( baseBox == null || baseBox.isValidBoxOnThisBaseBox(newBox) ) {
            if ( size[insertIndex] == 0 ) {  //if size not yet calculated
                size[insertIndex] = newBox.height + addBox(boxes, newBox, insertIndex+1, size);
            }
            withBase = size[insertIndex];
        }

        int withoutBase = addBox(boxes, baseBox, insertIndex+1, size);

        return Math.max(withBase, withoutBase);


    }


    public static void main(String args[]) {
        List<Box> boxes = new LinkedList<Box>();
        Box b1 = new Box("A", 12, 4);
        Box b2 = new Box("B", 11, 10);
        Box b3 = new Box("C", 10, 12);
        Box b4 = new Box("D", 5, 6);
        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);
        boxes.add(b4);

        int size [] = new int[10];
        for ( int i = 0; i < 10; i++) {
            size[i] = 0;
        }
        System.out.println(">> " + addBox(boxes, null, 0, size));

        for (int i = 0; i < size.length; i++) {
            System.out.println("BOX [" + i + "] : " + size[i]);
        }
    }

}

