import java.util.*;

public class DequeB {

    // stack using deque
    static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        public  boolean isEmpty(){
            return dq.size()==0;
        }
        // push
        public  void push(int data){
            dq.addLast(data);
        }

        // pop
        public  int pop(){
            return dq.removeLast();
        }

        //peek
        public  int peek(){
            return dq.getLast();
        }
    }

    // queue using deque...
    static class Queue{
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
            return dq.size() ==0;
        }

        // add
        public void add(int data){
            dq.addLast(data);
        }

        //remove
        public int remove(){
            return dq.removeFirst();
        }

        // peek
        public int peek(){
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        
while(!q.isEmpty()){
    System.out.println(q.remove());
}
        
        
    }
}
