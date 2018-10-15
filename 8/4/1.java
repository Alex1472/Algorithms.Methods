import java.io.PrintWriter;
import java.util.*;

public class Fib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int n = sc.nextInt();

        int[] weights = new int[n + 1];
        for (int i = 1; i < weights.length; i++)
            weights[i] = sc.nextInt();

        int[][] res = new int[W + 1][n + 1];
        for (int i = 1; i < W + 1; i++)
            for (int j = 1; j < n + 1; ++j) {
                res[i][j] = res[i][j - 1];
                if (weights[j] <= i)
                    res[i][j] = Math.max(res[i][j], res[i - weights[j]][j - 1] + weights[j]);
            }

        System.out.println(res[W][n]);
    }
}








