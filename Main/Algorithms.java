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
    List <Sheet> usedSheetsFF = new ArrayList <>();

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
        int keepTrackingOfSheetNumbers = 0;
        int keepTrackingOfShelfNumbers = 0;

        for (Shape shape : shapes) {

            if (usedSheets.size() == 0) {
                usedSheets.add(new Sheet());
                keepTrackingOfSheetNumbers = 0; //new shelf on new sheet
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(0).place(shape);
            }
            /**
             * The following conditions apply the rules from A-F
             */

            else if (shape.getHeight() == 300 && shape.getWidth() == 250) {
                shape.rotate();
                usedSheets.add(new Sheet());
                ++keepTrackingOfSheetNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                keepTrackingOfShelfNumbers = 0; //new shelf on new sheet
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if (shape.getWidth() + usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).getWidth() <= 300 &&
                    shape.getHeight() <= usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).getHeight() &&
                    usedSheets.get(keepTrackingOfSheetNumbers).getShapeLimit() < 20) {
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if (shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).getWidth() <= 300
                    && shape.getWidth() <= usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).getHeight()
                    && usedSheets.get(keepTrackingOfSheetNumbers).getShapeLimit() < 20) {
                shape.rotate();
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if (shape.getWidth() + usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight() < 250 &&
                    usedSheets.get(keepTrackingOfSheetNumbers).getShapeLimit() < 20) {
                shape.rotate();
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                ++keepTrackingOfShelfNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if ((shape.getHeight() > usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).getHeight()
                    && shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight() <= 250 &&
                    usedSheets.get(keepTrackingOfSheetNumbers).getShapeLimit() < 20)) {
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                ++keepTrackingOfShelfNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);

            } else if ((shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbers).allShelvesHeight() <= 250)
                    && usedSheets.get(keepTrackingOfSheetNumbers).getShapeLimit() < 20) {
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                ++keepTrackingOfShelfNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            }

            /**
             * This condition: if shelves height plus the new shape height will exceed the height limit than create new sheet
             * or if number of shapes on that sheet exceed the max number of shapes
             */
            else {
                usedSheets.add(new Sheet());
                ++keepTrackingOfSheetNumbers;
                usedSheets.get(keepTrackingOfSheetNumbers).addShelf(new Shelf());
                keepTrackingOfShelfNumbers = 0; //Start new shelf
                usedSheets.get(keepTrackingOfSheetNumbers).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            }

        }
        System.out.println(++keepTrackingOfSheetNumbers);
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

        int keepTrackingOfSheetNumber = 0;
        int keepTrackingOfShelfNumber = 0;
        for (Shape shape : shapes) {
            if (usedSheetsFF.size() == 0) {
                // create first sheet
                usedSheetsFF.add(new Sheet());
                //create first shelf
                usedSheetsFF.get(keepTrackingOfSheetNumber).addShelf(new Shelf());
                usedSheetsFF.get(keepTrackingOfSheetNumber).getShelves().get(keepTrackingOfShelfNumber).place(shape);
            } else if (shape.getHeight() == 300 && shape.getWidth() == 250) {
                shape.rotate();
                usedSheetsFF.add(new Sheet());
                ++keepTrackingOfSheetNumber;
                usedSheetsFF.get(keepTrackingOfSheetNumber).addShelf(new Shelf());
                keepTrackingOfShelfNumber = 0; //new shelf on new sheet
                usedSheetsFF.get(keepTrackingOfSheetNumber).getShelves().get(keepTrackingOfShelfNumber).place(shape);
            }
            //This condition will check if there are still sheets that have a space to add new shape on it
            // instead of creating new sheet
            else if (checkIfOtherSheets(shape)) {

            } else {
                usedSheetsFF.add(new Sheet());
                ++keepTrackingOfSheetNumber;
                usedSheetsFF.get(keepTrackingOfSheetNumber).addShelf(new Shelf());
                usedSheetsFF.get(keepTrackingOfSheetNumber).getShelves().get(0).place(shape);
            }
        }
        System.out.println(++keepTrackingOfSheetNumber);
        return usedSheetsFF;
    }

    // Method used to loop through all sheets to check if there is still a space to new shape for First Fit
    public boolean checkIfOtherSheets(Shape shape) {
        boolean thereIsSpeace = false;
        for (int sheet = 0; sheet < usedSheetsFF.size(); sheet++) {
            int lastShelf = usedSheetsFF.get(sheet).getShelves().size() - 1;
            if (shape.getHeight() <= usedSheetsFF.get(sheet).getShelves().get(lastShelf).getHeight()
                    && shape.getWidth() + usedSheetsFF.get(sheet).getShelves().get(lastShelf).getWidth() <= 300) {
                usedSheetsFF.get(sheet).getShelves().get(lastShelf).place(shape);
                thereIsSpeace = true;
                break;
            } else if (shape.getHeight() + usedSheetsFF.get(sheet).getShelves().get(lastShelf).getWidth() >= 300
                    && shape.getWidth() + usedSheetsFF.get(sheet).allShelvesHeight() <= 250) {
                shape.rotate();
                usedSheetsFF.get(sheet).addShelf(new Shelf());
                usedSheetsFF.get(sheet).getShelves().get(lastShelf + 1).place(shape);
                thereIsSpeace = true;
                break;
            } else if (shape.getWidth() + usedSheetsFF.get(sheet).getShelves().get(lastShelf).getWidth() >= 300
                    && shape.getHeight() + usedSheetsFF.get(sheet).allShelvesHeight() <= 250) {
                usedSheetsFF.get(sheet).addShelf(new Shelf());
                usedSheetsFF.get(sheet).getShelves().get(lastShelf + 1).place(shape);
                thereIsSpeace = true;
                break;
            } else {
                thereIsSpeace = false;
                continue;
            }
        }

        return thereIsSpeace;
    }
}

