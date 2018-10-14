import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int res = binSearch(numbers, x);

            System.out.print(res == -1 ? -1 + " " : (res + 1) + " ");
        }
    }

    static int binSearch(int[] numbers, int x) {
        int l = -1, r = numbers.length;
        while(r - l > 1) {
            int mid = (l + r) / 2;
            if (numbers[mid] <= x)
                l = mid;
            else r = mid;
        }
        if (l == -1 || numbers[l] != x)
            return -1;
        return l;
    }
}




