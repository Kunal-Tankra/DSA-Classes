
import java.util.*;

public class Stack2Queues {
    
    // pop - O(n)
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        // add
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        // pop
        public static int pop(){
            if(isEmpty()){
                System.out.println("stack empty");
                return -1;
            }

            int top = -1;

            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();

                    if(q1.isEmpty()){
                        break;
                    }

                    q2.add(top);
                }
            }
            else{
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    if(q2.isEmpty()){
                        break;
                    }

                    q1.add(top);
                }
            }

            return top;
        }
        
        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("stack empty");
                return -1;
            }

            int top = -1;

            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }
            else{
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }

    } 

    // push - O(n)
    static class Stack2{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        // push
        public static void push(int data) {
            if(q1.isEmpty()){
                q1.add(data);
                
                while(!q2.isEmpty()){

                    q1.add(q2.remove());
                }
            }
            else{
                q2.add(data);
    
                while(!q1.isEmpty()){
    
                    q2.add(q1.remove());
                }
            }
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }

            int top;

            if(!q1.isEmpty()){
                top = q1.remove();
            }
            else{
                top = q2.remove();
            }

            return top;
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }

            int top;

            if(!q1.isEmpty()){
                top = q1.peek();
            }
            else{
                top = q2.peek();
            }

            return top;
        }

    }
    public static void main(String[] args) {
        Stack2 s = new Stack2();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
