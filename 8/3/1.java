import java.io.PrintWriter;
import java.util.*;

public class Fib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        int[][] res = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++)
            res[i][0] = i;
        for (int i = 0; i < b.length() + 1; i++)
            res[0][i] = i;

        for(int i = 1; i < a.length() + 1; ++i)
            for(int j = 1; j < b.length() + 1; ++j) {
                int min = res[i][j - 1] + 1;
                min = Math.min(min, res[i - 1][j] + 1);
                min = Math.min(min, a.charAt(i - 1) == b.charAt(j - 1) ? res[i - 1][j - 1] :
                        res[i - 1][j - 1] + 1);
                res[i][j] = min;
            }
        System.out.println(res[a.length()][b.length()]);
    }
}








