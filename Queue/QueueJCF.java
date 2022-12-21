
import java.util.*;

public class QueueJCF {

    // first non-repeating letter....
    public static void firstNonREpeat(String str) {
        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] >= 2) {
                q.remove();
            }
        }

        if (q.isEmpty()) {
            System.out.println("there is no non-repeating letter");
            return;
        }

        System.out.println(q.peek());
    }

    // interleave 2 halves of a queue.....
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();

        int size = q.size();

        for (int i = 1; i <= size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

        System.out.println(q);

    }

    // queue Reversal....
    public static void queueREversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            
            q.add(s.pop());
        }

        System.out.println(q);
    }



    public static void main(String[] args) {
        // we are making queue with the use of ll and arrayDeque

        Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();

        // String str = "accbbsa";
        // firstNonREpeat(str);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        queueREversal(q);
    }
}
