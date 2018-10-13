import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Fib {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int)in.nval;
        if (n <= 2) {
            System.out.println(1);
            return;
        }
        int f = 1, s = 1;
        for (int i = 2; i < n; i++) {
            int res = (f + s) % 10;
            f = s;
            s = res;
        }
        System.out.println(s);

    }
}
