package Tries;

import java.util.*;

public class PracticeQ {
    // 1. group anagrams together...
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word
        ArrayList<String> data = new ArrayList<>(); // stores the same words on that node

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    static ArrayList<ArrayList<String>> ans = new ArrayList<>();

    public static void groupAnagrams(String words[]) {
        for (String word : words) {
            insert(word);
        }

        // now go to eow nodes and get data.. and add it to ans.
        getDatas(root);
    }

    public static void getDatas(Node root) {
        if (root.eow == true) {
            ans.add(root.data);
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {

                getDatas(root.children[i]);
            }
        }
    }

    public static void insert(String word) {
        // sort word
        char wordArr[] = word.toCharArray();
        Arrays.sort(wordArr);

        Node curr = root;
        for (int i = 0; i < wordArr.length; i++) {
            int ind = wordArr[i] - 'a';

            if (curr.children[ind] == null) {
                curr.children[ind] = new Node();
            }
            curr = curr.children[ind];
        }
        curr.eow = true;

        curr.data.add(word);

    }
    

    // 2. Longest word in Dictionary...
    static class Node2 {
        Node2 children[] = new Node2[26];
        boolean eow = false; // end of word

        Node2() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node2 root2 = new Node2(); // root2 that always empty

    // insert
    public static void insert2(String word) {
        Node2 curr = root2;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curr.children[ind] == null) {
                curr.children[ind] = new Node2();
            }
            curr = curr.children[ind];
        }
        curr.eow = true;
    }
    public static void longestWord(String words[]) {
        for (String word : words) {
            insert2(word);
        }

        getWord(root2, new StringBuilder(""));
    }

    
    static String wordLongest = "";   //that is the ans
    public static void getWord(Node2 root2,StringBuilder temp  ) {
        
        for (int i = 0; i < root2.children.length; i++) {
            
            if (root2.children[i] != null && root2.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                // if(temp.length() >= wordLongest.length()){     //if we want laxicographically larger than- >=
                if(temp.length() > wordLongest.length()){     
                    wordLongest = temp.toString();
                }

                getWord(root2.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        // 1.
        String words[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // groupAnagrams(words);
        // System.out.println(ans);

        // 2.
        String words2[] = {"a", "banana", "app", "appl", "ap", "apply", "apple", "applz"};
        longestWord(words2);
        System.out.println(wordLongest);
    }
}
