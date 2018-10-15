import java.io.PrintWriter;
import java.util.*;

public class Fib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++)
            value[i] = sc.nextInt();

        int[] res = new int[n + 1];
        res[1] = value[1];
        for (int i = 2; i < res.length; i++)
            res[i] = Math.max(res[i - 1], res[i - 2]) + value[i];
        System.out.println(res[n]);
    }
}








