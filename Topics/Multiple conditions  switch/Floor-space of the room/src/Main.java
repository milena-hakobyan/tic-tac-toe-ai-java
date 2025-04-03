import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.next();
        switch (shape){
            case "rectangle":
                System.out.println(scanner.nextDouble()* scanner.nextDouble());
                break;
            case "circle":
                double r = scanner.nextDouble();
                System.out.println(3.14* r*r);
                break;
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) / 2; // half of paramiter of triangle
                System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                break;
        }
    }
}