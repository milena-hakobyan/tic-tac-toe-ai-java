import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxTemperature = 0; // Initialize maximum temperature observed
        int num;
        // Add your while loop or do-while loop here to process input temperatures
        do{
            num = scanner.nextInt();
            if(num > maxTemperature && num<100)
                maxTemperature = num;
        }while(num<100);
        // After exiting the loop, print the highest temperature
        System.out.println(maxTemperature);

        scanner.close(); // Close the scanner
    }
}