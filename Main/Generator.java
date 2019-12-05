package Main; /**
 * @Purpose: The Main.Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * @author RYK
 * @since 30/10/2019
 * extended by @author Sarah AlYahyaei
 */

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static final int MAX_SIZE_HEIGHT = 250;
    public static final int MAX_SIZE_WIDTH = 300;

    /**
     * This method will generate a list of shapes of random width and height
     * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive.
     * The random height is between 1 and MAX_SIZE_HEIGHT inclusive.
     *
     * @param numberOfShapes: the number of shapes to generate
     * @return a list of shapes of random sizes
     */
    public List <Shape> shapes = new ArrayList <Shape>();

    public List <Shape> generateShapeList(int numberOfShapes) {

        //Number of elements in generateShapeList == i
        for (int i = 0; i < numberOfShapes; i++) {
            //Generating random numbers between the given ranges
            //For height from 1 till 250
            //For width 1 till 300
            int randomHeights = (int) (Math.random() * (MAX_SIZE_HEIGHT - 1) + 1) + 1;
            int randomWidths = (int) (Math.random() * (MAX_SIZE_WIDTH - 1) + 1) + 1;

            shapes.add(new Shape(randomWidths, randomHeights));
        }

        return shapes;
    }

    //Print shapes ONLY for test
    public void printShapes() {
        for (Shape shape : shapes) {
            System.out.println("Width:" + shape.getWidth() + " Height:" + shape.getHeight());
        }
    }

    //To return the size of an array and than to calculate the lower bound and compare it with
    // the results for first fit and next fit
    public int numberOfShapes() {
        return shapes.size();
    }


}