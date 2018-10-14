import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        System.out.println(CalculateReversion(numbers, 0, numbers.length - 1));
    }

    public static long CalculateReversion(int[] numbers, int l, int r) {
        if (l == r)
            return 0;
        if (r - l == 1) {
            int res = numbers[l] > numbers[r] ? 1 : 0;
            if (res == 1) {
                int tmp = numbers[l];
                numbers[l] = numbers[r];
                numbers[r] = tmp;
            }
            return res;
        }

        int mid = (l + r) / 2;
        long res = 0;
        res += CalculateReversion(numbers, l,mid - 1);
        res += CalculateReversion(numbers, mid, r);

        int buf[] = new int[r - l + 1];
        int free = 0;
        int li = l, ri = mid;
        while(li < mid && ri < r + 1) {
            if (numbers[li] > numbers[ri]) {
                buf[free++] = numbers[ri++];
                res += mid - li;
            } else
                buf[free++] = numbers[li++];
        }

        while (li != mid)
            buf[free++] = numbers[li++];

        while (ri != r + 1)
            buf[free++] = numbers[ri++];

        for (int i = 0; i < buf.length; i++)
            numbers[l++] = buf[i];
        return res;
    }
}




