import java.util.*;

public class Fib {
    static final int alfSize = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] lettersFerquency = CalculateLetterFrequency(s);
        Node root = GenerateCodeTree(lettersFerquency);
        String[] result = GenerateCode(root);

        int lettersCount = 0, codeSize = 0;
        for(int i = 0; i < lettersFerquency.length; ++i) {
            if (lettersFerquency[i] != 0) {
                ++lettersCount;
                codeSize += lettersFerquency[i] * result[i].length();
            }
        }

        if (lettersCount == 1) {
            System.out.println(1 + " " + s.length());
            System.out.println(s.charAt(0) + ": " + 0);
            for (int i = 0; i < s.length(); i++)
                System.out.print(0);
            return;
        }
        System.out.println(lettersCount + " " + codeSize);

        for (int i = 0; i < result.length; i++)
            if(result[i] != null)
                System.out.println((char)('a' + i) + ": " + result[i]);

        for (int i = 0; i < s.length(); i++)
            System.out.print(result[s.charAt(i)- 'a']);
    }

    static int[] CalculateLetterFrequency(String s) {
        int[] result = new int[alfSize];
        for (int i = 0; i < s.length(); ++i)
            ++result[s.charAt(i) - 'a'];
        return result;
    }

    static Node GenerateCodeTree(int[] lettersFrequency) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < lettersFrequency.length; i++)
            if (lettersFrequency[i] != 0)
                queue.add(new Node(i, lettersFrequency[i], null, null));

        while(queue.size() > 1) {
            Node a = queue.poll();
            Node b = queue.poll();
            queue.add(new Node(-1, a.frequency + b.frequency, a, b));
        }

        return queue.poll();
    }

    static String[] GenerateCode(Node root) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[alfSize];
        GenerateCodeCore(root, sb, result);
        return result;
    }

    static void GenerateCodeCore(Node root, StringBuilder currentCode, String[] result) {
        if(root.l == null) {
            result[root.letter] = currentCode.toString();
            return;
        }
        currentCode.append("0");
        GenerateCodeCore(root.l, currentCode, result);
        currentCode.deleteCharAt(currentCode.length() - 1);
        currentCode.append("1");
        GenerateCodeCore(root.r, currentCode, result);
        currentCode.deleteCharAt(currentCode.length() - 1);
    }
}

class Node implements Comparable {
    public int letter, frequency;
    public Node l, r;

    public Node(int letter, int freguency, Node l, Node r) {
        this.letter = letter;
        this.frequency = freguency;
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Object o) {
        Node x = (Node)o;
        if (this.frequency < x.frequency)
            return -1;
        if (this.frequency > x.frequency)
            return 1;
        return 0;
    }
}
