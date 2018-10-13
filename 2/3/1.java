import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(NOD(Math.max(a, b), Math.min(a, b)));
    }

    public static int NOD(int max, int min) {
        if (max % min == 0)
            return min;
        return NOD(min, max % min);
    }
}
