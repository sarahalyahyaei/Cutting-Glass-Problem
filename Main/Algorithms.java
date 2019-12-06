package Main;
/**
 * @Purpose: The Main.Algorithms class contains the two algorithms you have to implement
 * Do NOT modify the names and signatures of the two algorithm methods
 * @author RYK
 * @since 30/10/2019
 * extended by @author Sarah Al Yahyaei
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    private Sheet sheet;
    private int sheetNumber;
    private int shelfNumber;
    boolean noOfShapesLessThan20;
    int numberOfCurrentShapes;

    public int getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(int sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    /**
     * This method is used to implement the next fit algorithm
     *
     * @param shapes:a list of shapes representing customer requests(shapes to be
     *                 cut/placed)
     * @return a list of the sheets used to fulfil all customer requests (i.e.
     * place all the shapes). e.g. if you pass a "shapes" list that has
     * two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
     * of sheets should show us all the information needed (e.g. that
     * one sheet is used, this sheet has one shelf and this shelf has
     * two shapes in it). In the test program, you can use the returned
     * list to retrieve the total number of sheets used.
     **/

    public List <Sheet> nextFit(List <Shape> shapes) {

        /*
         * Start with an empty list of sheets (remember each sheet has a width
         * of 300 and a height of 250 as specified in the Main.Sheet class)
         */
        List <Sheet> usedSheets = new ArrayList <>();

        /*
         * Add in your own code so that the method will place all the shapes
         * according to NextFit under ALL the assumptions mentioned in the
         * specification
         */

        return usedSheets;
    }

    /**
     * This method is used to implement the first fit algorithm
     *
     * @param shapes:a list of shapes representing customer requests (shapes to be
     *                 cut/placed)
     * @return a list of the sheets used to fulfil all customer requests (i.e. place
     * all the shapes). e.g. if you pass a "shapes" list that has two
     * shapes {(w=200,h=200),(w=50,h=100)}, then the returned list of
     * sheets should show us all the information needed (e.g. that one
     * sheet is used, this sheet has one shelf and this shelf has two
     * shapes in it). In the test program, you can use the returned list
     * to retrieve the total number of sheets used
     **/
    public List <Sheet> firstFit(List <Shape> shapes) {

        /*
         * Start with an empty list of sheets (remember each sheet has a width
         * of 300 and a height of 250 as specified in the Main.Sheet class)
         */

        List <Sheet> usedSheets = new ArrayList <>();

        /**
         * Creating first sheet and first shelf
         */
        usedSheets.add(new Sheet()); //creating the first sheet index 0
        usedSheets.get(sheetNumber).addShelf(new Shelf());  //Create first shelf


        Shelf shelf = usedSheets.get(sheetNumber).getShelves().get(shelfNumber); //Accessing all shelves

        /**
         * accessing height and width of sheet
         */
        int sheetHeight = sheet.getHeight();
        int sheetWidth = sheet.getWidth();


        boolean thereIsSpace = usedSheets.get(sheetNumber).allShelvesHeight() < sheetHeight;  //Check if there is space on the sheet or not

        //Calculate number of shapes in that sheet
        for (Shelf shelves : usedSheets.get(sheetNumber).getShelves()) {
            numberOfCurrentShapes = +shelves.getShapes().size();
        }
        if (numberOfCurrentShapes <= 20) {
            noOfShapesLessThan20 = true;
        }



        //Loop through all shapes
        for (Shape shape : shapes) {
            while (thereIsSpace && noOfShapesLessThan20) {
                //Condition 1- if that shape added to that shelf width and their result is still less than sheet width and that shape's height is not bigger than
                // shelf height than that shape can be added to the sheet
                if (shape.getWidth() + shelf.getWidth() < sheetWidth && shape.getHeight() <= shelf.getHeight()) {
                    shelf.place(shape);
                }
                // Applying Rule B
                else if (shape.getHeight() + shelf.getWidth() < sheet.getWidth() && shape.getWidth() <= shelf.getHeight()) {
                    shape.rotate();
                    shelf.place(shape);
                } else if (shape.getWidth() + shelf.getWidth() > sheetWidth && shelf.getHeight() < sheetHeight) {
                    usedSheets.get(sheetNumber).addShelf(new Shelf());
                    shelfNumber++;
                }
            }
        }
        usedSheets.add(new Sheet());
        sheetNumber++;
        /*
         * Add in your own code so that the method will place all the shapes
         * according to FirstFit under the assumptions mentioned in the spec
         */

        return usedSheets;
    }

}
