package Heap_PriorityQueue;


public class HeapSortB {

    public static void heapSort(int arr[]){  //O(n*logn)
        int n = arr.length;

        // step 1
        for (int i = n/2; i >=0; i--) {  //O(n/2)
            heapify(arr, i, n);  //max heap create       ---> O(logn)
        }

        // step 2
        for (int i = n-1; i >0; i--) {    //O(n)

            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0 , i);       // O(logn)
        }
    }

    public static void heapify(int arr[], int i, int size){
        int left = 2 * i +1;
        int right = 2 * i +2;

        int maxInd = i;

        if(left < size && arr[maxInd] > arr[left]){
            maxInd = left;
        }

        if(right < size && arr[maxInd] > arr[right]){
            maxInd =right; 
        }

        if(maxInd != i){
            int temp = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = temp;

            heapify(arr, maxInd, size);
        }
    }

    public static void main(String[] args) {
        int arr[]= {1,2,4,5,3};
        heapSort(arr);

        // print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
