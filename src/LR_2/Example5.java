package LR_2;

class Rectangle {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double getLength() {
        return length;
    }

    double getWidth() {
        return width;
    }

    void setLength(double length) {
        this.length = length;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double getArea() {
        return width * length;
    }

    double getPerimeter() {
        return (width + length) * 2;
    }
}

public class Example5 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);
        System.out.printf("Rectangle length: %.2f, width: %.2f\n", rect.getLength(), rect.getWidth());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());

        rect.setLength(10);
        rect.setWidth(4);

        System.out.printf("\nUpdated length: %.2f, width: %.2f\n", rect.getLength(), rect.getWidth());
        System.out.println("Updated Area: " + rect.getArea());
        System.out.println("Updated Perimeter: " + rect.getPerimeter());
    }
}
