
import java.text.Format;
import java.util.random.RandomGenerator;

public class QueueArray {

    static class Queue{
        static int arr[];
        static int size;
        static int rare;
        static int front;

        Queue(int n){
            arr = new int[n];
            size = n;
            rare = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rare == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rare+1)%size == front;
        }

        // add
        public static void add(int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }

            // add first elem
            if(front ==-1){
                front = 0;
            }
            rare = (rare+1)%size;
            arr[rare] = data;
        }

        // remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            int result =arr[front];

            
            
            // last elem delete  - bcha hua only one elem
            if(front == rare){
                front = rare = -1;
            }
            else{
                front = (front +1)%size;

            }

            return result;
           
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }

            return arr[front];
        }


    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
