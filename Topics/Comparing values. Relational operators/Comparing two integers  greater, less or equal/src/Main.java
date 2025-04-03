import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read two integers from the user
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // TODO: Compare num1 and num2 using relational operators
        int n = num1-num2;
        System.out.println((n<0)?'<':
                            (n>0)?'>':'=');

    }
}