package Test;

import Main.Algorithms;
import Main.Generator;
import Main.Shape;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author RYK
 * @Purpose: The Test.SortedTest class is used to compare the implemented algorithms
 * in term of the number of sheets used WHEN the list of
 * shapes is SORTED
 * <p>
 * You can add additional methods if you need to in this class
 * @since 30/10/2019
 * extended by  Sarah Al Yahyaei
 */

public class SortedTest {
    static Generator generatorTest1 = new Generator();

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("**************** Sorted Test ****************");
        System.out.println("*********************************************");
        System.out.println();
        System.out.println("Test 1 with 10000 shapes");
        test1();
        System.out.println("Test 2 with 20000 shapes");
        test2();
        System.out.println("Test 3 with 30000 shapes");
        test3();
        System.out.println("Test 4 with 40000 shapes");
        test4();
        System.out.println("Test 5 with 50000 shapes");
        test5();
        /*
         * Generate a random shape list and then check the number of sheets used
         * when
         ** this shape list is passed un-sorted
         ** the list is sorted based on different criteria as set in the speciication document.
         *
         * run several tests for different sizes of the "list of shapes"
         */

        /*
         * HINT: you might want to implements the compareTo method in the Main.Shape
         * class or implement the Comparator Interface to do the sorting
         */


    }

    public static void test1() {

        //  System.out.println("=================================Test 1 ========================== ");
        /**
         * Test for 10000 shapes
         */
        Algorithms algorithmsTest11 = new Algorithms(); //Test 1.1
        List <Shape> test1 = generatorTest1.generateShapeList(10000);
        Collections.sort(test1, Collections.reverseOrder());

        long startTime11 = new Date().getTime();
        algorithmsTest11.nextFit(test1);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Next fit performance");
        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest11.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest11.firstFit(test1);
        long endTime122 = new Date().getTime() - startTime122;
        System.out.println("First Fit performance");
        System.out.println("Running time was: " + endTime122);
        System.out.println("Number of sheets: " + algorithmsTest11.getKeepTrackingOfSheetNumberFF());

    }

    public static void test2() {
        /** Test 2 */

        /**
         * Test for 20000 shapes
         */
        Algorithms algorithmsTest21 = new Algorithms();
        List <Shape> test2 = generatorTest1.generateShapeList(20000);
        Collections.sort(test2, Collections.reverseOrder());

        long startTime11 = new Date().getTime();
        algorithmsTest21.nextFit(test2);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Next fit performance");
        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest21.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest21.firstFit(test2);
        long endTime122 = new Date().getTime() - startTime122;
        System.out.println("First Fit performance");
        System.out.println("Running time was: " + endTime122);
        System.out.println("Number of sheets: " + algorithmsTest21.getKeepTrackingOfSheetNumberFF());

    }

    public static void test3() {

        /** Test 3*/
        /**
         * Test for 30000 shapes
         */
        Algorithms algorithmsTest31 = new Algorithms();
        List <Shape> test3 = generatorTest1.generateShapeList(30000);
        Collections.sort(test3, Collections.reverseOrder());

        long startTime11 = new Date().getTime();
        algorithmsTest31.nextFit(test3);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Next fit performance");
        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest31.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest31.firstFit(test3);
        long endTime122 = new Date().getTime() - startTime122;
        System.out.println("First Fit performance");

        System.out.println("Running time was: " + endTime122);
        System.out.println("Number of sheets: " + algorithmsTest31.getKeepTrackingOfSheetNumberFF());


    }

    public static void test4() {


        /** test 4*/


        /**
         * Test for 40000 shapes
         */
        Algorithms algorithmsTest41 = new Algorithms(); //Test 4.1

        List <Shape> test4 = generatorTest1.generateShapeList(40000); //list 1
        Collections.sort(test4, Collections.reverseOrder());

        long startTime11 = new Date().getTime();
        algorithmsTest41.nextFit(test4);
        long endTime12 = new Date().getTime() - startTime11;
        System.out.println("Next fit performance");
        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest41.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest41.firstFit(test4);
        long endTime122 = new Date().getTime() - startTime122;
        System.out.println("First Fit performance");

        System.out.println("Running time was: " + endTime122);
        System.out.println("Number of sheets: " + algorithmsTest41.getKeepTrackingOfSheetNumberFF());

    }

    public static void test5() {
        /** Test 5 */

        /**
         * Test for 50000 shapes
         */
        Algorithms algorithmsTest51 = new Algorithms(); //Test 5.1
        List <Shape> test5 = generatorTest1.generateShapeList(50000);
        Collections.sort(test5, Collections.reverseOrder());

        long startTime11 = new Date().getTime();
        algorithmsTest51.nextFit(test5);
        long endTime12 = new Date().getTime() - startTime11;
        System.out.println("Next fit performance");

        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest51.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest51.firstFit(test5);
        long endTime122 = new Date().getTime() - startTime122;
        System.out.println("First Fit performance");

        System.out.println("Running time was: " + endTime122);
        System.out.println("Number of sheets: " + algorithmsTest51.getKeepTrackingOfSheetNumberFF());
    }


}
