import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // The first operation goes here
        int op1 = input%2;
        System.out.println(op1);
        // The second operation goes here
        System.out.println(op1*3);
        scanner.close();
    }
}