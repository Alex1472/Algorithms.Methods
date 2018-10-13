import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fib {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; ++i)
            segments[i] = new Segment(sc.nextInt(), sc.nextInt());
        Arrays.sort(segments);
        List<Integer> result = new ArrayList<Integer>();

        result.add(segments[0].r);
        int lastP = segments[0].r;
        for (int i = 1; i < n; ++i)
            if (segments[i].l > lastP) {
                result.add(segments[i].r);
                lastP = segments[i].r;
            }

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");

    }
}

class Segment implements Comparable {
    int l;
    int r;

    public Segment(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Object o) {
        Segment x = (Segment) o;
        if (this.r < x.r)
            return -1;
        if (this.r > x.r)
            return 1;
        return 0;
    }
}