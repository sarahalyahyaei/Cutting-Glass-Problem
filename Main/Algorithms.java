package Main;
/**
 * @Purpose: The Main.Algorithms class contains the two algorithms you have to implement
 * Do NOT modify the names and signatures of the two algorithm methods
 * @author RYK
 * @since 30/10/2019
 * extended by Sarah Al Yahyaei
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

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
        int keepTrackingOfSheetNumbers = 0;
        int keepTrackingOfShelfsNumbers = 0;

        for (Shape shape : shapes) {

            if (usedSheets.size() == 0) {
                usedSheets.add(new Sheet());
                keepTrackingOfSheetNumbers = 0; //new shelf on new sheet
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(0).place(shape);

            } else if (shape.getHeight() == 300 && shape.getWidth() == 250) {
                shape.rotate();
                usedSheets.add(new Sheet());
                ++keepTrackingOfSheetNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                keepTrackingOfShelfsNumbers = 0; //new shelf on new sheet
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).place(shape);
            }
            /**
             * This condition: if shelves height plust the new shape height will exceed the height limit than create new sheet
             * or if number of shapes on that sheet exceed the max number of shapes
             */
            else if ((usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight() + shape.getHeight() >= 250 && shape.getWidth() + usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight() >= 250)
                    || usedSheets.get(keepTrackingOfSheetNumbers).getShapeLimit() >= 20) {
                usedSheets.add(new Sheet());
                ++keepTrackingOfSheetNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                keepTrackingOfShelfsNumbers = 0;
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).place(shape);
            }
            /**
             * This condition will be true if the width of the shape plus that shelf still got a space left will equal less than 300
             * and height equal or less than shelf height than place that shape on the shelf
             */
            else if (shape.getWidth() + usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).getWidth() <= 300 ||
                    shape.getHeight() <= usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).getHeight()) {
                if (shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).getWidth() <= 300 && shape.getWidth() <= usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).getHeight()) {
                    shape.rotate();
                    usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).place(shape);
                } else if (shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight() < 250) {
                    usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                    ++keepTrackingOfShelfsNumbers;
                    usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).place(shape);
                } else {
                    usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).place(shape);
                }
            }
            //   else if(usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfsNumbers).getWidth() == 300 && usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight()+shape.getHeight() < 250){

            //    }
//
            /**
             * This condition will terminate if there is still a space on sheet height and shape can be added to that sheet if height shape plus
             * all shelves height won't exceed the max sheet height
             */
            else {

            }

        }
        System.out.println(keepTrackingOfSheetNumbers);

        return usedSheets;
    }
}
