import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Fib {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (n == 2) {
            System.out.println(1);
            return;
        }

        long[][] res = power(new long[][] {{0, 1}, {1, 1}}, n - 2, m);
        System.out.println((res[1][1] + res[1][0]) % m);
    }

    public static long[][] power(long[][] x, long n, int m) {
        if (n == 0)
            return new long[][] {{1, 0}, {0, 1}};
        if (n % 2 == 0) {
            long[][] res = power(x, n / 2, m);
            return multiply(res, res, m);
        }

        long[][] res = power(x, n - 1, m);
        return multiply(res, x, m);
    }

    public static long[][] multiply(long[][] a, long[][] b, int m) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % m;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % m;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % m;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % m;
        return res;
    }
}
