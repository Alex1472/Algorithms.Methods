import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Point[] points = new Point[2 * n + m];
        int free = 0;

        for (int i = 0; i < n; i++) {
            points[free++] = new Point(sc.nextInt(),0, i);
            points[free++] = new Point(sc.nextInt(),2, i);
        }

        for (int i = 0; i < m; i++)
           points[free++] = new Point(sc.nextInt(), 1, i);

        Arrays.sort(points, new PointComparator());
        int curSegmentNumber = 0;
        int[] res = new int[m];

        for (int i = 0; i < points.length; i++) {
            if (points[i].prior == 0)
                ++curSegmentNumber;
            if (points[i].prior == 1)
                res[points[i].number] =curSegmentNumber;
            if (points[i].prior == 2)
                --curSegmentNumber;
        }
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}

class PointComparator implements Comparator<Point>  {
    @Override
    public int compare(Point o1, Point o2) {
        if (o1.coord < o2.coord)
            return -1;
        if (o1.coord > o2.coord)
            return 1;
        if (o1.prior < o2.prior)
            return -1;
        if (o1.prior > o2.prior)
            return 1;
        return 0;
    }
}

class Point {
    public int coord, number, prior;

    public Point(int coord, int prior, int number) {
        this.coord = coord;
        this.number = number;
        this.prior = prior;
    }
}






