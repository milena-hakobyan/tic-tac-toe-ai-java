import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isSunny = scanner.nextBoolean();
        boolean isRainy = scanner.nextBoolean();
        boolean isCold = scanner.nextBoolean();
        System.out.println(isSunny&&!(isRainy || isCold));
        // Calculate and print decision

        scanner.close();
    }
}