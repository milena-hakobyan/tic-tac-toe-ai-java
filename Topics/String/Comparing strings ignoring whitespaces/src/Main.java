import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        word1 = word1.replaceAll("\\s", "");
        word2 = word2.replaceAll("\\s", "");
        System.out.println((word1.equals(word2))? "true": "false");
    }
}