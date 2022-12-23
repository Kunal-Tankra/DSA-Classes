import java.util.*;
import java.lang.Comparable;

public class QueuePracticeQ {

    // 1... Generate Binary Numbers...
    public static void generateBinaryNum(int n) {
        Queue<String> q = new LinkedList<>();
        if (n == 0) {
            return;
        }

        q.add("1");
        for (int i = 1; i <= n; i++) {
            System.out.println(q.peek());
            // next twos
            q.add(q.peek() + "0");
            q.add(q.peek() + "1");

            q.remove();
        }

    }

    // 2.. connect n ropes with minimum cost...
    public static void connectMinCost(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int totalCost = 0;
        int size = pq.size();
        for (int i = 0; i < size - 1; i++) {
            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;

            totalCost += cost;
            pq.add(cost);
        }

        System.out.println(totalCost);
    }

    // 3... job sequencing ... incomplete
    static class job {
        char jobId;
        int deadline;
        int profit;

        public job(char jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // 4.. reversing the first k elements of a queue...
    public static void reversFirstK(Queue<Integer> q, int k) {
        Deque<Integer> dq = new LinkedList<>();

        // adding first k elem to dq
        for (int i = 0; i < k; i++) {
            dq.addFirst(q.remove());
        }

        // adding dq elems (reversed) after q elems in q
        for (int i = 0; i < k; i++) {
            q.add(dq.removeFirst());
        }

        // [60, 70, 80, 90, 100, 50, 40, 30, 20, 10]
        // adding first size-k elems to q

        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }

        System.out.println(q);
    }

    // 5... maximum of all subarrays...
    public static void maxOfAllSubarrs(int arr[], int n, int k) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addLast(0);
        // in first window find sbse bda
        for (int i = 1; i < k; i++) {
            int curr = arr[i];

            while(!dq.isEmpty() && curr >= arr[dq.getLast()]){
                dq.removeLast();
            }

            dq.addLast(i);
        }

        System.out.print(arr[dq.peek()] + " ");

        // after first window
        for (int i = k; i < arr.length; i++) {
            int curr = arr[i];

            // check first elem is comes in window if not then remove it
            while (!dq.isEmpty() && dq.peek() <= i-k) {
                dq.removeFirst();
            }

            // check and add the elems
            while (!dq.isEmpty() && curr >= arr[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);

            System.out.print(arr[dq.peek()] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<job> arr = new ArrayList<>();

        arr.add(new job('a', 4, 20));
        arr.add(new job('b', 1, 10));
        arr.add(new job('c', 1, 40));
        arr.add(new job('d', 1, 30));

        Collections.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });

        int arr2[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        maxOfAllSubarrs(arr2, 9, 3);

    }
}
