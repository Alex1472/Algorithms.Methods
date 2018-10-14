import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Heap heap = new Heap();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("Insert"))
                heap.Add(sc.nextInt());
            if (command.equals("ExtractMax"))
                System.out.println(heap.ExtractMax());
        }
    }
}

class Heap {
    static final int MAX_SIZE = 100_010;
    int[] data;
    int heapSize;

    public Heap() {
        this.data = new int[MAX_SIZE];
        this.heapSize = 0;
    }

    void siftUp(int i) {
        while(i > 0 && data[(i - 1) / 2] < data[i]) {
            swap((i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    void siftDown(int i) {
        while (2 * i + 1 < heapSize) {
            int maxV = data[i];
            int maxI = i;

            if(data[2 * i + 1] > maxV) {
                maxI = 2 * i + 1;
                maxV = data[2 * i + 1];
            }

            if (2 * i + 2 < heapSize && data[2 * i + 2] > maxV) {
                maxI = 2 * i + 2;
                maxV = data[2 * i + 2];
            }

            if (maxV == data[i])
                break;
            swap(i, maxI);
            i = maxI;
        }
    }

    public void Add(int x) {
        data[this.heapSize] = x;
        siftUp(this.heapSize);
        ++heapSize;
    }

    public int ExtractMax() {
        int result = data[0];
        data[0] = data[--this.heapSize];
        siftDown(0);
        return result;
    }

    void swap(int i1, int i2) {
        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }
}


