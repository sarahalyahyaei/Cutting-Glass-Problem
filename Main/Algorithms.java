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
    private List <Sheet> usedSheetsFF = new ArrayList <>();
    private int keepTrackingOfSheetNumbersNF = 0; //To keep tracking the sheet numbers for Next Fit
    private int keepTrackingOfSheetNumberFF = 0;  //To keep tracking the sheet numbers for Next Fit


    public int getKeepTrackingOfSheetNumbersNF() {
        return keepTrackingOfSheetNumbersNF;
    }

    public int getKeepTrackingOfSheetNumberFF() {
        return keepTrackingOfSheetNumberFF;
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

        List <Sheet> usedSheets = new ArrayList <>();

        int keepTrackingOfShelfNumbers = 0; //Tracking shelf numbers for each sheet

        //Loop through all shapes
        for (Shape shape : shapes) {
            //If there is no sheets yet than create one
            if (usedSheets.size() == 0) {
                usedSheets.add(new Sheet());
                keepTrackingOfSheetNumbersNF = 0; //new shelf on new sheet
                usedSheets.get(keepTrackingOfSheetNumbersNF).addShelf(new Shelf());
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(0).place(shape);
            }

            /**
             * The following conditions apply the rules from A-F
             */

            else if (shape.getHeight() == 300 && shape.getWidth() == 250) {
                shape.rotate();
                usedSheets.add(new Sheet());
                ++keepTrackingOfSheetNumbersNF;
                usedSheets.get(keepTrackingOfSheetNumbersNF).addShelf(new Shelf());
                keepTrackingOfShelfNumbers = 0; //new shelf on new sheet
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if (shape.getWidth() + usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).getWidth() <= 300 &&
                    shape.getHeight() <= usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).getHeight() &&
                    usedSheets.get(keepTrackingOfSheetNumbersNF).getShapeLimit() < 20) {
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if (shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).getWidth() <= 300
                    && shape.getWidth() <= usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).getHeight()
                    && usedSheets.get(keepTrackingOfSheetNumbersNF).getShapeLimit() < 20) {
                shape.rotate();
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if ((shape.getHeight() > usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).getHeight()
                    && shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbersNF).allShelvesHeight() <= 250 &&
                    usedSheets.get(keepTrackingOfSheetNumbersNF).getShapeLimit() < 20)) {
                usedSheets.get(keepTrackingOfSheetNumbersNF).addShelf(new Shelf());
                ++keepTrackingOfShelfNumbers;
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);

            } else if (shape.getWidth() + usedSheets.get(keepTrackingOfSheetNumbersNF).allShelvesHeight() < 250 &&
                    usedSheets.get(keepTrackingOfSheetNumbersNF).getShapeLimit() < 20) {
                shape.rotate();
                usedSheets.get(keepTrackingOfSheetNumbersNF).addShelf(new Shelf());
                ++keepTrackingOfShelfNumbers;
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            } else if ((shape.getHeight() + usedSheets.get(keepTrackingOfSheetNumbersNF).allShelvesHeight() <= 250)
                    && usedSheets.get(keepTrackingOfSheetNumbersNF).getShapeLimit() < 20) {
                usedSheets.get(keepTrackingOfSheetNumbersNF).addShelf(new Shelf());
                ++keepTrackingOfShelfNumbers;
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            }
            /**
             * This condition: if shelves height plus the new shape height will exceed the height limit than create new sheet
             * or if number of shapes on that sheet exceed the max number of shapes
             */
            else {
                usedSheets.add(new Sheet());
                ++keepTrackingOfSheetNumbersNF;
                usedSheets.get(keepTrackingOfSheetNumbersNF).addShelf(new Shelf());
                keepTrackingOfShelfNumbers = 0; //Start new shelf
                usedSheets.get(keepTrackingOfSheetNumbersNF).getShelves().get(keepTrackingOfShelfNumbers).place(shape);
            }

        }
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

        int keepTrackingOfShelfNumber = 0;
        //Loop through shapes
        for (Shape shape : shapes) {
            if (usedSheetsFF.size() == 0) {
                // create first sheet
                usedSheetsFF.add(new Sheet());
                //create first shelf
                usedSheetsFF.get(keepTrackingOfSheetNumberFF).addShelf(new Shelf());
                usedSheetsFF.get(keepTrackingOfSheetNumberFF).getShelves().get(keepTrackingOfShelfNumber).place(shape);
            } else if (shape.getHeight() == 300 && shape.getWidth() == 250) {
                shape.rotate();
                usedSheetsFF.add(new Sheet());
                ++keepTrackingOfSheetNumberFF;
                usedSheetsFF.get(keepTrackingOfSheetNumberFF).addShelf(new Shelf());
                keepTrackingOfShelfNumber = 0; //new shelf on new sheet
                usedSheetsFF.get(keepTrackingOfSheetNumberFF).getShelves().get(keepTrackingOfShelfNumber).place(shape);
            }
            //This condition will check if there are still sheets that have a space to add new shape on it
            // instead of creating new sheet
            else if (checkIfOtherSheets(shape)) {

            } else {
                usedSheetsFF.add(new Sheet());
                ++keepTrackingOfSheetNumberFF;
                usedSheetsFF.get(keepTrackingOfSheetNumberFF).addShelf(new Shelf());
                usedSheetsFF.get(keepTrackingOfSheetNumberFF).getShelves().get(0).place(shape);
            }
        }
        return usedSheetsFF;
    }

    // Method used to loop through all sheets to check if there is still a space to new shape for First Fit
    public boolean checkIfOtherSheets(Shape shape) {
        boolean thereIsSpeace = false;
        for (int sheet = 0; sheet < usedSheetsFF.size(); sheet++) {
            for (int shelf = 0; shelf < usedSheetsFF.get(sheet).getShelves().size(); shelf++) {
                if (shape.getHeight() <= usedSheetsFF.get(sheet).getShelves().get(shelf).getHeight()
                        && shape.getWidth() + usedSheetsFF.get(sheet).getShelves().get(shelf).getWidth() <= 300) {
                    usedSheetsFF.get(sheet).getShelves().get(shelf).place(shape);
                    thereIsSpeace = true;
                    break;
                } else if (shape.getWidth() <= usedSheetsFF.get(sheet).getShelves().get(shelf).getHeight() &&
                        shape.getHeight() + usedSheetsFF.get(sheet).getShelves().get(shelf).getWidth() <= 300) {
                    shape.rotate();
                    usedSheetsFF.get(sheet).getShelves().get(shelf).place(shape);
                    thereIsSpeace = true;
                    break;
                }
                /**
                 * Ignore these following comments
                 */
                //This condition hopefully will correct the error that is occur on my fourth test in correctness test
//                else if(usedSheetsFF.get(sheet).getShelves().size() > 1) {
//                    for (int shelf1 = 1; shelf1 < usedSheetsFF.get(sheet).getShelves().size(); shelf++) {
//                        if (shape.getHeight() <= usedSheetsFF.get(sheet).getShelves().get(shelf1).getHeight()
//                                && shape.getWidth() + usedSheetsFF.get(sheet).getShelves().get(shelf1).getWidth() <= 300) {
//                            usedSheetsFF.get(sheet).getShelves().get(shelf).place(shape);
//                            thereIsSpeace = true;
//                            break;
//                        } else if (shape.getWidth() <= usedSheetsFF.get(sheet).getShelves().get(shelf).getHeight() &&
//                                shape.getHeight() + usedSheetsFF.get(sheet).getShelves().get(shelf).getWidth() <= 300) {
//                            shape.rotate();
//                            usedSheetsFF.get(sheet).getShelves().get(shelf).place(shape);
//                            thereIsSpeace = true;
//                            break;
//                        } else {
//                            continue;
//                        }
//                    }
//                }
//                else if (shape.getWidth() + usedSheetsFF.get(sheet).getShelves().get(shelf).getWidth() > 300
//                        && shape.getHeight() + usedSheetsFF.get(sheet).allShelvesHeight() <= 250){
//                   break;
//                }

                else if (shape.getWidth() + usedSheetsFF.get(sheet).getShelves().get(shelf).getWidth() > 300
                        && shape.getHeight() + usedSheetsFF.get(sheet).allShelvesHeight() <= 250) {
                    usedSheetsFF.get(sheet).addShelf(new Shelf());
                    usedSheetsFF.get(sheet).getShelves().get(usedSheetsFF.get(sheet).getShelves().size() - 1).place(shape);
                    thereIsSpeace = true;
                    break;
                }
//                else if (shape.getHeight() + usedSheetsFF.get(sheet).getShelves().get(shelf).getWidth() > 300
//                        && shape.getWidth() + usedSheetsFF.get(sheet).allShelvesHeight() <= 250) {
//                    shape.rotate();
//                    usedSheetsFF.get(sheet).addShelf(new Shelf());
//                    usedSheetsFF.get(sheet).getShelves().get(usedSheetsFF.get(sheet).getShelves().size() - 1).place(shape);
//                    thereIsSpeace = true;
//                    break;
//                }
                /**
                 * Else here will iterate through every sheet if there is no space and maybe there is space in other sheets
                 */
                else {
                    thereIsSpeace = false;
                    continue;
                }
            }
        }

        return thereIsSpeace;
    }
}

