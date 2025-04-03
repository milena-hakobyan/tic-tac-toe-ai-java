import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        System.out.println((!isWeekend && (num>=10 && num<=20))||
                            isWeekend && (num>=15&& num<=25)? true:false);
    }
}