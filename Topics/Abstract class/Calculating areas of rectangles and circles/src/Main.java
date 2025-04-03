import java.util.Scanner;

// Define the abstract Shape class with an abstract area() method
abstract class Shape{
    abstract double area();
}
// Implement the Rectangle class that extends Shape
class Rectangle extends Shape{
    double width;
    double length;
    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    double area(){
        return width*length;
    }
}
// Implement the Circle class that extends Shape
class Circle extends Shape{
    double r;
    Circle(double r){this.r = r;}
    double area(){return Math.PI*r*r;}
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the dimensions of the rectangle
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        // Read the radius of the circle
        double radius = scanner.nextDouble();

        // Create instances of Rectangle and Circle
        Shape rectangle = new Rectangle(length, width);
        Shape circle = new Circle(radius);
        // Calculate and print the area of the rectangle
        System.out.println(rectangle.area());
        // Calculate and print the area of the circle
        System.out.println(circle.area());
        scanner.close();
    }
}