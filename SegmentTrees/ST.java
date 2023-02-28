package SegmentTrees;

// creation & query & update on ST

public class ST {
    // the tree
    public static int tree[];

    // initialize tree array
    public static void init(int n){
        tree = new int[4*n];
    }

    // build
    public static int buildST(int arr[] , int i, int st, int end){ //o(n)
        // base case - leaf nodes
        if(st == end){
            return tree[i] = arr[st];
        }

        int mid = (st+end)/2;
        // left child index = 2*i+1
        buildST(arr, 2*i + 1, st, mid);

        // right child ind = 2*i +2
        buildST(arr, 2*i + 2, mid+1, end);

        return tree[i] = tree[2*i+1] + tree[2*i+2];

    }

    // Query on ST (subarray sum)
    public static int getSum(int arr[], int qi, int qj){ 
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj){ //O(logn)
        // base case: case 1 & 2
        if(qj<= si || qi >= sj){ //case 1: non overlapping
            return 0;
        }
        else if(si>= qi && sj<= qj){ //case 2: overlapping
            return tree[i];
        }
        else{                         //case 3: partial overlapping
            int mid = (si+sj)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);

            return left + right;
        }
    }

    // update (subarray sum)
    public static void update(int arr[], int idx, int newValue){
        int diff = newValue - arr[idx];
        arr[idx] = newValue;

        int n = arr.length;

        updateUtil(0, 0, n-1, idx, diff);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){  //O(logn)
        if(idx>sj || idx<si ){  //dosn't lie in range
            return;
        }

        tree[i] += diff;

        if(si != sj){  //non leaf
            int mid = (si+sj)/2;
            // left
            updateUtil(2*i+1, si, mid, idx, diff);
            // right
            updateUtil(2*i+2,mid+1, sj, idx, diff);
        }

        return;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);

        buildST(arr, 0, 0, n-1);

        for (int elem : tree) {
            System.out.print(elem + " ");
            
        }
        System.out.println();

        // query
        System.out.println(getSum(arr, 2, 5)); //18
        
        // update
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5)); //17


    }
}
