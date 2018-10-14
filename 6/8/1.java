import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();
        Sort(numbers);
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");

    }

    public static void Sort(int[] numbers) {
        int[] buf = new int[10];
        for (int i = 0; i < numbers.length; i++)
            ++buf[numbers[i]];

        int free = 0;
        for(int i = 1; i <= 9; ++i)
            while(buf[i] != 0) {
                numbers[free++] = i;
                --buf[i];

            }
    }
}








