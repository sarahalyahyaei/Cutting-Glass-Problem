package Main;

/**
 * @author RYK
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 * SIGNITURE OF EXISTING METHODS, You may add additional methods if
 * you wish
 * @since 30/10/2019
 * extended by @author Sarah Al Yahyaei
 **/

public class Shape implements Comparable <Shape> {

    private int sWidth;   // width of the shape
    private int sHeight;  // height of the shape

    /**
     * A Main.Shape constructor to set the width and height of a shape.
     *
     * @param width  of a shape
     * @param height of a shape
     **/
    public Shape(int width, int height) {

        // Main.Shape width and height should not be greater than the sheet width and height
        if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
            throw new IllegalArgumentException("Main.Shape width or height is not valid");
        }

        this.sWidth = width;
        this.sHeight = height;
    }

    /**
     * @return height of a shape
     **/
    public int getHeight() {
        return sHeight;
    }

    /**
     * @return width of a shape
     */
    public int getWidth() {
        return sWidth;
    }


    @Override
    public int compareTo(Shape o) {
        // You may want to implement this method
        if (this.sHeight < o.sHeight) {
            return -1;
        } else if (this.sWidth < o.sWidth) {
            return -1;
        }

        if (this.sHeight > o.sHeight) {
            return 1;
        } else if (this.sWidth > o.sWidth) {
            return 1;
        }
        return 0;
    }

    /**
     * Rotate method to rotate the shape to try fit it in a shelf
     */

    public void rotate() {
        int tem = sHeight;
        this.sHeight = sWidth;
        this.sWidth = tem;
    }


    public String toString() {
        return " Shape: Height =  " + getHeight() + " Width = " + getWidth();
    }

}
