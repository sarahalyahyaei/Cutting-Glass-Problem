package Main;

import java.util.List;

public class fsd {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List <Shape> shapes = generator.generateShapeList(10000);
        Algorithms algorithms = new Algorithms();
        long startedTime = System.currentTimeMillis();
        algorithms.firstFit(shapes);
        long endTime = System.currentTimeMillis() - startedTime;
        System.out.println(endTime);

        long startTime = endTime;
        algorithms.nextFit(shapes);
        long endTime1 = System.currentTimeMillis() - startedTime;
        System.out.println(endTime1);

    }
}
