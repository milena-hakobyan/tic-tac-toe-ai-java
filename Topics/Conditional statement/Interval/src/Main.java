import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println((num>-15 && num<=12)||(num>14 && num<17)
                            ||(num>=19)?"True":"False");
    }
}