package shapesDrawing;

public class Circle implements Drawable {
    private Integer radius;

    public Circle(Integer integer, Integer poll, int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        double rIn = this.radius - 0.4;
        double rOut = this.radius + 0.4;
        for (double y = this.radius; y >= -this.radius; --y) {
            for (double x = -this.radius; x < rOut; x += 0.5) {
                double value = x * x + y * y;
                if (value >= rIn * rIn && value <= rOut * rOut) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
