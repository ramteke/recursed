package MultipleCriteriaOrdering;

/**
 * Created by skynet on 27/05/17.
 */

class Box {
    private int height = 0;
    private int weight = 0;
    private int depth = 0;

    public Box(int height, int weight, int depth) {
        this.height = height;
        this.weight = weight;
        this.depth = depth;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isValid(Box anotherBox) {
        return (this.weight >= anotherBox.weight && this.depth >= anotherBox.depth);
    }
}

public class Main {

    private static int calculateHeight(Box [] boxes, Box baseBox, int index, Integer [] height) {

        if ( index >= height.length) {
            return 0;
        }
        Box newBox = boxes[index];

        int withNewBoxHeight  = 0;
        if ( baseBox == null || baseBox.isValid(newBox)) {
            if ( height[index] == null ) {
                height[index] = newBox.getHeight() + calculateHeight(boxes, newBox, index+1, height);
            }
            withNewBoxHeight = height[index];
        }

        int withOldBoxHeigh = calculateHeight(boxes, baseBox, index+1, height);

        return Math.max(withNewBoxHeight, withOldBoxHeigh);

    }

    public static void main(String args[]) {

        Box [] boxes = new Box[4];
        boxes[0] = new Box(12, 4,10);
        boxes[1] = new Box(11, 10,30);
        boxes[2] = new Box(10, 12,50);
        boxes[3] = new Box( 5, 6,20);

        Integer height[] = new Integer[boxes.length];
        for (int i = 0; i < height.length; i++) {
            height[0] = null;
        }

        int maxHeightPossible = calculateHeight(boxes,null, 0, height);
        System.out.println("MAX Height: " + maxHeightPossible);   //Ans: 16


    }

}
