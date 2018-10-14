import java.util.*;

public class Fib {
    static final int alfSize = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lettersCount = sc.nextInt();
        sc.nextInt();
        sc.nextLine();

        Node root = new Node(-1, null, null);
        for (int i = 0; i < lettersCount; i++) {
            String buf = sc.nextLine();
            AddLetter(root, buf.charAt(0) - 'a', buf.substring(3));
        }
        String word = sc.nextLine();
        System.out.println(Decode(word, root));


    }

    public static String Decode(String s, Node codeTreeRoot) {
        StringBuilder sb = new StringBuilder();
        Node currentNode = codeTreeRoot;
        for (int i = 0; i < s.length(); i++) {
            currentNode = s.charAt(i) == '0' ? currentNode.l : currentNode.r;
            if (currentNode.l == null) {
                sb.append((char)('a' + currentNode.letter));
                currentNode = codeTreeRoot;
            }
        }
        return sb.toString();
    }

    public static void AddLetter(Node root, int letter, String code) {
        Node currentNode = root;
        for (int i = 0; i < code.length() - 1; i++) {
            if (code.charAt(i) == '0') {
                if (currentNode.l == null)
                    currentNode.l = new Node(-1, null, null);
                currentNode = currentNode.l;
            }
            if (code.charAt(i) == '1') {
                if (currentNode.r == null)
                    currentNode.r = new Node(-1, null, null);
                currentNode = currentNode.r;
            }
        }
        if (code.charAt(code.length() - 1) == '0')
            currentNode.l = new Node(letter, null, null);
        else
            currentNode.r = new Node(letter, null, null);
    }
}

class Node {
    public int letter;
    public Node l, r;

    public Node(int letter, Node l, Node r) {
        this.letter = letter;
        this.l = l;
        this.r = r;
    }
}

