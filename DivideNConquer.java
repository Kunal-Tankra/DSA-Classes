public class DivideNConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // merge sort
    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // kaam
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // counter ind for 1st (left) sorted arr
        int j = mid + 1; // counter ind for 2nd (right) sorted arr
        int k = 0; // counter ind for temp

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++]; // kaam hone k baad + honge
        }

        while (j <= ei) {
            temp[k++] = arr[j++]; // kaam hone k baad + honge
        }

        // copy in arr from temp
        for (int k2 = 0, i2 = si; k2 < temp.length; k2++, i2++) {
            arr[i2] = temp[k2];
        }

    }

    // quick sort
    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int pInd = partition(arr, si, ei);
        quickSort(arr, si, pInd - 1); // left
        quickSort(arr, pInd + 1, ei); // right
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j <= ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        return i;

    }

    // search in Roteted sorted Array
    public static int search(int arr[], int si, int ei, int tar) {
        // base
        if (si > ei) {
            return -1;
        }

        // kaam
        int mid = si + (ei - si) / 2;

        // case found
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on line 1st
        if (arr[si] <= arr[mid]) {
            // case a: left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, si, mid - 1, tar);
            }
            // case b: right
            else {
                return search(arr, mid + 1, ei, tar);
            }

        }
        // mid on line 2
        else {
            // case c: right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, mid + 1, ei, tar);
            }
            // case d: left
            else {
                return search(arr, si, mid - 1, tar);
            }
        }
    }

    // practice quietions...
    // 1.. (easy)
    public static void mergeSortString(String arr[], int si, int ei) {
        // base
        if (si >= ei) {
            return;
        }

        // work
        int mid = si + (ei - si) / 2;
        mergeSortString(arr, si, mid); // left
        mergeSortString(arr, mid + 1, ei); // right

        mergeStrArr(arr, si, mid, ei);

    }

    public static void mergeStrArr(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        // trackers
        int i = si; // track first arr
        int j = mid + 1; // track second arr
        int k = 0; // track temp

        while (i <= mid && j <= ei) {
            int compare = arr[i].compareTo(arr[j]);
            if (compare < 0) {
                temp[k] = arr[i++];
                // i++;

            } else {
                temp[k] = arr[j++];
                // j++;
            }
            k++;

        }

        // remaining strings in sorted array 1st
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // remaining strings in sorted array 2nd
        while (j <= ei) {
            temp[k++] = arr[j++];

        }

        // copying in arr
        for (int k2 = 0, i2 = si; k2 < temp.length; k2++, i2++) {
            arr[i2] = temp[k2];
        }

    }

    // 2.. major element
    public static int majorElem(int arr[], int si, int ei) {
        // base
        if (si == ei) {
            return arr[si];
        }

        // kaam
        int mid = si + (ei - si) / 2;
        int left = majorElem(arr, si, mid);
        int right = majorElem(arr, mid + 1, ei);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(arr, left, si, ei);
        int rightCount = countInRange(arr, right, si, ei);

        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int arr[], int val, int si, int ei) {
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (val == arr[i]) {
                count++;
            }
        }
        return count;

    }

    // 3.. modified mergesort
    public static int mergeSortInv(int arr[], int si, int ei) {
        int invCount = 0;
        if (si < ei) {
            int mid = si + (ei - si) / 2;
            invCount += mergeSortInv(arr, si, mid); // left faith k le aaenge
            invCount += mergeSortInv(arr, mid + 1, ei); // right

            invCount += mergeInv(arr, si, mid, ei);   //left and right k liye
        }

        return invCount;

    }

    public static int mergeInv(int arr[], int si, int mid, int ei) {
        int invCount = 0;

        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                invCount += mid + 1 - i;
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];

        }

        while (j <= ei) {
            temp[k++] = arr[j++];

        }

        // copy to arr
        for (int k2 = 0, i2= si; k2 < temp.length; k2++, i2++) {
            arr[i2] = temp[k2];
        }

        return invCount;

    }

    public static void main(String[] args) {
        int arr[] = { 2,4,1,3,5};
        // mergeSortString(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length - 1);
        System.out.println(mergeSortInv(arr, 0, arr.length-1));
        // printArr(arr);

    }
}