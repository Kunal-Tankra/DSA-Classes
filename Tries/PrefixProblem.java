package Tries;

public class PrefixProblem {
    // prefix problem.....pp..
    static class NodePP {
        NodePP children[] = new NodePP[26];
        boolean eow = false;
        int frq = 1;

        public NodePP() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static NodePP rootPP = new NodePP();

    public static void insertPP(String word) {
        rootPP.frq = -1;

        NodePP curr = rootPP;

        for (int i = 0; i < word.length(); i++) {

            int ind = word.charAt(i) - 'a';

            if (curr.children[ind] == null) {
                curr.children[ind] = new NodePP();
            } else {
                curr.children[ind].frq++;
            }

            curr = curr.children[ind];
        }

        curr.eow = true;
    }

    public static void getPrefix(NodePP rootPP, String ans) {
        // if (rootPP == null) {
        //     return;
        // }

        if (rootPP.frq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < rootPP.children.length; i++) {
            if (rootPP.children[i] != null) {

                
                getPrefix(rootPP.children[i], ans + (char) (i + 'a'));
            }
        }

    }

    public static void main(String[] args) {
        String arr2[] = { "zebra", "dog", "duck", "dove", "e" };
        for (String string : arr2) {
            insertPP(string);
        }
        // getPrefix(rootPP, "");
    }
}
