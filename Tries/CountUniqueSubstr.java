package Tries;

public class CountUniqueSubstr {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false; //end of word

        Node(){
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(curr.children[ind] == null){
                curr.children[ind] = new Node();
            }

            curr = curr.children[ind];
        }
        curr.eow = true;
    }

    
    
    // count unique substrings...
    public static void countUniqueSubstring(String word){
        // find and instert all suffix to trie
        suffix(word);

        int c =countNodes(root);
        System.out.println(c);

    }

    public static int countNodes(Node root){

        int count = 0;
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null){
               count += countNodes(root.children[i]);
            }
        }

        

        return count+1;
    }

    public static void suffix(String word){
        for (int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }
    }

    public static void main(String[] args) {
        // countUniqueSubstring("ababa");
        countUniqueSubstring("apple");

    }
}
