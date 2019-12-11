package Test;

import Main.Algorithms;
import Main.Generator;
import Main.Shape;

import java.util.Date;
import java.util.List;

/**
 * @author RYK
 * @Purpose: The Test.PerformanceTest class is used to compare the implemented
 * algorithms in term of time and the number of sheets used
 * <p>
 * You can add additional methods if you need to in this class
 * @since 30/10/2019
 * extended by @author Sarah Al Yahyaei
 */

public class PerformanceTest {
    static Generator generatorTest1 = new Generator();


    public static void main(String[] args) throws InterruptedException {

        System.out.println("***********************************************");
        System.out.println("*********** Performance analysis **************");
        System.out.println("**********************************************");

        System.out.println();

        /**
         * Remember: You need to calculate the time and number of sheets used
         * for each run of each algorithm.
         *
         * You are expected to run several tests (e.g. noOfTests=5) of your
         * programs for, 10000, 20000, 30000, 40000, 50000 shapes
         * (noOfShapes=10000, increment=10000) so that one can see how the
         * algorithms perform for large datasets.
         *
         * You are expected to run the same test a number of times to ensure
         * accurate result (noOfRep=4). In this case, you need to calculate the
         * average time and sheets needed for each run
         **/

        // total number of tests - you need to CHANGE this value
        int noOfTests = 5;

        // number of repetitions for each test - you need to CHANGE this value
        int noOfRep = 4;

        // number of shapes needed for the first run - you need to CHANGE this
        // value
        int noOfShapes = 50000;

        // the increment in the number of shapes - you need to CHANGE this value
        int increment = 50000;
        test1();

//		test2();

        //	test3();
        //	test4();
        //	test5();

    }

    public static void test1() {
        /**
         * Test 1
         * 1: Test 1.1
         * 2: Test 1.2
         * 3: Test 1.3
         */

        System.out.println("=================================Test 1 ========================== ");
        System.out.println("Test 1.1:");

        /**
         * Test for 10000 shapes
         */
        Algorithms algorithmsTest11 = new Algorithms(); //Test 1.1
        List <Shape> test1 = generatorTest1.generateShapeList(10000);

        long startTime11 = new Date().getTime();
        algorithmsTest11.nextFit(test1);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest11.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest11.firstFit(test1);
        long endTime122 = new Date().getTime() - startTime122;

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
        long startTime11 = new Date().getTime();
        algorithmsTest21.nextFit(test2);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest21.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest21.firstFit(test2);
        long endTime122 = new Date().getTime() - startTime122;

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
        long startTime11 = new Date().getTime();
        algorithmsTest31.nextFit(test3);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest31.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest31.firstFit(test3);
        long endTime122 = new Date().getTime() - startTime122;

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
        long startTime11 = new Date().getTime();
        algorithmsTest41.nextFit(test4);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest41.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest41.firstFit(test4);
        long endTime122 = new Date().getTime() - startTime122;

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
        long startTime11 = new Date().getTime();
        algorithmsTest51.nextFit(test5);
        long endTime12 = new Date().getTime() - startTime11;

        System.out.println("Running time was: " + endTime12);
        System.out.println("Number of sheets: " + algorithmsTest51.getKeepTrackingOfSheetNumbersNF());

        long startTime122 = new Date().getTime();
        algorithmsTest51.firstFit(test5);
        long endTime122 = new Date().getTime() - startTime122;

        System.out.println("Running time was: " + endTime122);
        System.out.println("Number of sheets: " + algorithmsTest51.getKeepTrackingOfSheetNumberFF());
    }

}
