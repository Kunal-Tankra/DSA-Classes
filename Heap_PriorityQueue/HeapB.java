package Heap_PriorityQueue;

import java.nio.channels.Pipe;
import java.util.*;

public class HeapB {
    // implement heap
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last ind
            arr.add(data);

            int x = arr.size() -1;  // x = child ind 
            int PI = (x-1)/2;    // PI = parent ind

            // swap if parent is greater than child
            while(arr.get(x) < arr.get(PI)){  //O(log n)
                int temp = arr.get(x);
                arr.set(x, arr.get(PI));
                arr.set(PI, temp);

                x = PI;
                // PI = (x-1)/2; 
            }

        }

        
        // peek
        public int peek(){
            return arr.get(0);
        }
        
        public int remove(){
            int data = arr.get(0);

            // step 1 - swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2 - remove
            arr.remove(arr.size()-1);

            // step 3 - heapify
            heapify(0);

            return data;
        }

        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2 * i +2;
            int minInd = i;

            if(left < arr.size() && arr.get(minInd) > arr.get(left)){
                minInd = left;
            }

            if(right < arr.size() && arr.get(minInd) > arr.get(right)){
                minInd = right;
            }

            if(minInd != i){
                int temp = arr.get(minInd);
                arr.set(minInd, arr.get(i));
                arr.set(i, temp);

                heapify(minInd);
            }
        }

        // is empty..?
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }


    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
        
    }
}
