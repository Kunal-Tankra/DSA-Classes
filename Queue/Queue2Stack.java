import java.util.*;

// ---------------queue using 2 stack----------

public class Queue2Stack {

    // add = O(n)
     static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        // add - O(n)
        public static void add(int data){
            if(s1.isEmpty()){
                s1.push(data);
                return;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();
        }
        
        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return s1.peek();
        }
    
    }

    // remove - O(n)
    static class Queue2{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        // add
        public static void add(int data){
            s1.push(data);
        }

        // remove - O(n)
        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int first = s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return first;

        }
        
        // peek
        public static int peek(){
            if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int first = s2.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return first;

        }
        
    }
    public static void main(String[] args) {
        Queue2 q = new Queue2();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

    }
}
