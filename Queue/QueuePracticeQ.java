import java.util.*;

import javax.print.attribute.IntegerSyntax;

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

    // 3... job sequencing .........smj ni aaya... O(n logn)
    static class Job {
        char jobId;
        int deadline;
        int profit;

        public Job(char jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobSequencing(ArrayList<Job> arr) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });
        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });
        for (int i = n - 1; i > -1; i--) {
            int slot_available;
            if (i == 0) {
                slot_available = arr.get(i).deadline;
            } else {
                slot_available = arr.get(i).deadline - arr.get(i - 1).deadline;
            }
            maxHeap.add(arr.get(i));
            while (slot_available > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.remove();
                slot_available--;
                result.add(job);
            }
        }
        Collections.sort(result, (a, b) -> {
            return a.deadline - b.deadline;
        });
        for (Job job : result) {
            System.out.print(job.jobId + " ");
        }
        System.out.println();
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

            while (!dq.isEmpty() && curr >= arr[dq.getLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        System.out.print(arr[dq.peek()] + " ");

        // after first window
        for (int i = k; i < arr.length; i++) {
            int curr = arr[i];

            // check first elem is comes in window if not then remove it
            while (!dq.isEmpty() && dq.peek() <= i - k) {
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
        ArrayList<Job> arr = new ArrayList<>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        jobSequencing(arr);

        // int arr2[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        // maxOfAllSubarrs(arr2, 9, 3);

    }
}
