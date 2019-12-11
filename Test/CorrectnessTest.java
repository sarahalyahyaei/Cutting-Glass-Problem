package Test;

import Main.Algorithms;
import Main.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RYK
 * @Purpose: The Test.CorrectnessTest class is used to validate the correctness of
 * the implemented algorithms. You can add additional methods if you
 * need
 * @since 30/10/2019 extended by Sarah Al Yahyaei
 */

public class CorrectnessTest {
    static List <Shape> shapes = new ArrayList <>();

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("*********** Correctness testing *************");
        System.out.println("*********************************************");
        System.out.println();

        //First normal case these three shapes must be on the same shelf and same sheet both in first fit and next fit
        Algorithms algorithms = new Algorithms();
        Shape shape = new Shape(10, 30);
        Shape shape1 = new Shape(30, 30);
        Shape shape2 = new Shape(150, 9);
        shapes.add(shape);
        shapes.add(shape1);
        shapes.add(shape2);
        System.out.println("First Test FF: " + "Expected to be one sheet and one shelf \n" + algorithms.firstFit(shapes));
        System.out.println("First Test NF: " + "Expected to be one sheet and one shelf \n" + algorithms.nextFit(shapes));

        // if new shape cannot fit in the previous shelf than it is expected to create new shelf
        Algorithms algorithms1 = new Algorithms();
        Shape shape3 = new Shape(181, 110);
        shapes.add(shape3);
        System.out.println("Second Test FF: " + "Expected to be one sheet and two shelf \n" + algorithms1.firstFit(shapes));
        System.out.println("Second Test NF: " + "Expected to be one sheet and two shelf \n" + algorithms1.nextFit(shapes));

        //Border case when shape needed to be rotated
        Algorithms algorithms2 = new Algorithms();
        Shape shape4 = new Shape(30, 119);
        shapes.add(shape4);
        System.out.println("Third Test FF: Expected to be on the one sheet and on the second shelf \n" + algorithms2.firstFit(shapes));
        System.out.println("Third Test NF: Expected to be on the one sheet and on the second shelf \n" + algorithms2.nextFit(shapes));


        //Border case when shape can be fit in shelf one on sheet one in first fit
        // and it is expected to be on new shelf
        Algorithms algorithms3 = new Algorithms();
        Shape shape5 = new Shape(110, 30);
        shapes.add(shape5);
        System.out.println("Fourth Test FF: Expected to be on sheet one and on first shelf: \n" + algorithms3.firstFit(shapes));
        System.out.println("Fourth Test NF: Expected to be on sheet one and on new shelf: \n" + algorithms3.nextFit(shapes));

        /*
         * Here you will need to validate that your algorithms (nextFit() and
         * firstFit()) behave as expected on small data sets.
         * Think about normal cases and border cases.
         * You can use any additional method you created in this class
         */

    }
}
