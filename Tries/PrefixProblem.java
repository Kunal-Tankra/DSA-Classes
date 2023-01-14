package Tries;

public class PrefixProblem {
    // prefix problem.......
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int frq = 1;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        root.frq = -1;

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int ind = word.charAt(i) - 'a';

            if (curr.children[ind] == null) {
                curr.children[ind] = new Node();
            } else {
                curr.children[ind].frq++;
            }

            curr = curr.children[ind];
        }

        curr.eow = true;
    }

    public static void getPrefix(Node root, String ans) {
        // if (root == null) {
        //     return;
        // }

        if (root.frq == 1) {
            System.out.print(ans+ ", ");
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {

                
                getPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }

    }

    public static void main(String[] args) {
        String arr2[] = { "zebra", "dog", "duck", "dove", "e" };
        for (String string : arr2) {
            insert(string);
        }
        getPrefix(root, "");
    }
}
