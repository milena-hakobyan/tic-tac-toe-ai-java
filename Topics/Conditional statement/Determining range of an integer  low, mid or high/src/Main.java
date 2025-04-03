import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read the user input
        Scanner scanner = new Scanner(System.in);

        // Read an integer from the user
        int n = scanner.nextInt();

        System.out.println(n<5?"LOW":
                            n==5?"MID":"HIGH");
    }
}