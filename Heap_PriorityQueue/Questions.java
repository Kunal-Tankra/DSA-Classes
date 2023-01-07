package Heap_PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ForkJoinWorkerThread;

public class Questions {
    // Nearby cars...
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int ind;

        Point(int x, int y, int distSq, int ind) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.ind = ind;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void nearbyCars(int pts[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];

            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().ind);
        }
    }

    // conntct n ropes...
    public static void conntctNRopes(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int elem : arr) {
            pq.add(elem);
        }

        int minCost = 0;

        while (pq.size() > 1) {
            int first = pq.remove();
            int sec = pq.remove();

            int currCost = first + sec;

            minCost += currCost;

            pq.add(currCost);
        }

        System.out.println(minCost);
    }

    // weakest soldier....
    static class Soldier implements Comparable<Soldier> {
        int soldierSum;
        int ind;

        Soldier(int soldierSum, int ind) {
            this.soldierSum = soldierSum;
            this.ind = ind;
        }

        @Override
        public int compareTo(Soldier s2) {
            if (this.soldierSum == s2.soldierSum) {
                return this.ind - s2.ind;
            } else {
                return this.soldierSum - s2.soldierSum;
            }
        }
    }

    public static void weakestSoldier(int arr[][], int k) {
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int countSol = 0;
            for (int j = 0; j < arr[0].length; j++) {
                countSol += arr[i][j] == 1 ? 1 : 0;
            }

            pq.add(new Soldier(countSol, i));
        }

        for (int i = 0; i < k; i++) {

            System.out.println("R" + pq.remove().ind);
        }

    }

    // sliding window...
    static class Pair implements Comparable<Pair> {
        int val;
        int ind;

        Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }

        @Override
        public int compareTo(Pair p2) {
            // descnding
            return p2.val - this.val;
        }
    }

    public static void maxInWindow(int arr[], int k) { // O(nlogk)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[arr.length - k + 1];

        // initialy
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            pq.add(new Pair(arr[i], i));

            // remove from pq if it now includes in window
            while (pq.size() > 0 && pq.peek().ind <= (i - k)) {
                pq.remove();
            }

            res[i - k + 1] = pq.peek().val;
        }

        for (int elem : res) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // practice questions.......
    // 1. kth largest elem in a stream....

    // approach 1-
    public static void kthLargestElem(int stream[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        LinkedList<Integer> temp = new LinkedList<>();

        for (int elem : stream) {
            pq.add(elem);

            if (pq.size() >= k) {
                for (int i = 1; i < k; i++) {
                    temp.add(pq.remove());
                }

                System.out.print(pq.peek() + " ");

                for (int i = temp.size() - 1; i >= 0; i--) {

                    pq.add(temp.remove(i));
                }
            }

        }
    }

    // approach2 -  O(log k)
    public static void kthLargestElem2(int stream[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for first k elem
        for (int i = 0; i < k; i++) {
            int curr = stream[i];
            pq.add(curr);

            if (pq.size() >= k) {
                System.out.print(pq.peek() + " ");
            }
        }

        // after
        for (int i = k; i < stream.length; i++) {

            int curr = stream[i];

            if (curr < pq.peek()) {
                System.out.print(pq.peek() + " ");
            } else {
                pq.remove();
                pq.add(curr);
                System.out.print(pq.peek() + " ");
            }

        }
    }

    // 2. min time required to fill given n slots....
    public static void minTimeToFill(int arr[], int n, int k){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n +1];

        int time = 0;

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
            
            visited[arr[i]] = true;
        }

        while(q.size()>0){
            int size = q.size();
            for (int i = 0; i <  size; i++) {
                int curr = q.remove();

                // left
                if((curr-1) >=1 && !visited[curr-1]){
                    q.add(curr-1);
                    visited[curr-1] = true;
                }

                // rigth
                if((curr +1 ) <= n && !visited[curr+1]){
                    q.add(curr+1);
                    visited[curr+1]  = true;
                }
            }
            time++;
        }

        System.out.println(time -1);
    }

    // 4. minimum operations to halve array sum....  O(nlogn)
    public static void minimumOper(float arr[]){
        
        float initialSum = 0;
        for (float elem : arr) {
            initialSum+= elem;
        }
        
        PriorityQueue<Float> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        // add ini pq
        for (Float elem : arr) {
            pq.add(elem);
        }
        
        int totalOper = 0;

        float afterSum = initialSum;

        initialSum = initialSum/2;  //16.5
        
        while(afterSum > initialSum){

            float currBig = pq.remove()/2;

            pq.add(currBig);
            afterSum -= currBig;
            totalOper++;


        }

        System.out.println(totalOper);
        
    }

    // 5. merge k sorted Linked List....
    public static void mergeKSortedLL(LinkedList<Integer> l1,LinkedList<Integer> l2,LinkedList<Integer> l3, int k, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!l1.isEmpty()){
            pq.add(l1.remove());
        }
        while(!l2.isEmpty()){
            pq.add(l2.remove());
        }
        while(!l3.isEmpty()){
            pq.add(l3.remove());
        }

       while(pq.size() >0){
        l1.add(pq.remove());
       }

       System.out.println(l1);
    }


    public static void main(String[] args) {
        // int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        // nearbyCars(pts, 2);

        // int arr[] = {2,3,3,4,6};
        // conntctNRopes(arr);

        // int soldier[][] = {{1,0,0,0},
        // {1,1,1,1},
        // {1,0,0,0},
        // {1,0,0,0}};
        // weakestSoldier(soldier, 2);

        // int val[] = {1,3,-1,-3,5,3,6,7};
        // maxInWindow(val, 3);

        // 1.
        // int stream[] = { 10,20,11,70,50,40,100,5 };
        // kthLargestElem2(stream, 3);

        // 2
        // int arr[] = {2,6};
        // minTimeToFill(arr, 6, 2);

        // 4.
        // float arr[] = {3,8,20};
        // minimumOper(arr);

        // 5.
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(3);
        l1.add(7);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(4);
        l2.add(8);

        LinkedList<Integer> l3 = new LinkedList<>();
        l3.add(9);
        l3.add(10);
        l3.add(11);

        int k = 3;
        int n = 3;
        mergeKSortedLL(l1,l2,l3,k,n);

        

    }
}
