import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println((num%4==0 && num%100!=0 )|| num%400==0? "Leap":"Regular");

    }
}