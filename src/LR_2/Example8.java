package LR_2;
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("This animal makes a sound.");
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}


class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof Woof!");
    }

    public void wagTail() {
        System.out.println(name + " is wagging its tail.");
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }
}

class Cat extends Animal {
    private String furColor;

    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow Meow!");
    }

    public void purr() {
        System.out.println(name + " is purring.");
    }

    @Override
    public String toString() {
        return "Cat{name='" + name + "', age=" + age + ", furColor='" + furColor + "'}";
    }
}

class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet Tweet!");
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " is flying.");
        } else {
            System.out.println(name + " cannot fly.");
        }
    }

    @Override
    public String toString() {
        return "Bird{name='" + name + "', age=" + age + ", canFly=" + canFly + "}";
    }
}
abstract class Shape1 {
    abstract double getArea();
    abstract double getPerimeter();
}


class Circle1 extends Shape1 {
    private double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square1 extends Shape1 {
    private double side;

    public Square1(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}

class Triangle1 extends Shape1 {
    private double a, b, c;

    public Triangle1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));  // Формула Герона
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
public class Example8 {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Labrador");
        Cat cat = new Cat("Whiskers", 2, "Gray");
        Bird bird = new Bird("Tweety", 1, true);

        System.out.println(dog);
        dog.makeSound();
        dog.wagTail();

        System.out.println(cat);
        cat.makeSound();
        cat.purr();

        System.out.println(bird);
        bird.makeSound();
        bird.fly();

        Shape1 circle = new Circle1(5);
        Shape1 square = new Square1(4);
        Shape1 triangle = new Triangle1(3, 4, 5);

        System.out.println("Circle: Area: " + circle.getArea() + ", Perimeter: " + circle.getPerimeter());
        System.out.println("Square: Area: " + square.getArea() + ", Perimeter: " + square.getPerimeter());
        System.out.println("Triangle: Area: " + triangle.getArea() + ", Perimeter: " + triangle.getPerimeter());
    }
}
