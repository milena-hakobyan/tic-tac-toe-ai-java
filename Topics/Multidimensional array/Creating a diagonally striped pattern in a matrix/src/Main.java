class Main {
    public static void main(String[] args) {
        int condition1 = 175892;
        int condition2 = 98795;

        if ((condition1 & condition2) > 35925) {
            printXor(condition1 - condition2, condition1 | condition2); // 1
        } else {
            printXor(condition1 ^ condition2, condition1 & condition2); // 2
        }
    }

    static void printXor(int condition1, int condition2) {
        System.out.println(condition1 ^ condition2);
    }
}