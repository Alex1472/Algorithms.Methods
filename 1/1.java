import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Fib {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int a = (int)in.nval;
        in.nextToken();
        int b = (int)in.nval;
        System.out.println(a + b);
    }
}
