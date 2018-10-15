import java.io.PrintWriter;
import java.util.*;

public class Fib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 2; i <= n ; i++) {
            res[i] = res[i - 1] + 1;
            prev[i] = i - 1;
            if (i % 2 == 0 && res[i] > res[i / 2] + 1) {
                res[i] = res[i / 2] + 1;
                prev[i] = i / 2;
            }
            if (i % 3 == 0 && res[i] > res[i / 3] + 1) {
                res[i] = res[i / 3] + 1;
                prev[i] = i / 3;
            }
        }
        System.out.println(res[n]);
        printAnswer(prev, n);
    }

    public static void printAnswer(int[] prev, int i) {
        if (i != 1)
            printAnswer(prev, prev[i]);
        System.out.print(i + " ");
    }
}








