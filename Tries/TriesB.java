package Tries;

public class TriesB {
    
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node(); // root that always empty

    // insert
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curr.children[ind] == null) {
                curr.children[ind] = new Node();
            }
            curr = curr.children[ind];
        }
        curr.eow = true;
    }

    // search
    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curr.children[ind] == null) {
                return false;
            }
            curr = curr.children[ind];
        }

        return curr.eow;
    }

    // word break porblem...
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            boolean search = search(key.substring(0, i));
            boolean remain = wordBreak(key.substring(i));

            if (search && remain) {
                return true;
            }
        }

        return false;
    }

    

    // starts with problem.....
    // almost like search
    public static void findPrefix(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i) - 'a';

            if(curr.children[ind] == null){
                System.out.println(false);
                return;   //for stop the whole function
            }

            curr = curr.children[ind];
        }

        System.out.println(true);
    }

    
    // longest word with all prefixes..
    static String ans ="";
    public static void longestWord(Node root, StringBuilder temp){
        
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)('a' +i));

                // if(temp.length() >= wordLongest.length()){     //if we want laxicographically larger than- >=
                if(ans.length()< temp.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }

            
        }

        // return ; i dont know but it return without return
    }

    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for (String word : words) {
        // insert(word);
        // }

        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // for (int i = 0; i < arr.length; i++) {
        //     insert(arr[i]);
        // }

        String key = "ilikesam";
        // System.out.println(wordBreak(key));

        

        String arr3[] = {"apple", "app", "mango", "man", "woman"};
        for (String string : arr3) {
            insert(string);
        }
        // findPrefix("apph");

        String arr4[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (String string : arr4) {
            insert(string);
        }

        longestWord((root), new StringBuilder(""));

        System.out.println(ans);

    }
}