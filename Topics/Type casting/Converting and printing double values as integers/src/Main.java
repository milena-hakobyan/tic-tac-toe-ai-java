import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number as a double.
        double num = scanner.nextDouble();
        // Convert and print the number to an integer.
        int a = (int) num;
        // TODO: Write your code here to convert the double to an integer and print it out to the console
        System.out.println(a);
        scanner.close();
    }
}