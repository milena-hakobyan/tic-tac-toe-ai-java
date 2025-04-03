import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maximum = 0;

        int count = scanner.nextInt();

//        while(count>0){
//            int num = scanner.nextInt();
//            if(maximum<num && num%4==0)
//                maximum = num;
//        }
        do{
            int num = scanner.nextInt();
            if(maximum<num && num%4==0)
                maximum = num;
            count--;
        }while (count>0);

        System.out.println(maximum);

    }
}