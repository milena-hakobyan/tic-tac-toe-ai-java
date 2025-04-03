import java.util.Scanner;

class Util {
    public static int indexOf(String src, String tgt, int index) {
        if (src.length() < tgt.length()) return -1;

        if(src.startsWith(tgt))
            return index;
        return indexOf(src.substring(1), tgt, ++index);

    }

    public static int indexOf(String sc, String tgt){
        return indexOf(sc, tgt, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(indexOf("Java", "ava"));
    }
}