package LR_2;

interface Shape {
    double getArea();
    double getPerimeter();
}
class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    double getSide() {
        return side;
    }

    void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}
public class Example6 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        System.out.printf("Circle Area: %.2f, Perimeter: %.2f\n", circle.getArea(), circle.getPerimeter());
        System.out.printf("Square Area: %.2f, Perimeter: %.2f\n", square.getArea(), square.getPerimeter());
    }
}
