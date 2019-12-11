package Main; /**
 * @Purpose: The Main.Shelf class represents a shelf with a list of shapes.
 * DO NOT MODIFY THE EXISTING METHODS, You may add additional methods if you wish
 * @author RYK
 * @since 30/10/2019
 * extended by Sarah Al Yahyaei
 */

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    // The used width: the width of all the shapes placed in the shelf
    private int usedWidth;

    // Main.Shelf height: Equals to the height of the first shape placed in the shelf
    private int shelfHeight;

    //List of shapes stored in the shelf
    List <Shape> shapes = new ArrayList <Shape>();

    /**
     * empty constructor
     */
    public Shelf() {

    }

    /**
     * @return Height of the shelf
     */
    public int getHeight() {

        if (shapes.size() != 0) {
            // equals to the height of shape placed at the left
            this.shelfHeight = shapes.get(0).getHeight();
            return this.shelfHeight;
        } else
            return 0;
    }

    /**
     * This method is used to place a shape on a shelf
     * @param shape: a shape
     */
    public void place(Shape shape) {

        // add shape width to the shelf width
        usedWidth += shape.getWidth();
        shapes.add(shape);
    }

    /**
     * @return list of all shapes placed in the shelf
     */
    public List <Shape> getShapes() {
        return shapes;
    }


    /**
     * @return the used width of the shelf
     */
    public int getWidth() {
        return usedWidth;
    }

    public String toString() {
        String toPrint;

        toPrint = "\nShapes that on the shelf: " + getShapes() + "\n";
        return toPrint;
    }

}
