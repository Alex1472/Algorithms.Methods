import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        List<Long> res = new ArrayList<>();

        for(long i = 1; i <= n; ++i) {
            if (n - i > i) {
                res.add(i);
                n -= i;
                continue;
            }
            if (n == i) {
                res.add(i);
                n -= i;
                continue;
            }

            if (n - i <= i)
                break;
        }

        if (n > 0)
            res.add(n);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");

    }
}
