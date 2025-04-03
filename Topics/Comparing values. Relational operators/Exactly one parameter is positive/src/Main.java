import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println((isPositive(a)&& !isPositive(b)&& !isPositive(c)) ||
                (isPositive(b)&& !isPositive(a)&& !isPositive(c)) ||
                (isPositive(c)&& !isPositive(b)&& !isPositive(a)) );
    }

    public static boolean isPositive(int n){
        return n>0;
    }

}