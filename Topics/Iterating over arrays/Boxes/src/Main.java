import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];

        for (int i = 0; i <3; i++)
            box1[i] = sc.nextInt();
        Arrays.sort(box1);
        for (int i = 0; i <3; i++)
            box2[i] = sc.nextInt();
        Arrays.sort(box2);

        boolean box1InsideBox2 = true;
        boolean box2InsideBox1 = true;

        for (int i = 0; i < 3; i++) {
            if (box1[i] >= box2[i]) {
                box1InsideBox2 = false;
            }
            if (box1[i] <= box2[i]) {
                box2InsideBox1 = false;
            }
        }

        if (box1InsideBox2) {
            System.out.println("Box 1 < Box 2");return;
        } else if (box2InsideBox1) {
            System.out.println("Box 1 > Box 2");return;
        } else {
            System.out.println("Incompatible");return;
        }
    }
}