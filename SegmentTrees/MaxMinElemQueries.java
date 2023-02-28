package SegmentTrees;

public class MaxMinElemQueries {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    // build (only for max)
    public static void build(int arr[]) {
        int n = arr.length;
        buildUtil(arr, 0, 0, n - 1);
    }

    public static void buildUtil(int arr[], int i, int st, int end) { //O(n)
        if (st == end) {
            tree[i] = arr[st];
            return;
        }

        int mid = (st + end) / 2;
        buildUtil(arr, 2 * i + 1, st, mid);
        buildUtil(arr, 2 * i + 2, mid + 1, end);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Query (for max)
    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getmaxUtil(0, 0, n-1, qi, qj);
    }

    public static int getmaxUtil( int i, int si, int sj, int qi, int qj){ //O(logn)
        // case 1: not overlap
        if(si>qj || sj<qi){
            return Integer.MIN_VALUE;
        }
        else if(qi<=si && qj>=sj){   //case 2: overlaping
            return tree[i];
        } 
        else{   //partial overlap
            int mid = (si+sj)/2;
            int left = getmaxUtil(2*i+1, si, mid, qi, qj);
            int right = getmaxUtil(2*i+2, mid+1, sj, qi, qj);

            return Math.max(left, right); 
        }
    }

    // update... //O(logn)
    public static void update(int arr[], int idx, int newVal){
        arr[idx] = newVal;

        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
        
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal){
        if(idx<si || idx > sj){  //non overlap
            return;
        }

        if(si == sj){  //if reached to that changing index leaf
            tree[i] = newVal;   //we have to change that value
        }
        
        if(si != sj){  //if non leaf
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si + sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);  //left
            updateUtil(2*i+2, mid+1, sj, idx, newVal);  //right
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;

        init(n);

        // build
        build(arr);

        for (int elem : tree) {
            System.out.print(elem + " ");
        }
        System.out.println();

        System.out.println(getMax(arr, 2, 5));
        
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));

    }
}
