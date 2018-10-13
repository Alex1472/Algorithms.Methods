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
        int W = sc.nextInt();

        Subject[] subjects = new Subject[n];
        for (int i = 0; i < n ; i++)
            subjects[i] = new Subject(sc.nextInt(), sc.nextInt());
        Arrays.sort(subjects);

        double res = 0;
        int i = 0;
        while (W > 0 && i < subjects.length) {
            if (subjects[i].w <= W) {
                W -= subjects[i].w;
                res += subjects[i].c;
                ++i;
                continue;
            }
            res += subjects[i].c * ((double)W / subjects[i].w);
            W = 0;
        }
        System.out.println(res);

    }
}

class Subject implements Comparable {
    public int c;
    public int w;
    public double sortP;

    public Subject(int c, int w) {
        this.c = c;
        this.w = w;
        this.sortP = (double)c / w;
    }

    @Override
    public int compareTo(Object o) {
        Subject x = (Subject)o;

        if (this.sortP > x.sortP)
            return -1;
        if (this.sortP < x.sortP)
            return 1;
        return 0;
    }
}
