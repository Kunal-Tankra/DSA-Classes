import java.util.*;;

public class QueuePracticeQ {

    // 1... Generate Binary Numbers...
    public static void generateBinaryNum(int n){
        Queue<String> q = new LinkedList<>();
        if(n == 0){
            return;
        }

        q.add("1");
        for (int i = 0; i < n; i++) {
            System.out.println(q.peek());
            q.add(q.peek() + "0");
            q.add(q.peek() + "1");

            q.remove();
        }

    }
    public static void main(String[] args) {
        generateBinaryNum(5);
    }
}
