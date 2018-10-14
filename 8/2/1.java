import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = 1;

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; ++j)
                if (numbers[i] % numbers[j] == 0 && res[j] + 1 > res[i])
                    res[i] = res[j] + 1;

        int max = 0;
        for (int i = 0; i < res.length; i++)
            if (res[i] > max)
                max = res[i];
        System.out.println(max);
    }
}








