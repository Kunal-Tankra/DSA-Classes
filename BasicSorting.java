import java.util.*;


public class BasicSorting {

    public static void bubbleSort(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    count++;
                }

            }
            // break if array is already a sorted array
            if (count == 0) {
                break;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i <= arr.length - 1; i++) {
            int minpos = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minpos] > arr[j]) {
                    minpos = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minpos];
            arr[minpos] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            
            
            arr[prev +1] = curr;
        }
    }

    public static void countingSort(int arr[]) {
        // count frequency
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // making counter array with frequencys
        int count[] = new int[largest +1];
        for (int j = 0; j < arr.length; j++) {
            count[arr[j]]++;
        }

        int j = 0;
        for(int k=0; k<count.length; k++){
            while ( count[k] > 0) {
                arr[j] = k;
                j++;
                count[k]--;
            }
        }
    }

    // prectice questions... sort array in descending order...
    // a.
    public static void desBubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(arr[j+1]> arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // b.
    public static void desSelectionSort(int arr[]) {
        for (int i = 0; i < arr.length -1; i++) {
            int maxInd = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[maxInd] < arr[j]){
                    maxInd = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = temp;
        }
    }

    // c.
    public static void desInsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;

            while (prev >=0 && arr[prev] < curr) {
                arr[prev +1] = arr[prev];
                prev--;
            }

            arr[prev +1] = curr;
        }
    }

    // d.
    public static void desCountingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];
        for (int j = 0; j < arr.length; j++) {
            count[arr[j]]++;
        }

        int ind = arr.length -1;
        for (int k = 0; k < count.length; k++) {
            while (count[k] > 0) {
                arr[ind] = k;
                count[k]--;
                ind--;
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 3,6,2,1,8,7,4,5,3,1};

        // 0 to 2..
        // Arrays.sort(arr, 0 , 3); //1,4,5,3,2

        // Integer arr1[] = {5,4,1,3,2};
        // Arrays.sort(arr1,0,3, Collections.reverseOrder());

        desSelectionSort(arr);
        printArr(arr);

    }
}
