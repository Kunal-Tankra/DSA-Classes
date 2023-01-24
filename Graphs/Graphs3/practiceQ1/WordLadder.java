package Graphs.Graphs3.practiceQ1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.DocFlavor.STRING;

public class WordLadder {
    // word ladder.....
    static int chain = 1;
    public static int wordLadder(String arr[], String start, String target){
        if(start == target){
            return 0;
        }

        HashSet<String> set = new HashSet<>();
        for (String string : arr) {
            set.add(string.toUpperCase());   //now we can search either small and capitals
        }

        start = start.toUpperCase();
        target = target.toUpperCase();

        Queue<String> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
         
            String curr = q.remove();
            char word[] = curr.toCharArray();

            for (int i = 0; i < word.length; i++) {
                char original = word[i];

                for (char j = 'A'; j <= 'Z'; j++) {
                    word[i] = j;

                    if(String.valueOf(word).equals(target) && set.contains(String.valueOf(word))){
                        return chain+1;
                    }

                    if(set.contains(String.valueOf(word))){
                        chain++;
                        q.add(String.valueOf(word));
                        set.remove(String.valueOf(word));
                    }
                }

                word[i] = original;


            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        
        String arr[] = {"pOON", "PLEE", "SAME", "POIE","PLEA", "PLIE", "poin"};
        String start = "TOON";
        String target = "Plee";
        
       

        System.out.println(wordLadder(arr, start, target));
    }
}
