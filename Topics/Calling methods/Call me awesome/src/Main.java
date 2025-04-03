import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s1 = "java";
        String s2 ="java";
        String s3 = s2;

        System.out.println(s1 == s2); // false
        System.out.println(s2 == s3); // true
    }

}