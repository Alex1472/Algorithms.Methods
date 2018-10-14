import java.io.PrintWriter;
import java.util.*;

public class Fib {
    static final long inf = 1000000010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        long[] lastNumber = new long[n + 3];
        lastNumber[0] = inf;
        int[] lastIndexOfSequence = new int[n + 3];
        int[] prevI = new int[n + 3];
        for (int i = 0; i < prevI.length; i++) {
            prevI[i] = -1;
            lastIndexOfSequence[i] = -1;
        }

        for (int i = 1; i < lastNumber.length; i++)
            lastNumber[i] = -1;

        for (int i = 0; i < numbers.length; i++) {
            int resI = binSearch(lastNumber, numbers[i]);
            lastNumber[resI] = numbers[i];
            lastIndexOfSequence[resI] = i;
            prevI[i] = lastIndexOfSequence[resI - 1];
        }

        int i = 0;
        while(lastNumber[i] != -1)
            ++i;
        --i;
        System.out.println(i);
        printSequence(prevI, lastIndexOfSequence[i]);
    }

    public static void printSequence(int[] prev, int curI) {
        if (curI == -1)
            return;
        printSequence(prev, prev[curI]);
        System.out.print(curI + 1 + " ");
    }

    public static int binSearch(long[] numbers, long x) {
        int l = 0, r = numbers.length - 1;
        while(r - l > 1) {
            int mid = (l + r) / 2;
            if (numbers[mid] >= x)
                l = mid;
            else r = mid;
        }
        return r;
    }
}








