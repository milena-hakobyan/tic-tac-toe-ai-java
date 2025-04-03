import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int count = scanner.nextInt();
        int sum = 0;
        for(int i= 0; i < count; i++){
            int num = scanner.nextInt();
            sum = num%6==0? num+sum: sum;
        }
        System.out.println(sum);
    }
}