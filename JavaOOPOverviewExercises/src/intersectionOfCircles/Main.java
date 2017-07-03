package intersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] firstCircleCoordinates = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double[] secondCircleCoordinates = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double x1 = firstCircleCoordinates[0];
        double y1 = firstCircleCoordinates[1];
        double firstRadius = firstCircleCoordinates[2];
        Point firstPoint = new Point(x1, y1);
        Circle firstCircle = new Circle(firstPoint, firstRadius);
        double x2 = secondCircleCoordinates[0];
        double y2 = secondCircleCoordinates[1];
        double secondRadius = secondCircleCoordinates[2];
        Point secondPpoint = new Point(x2, y2);
        Circle secondCircle = new Circle(secondPpoint, secondRadius);
        double distance = Math.sqrt(Math.pow((firstCircle.getCenter().getX() - secondCircle.getCenter().getX()), 2) +
                Math.pow((firstCircle.getCenter().getY() - secondCircle.getCenter().getY()), 2));
        boolean isIntersect = distance <= firstCircle.getRadius() + secondCircle.getRadius() ? true : false;
        System.out.println(isIntersect ? "Yes" : "No");
    }
}
