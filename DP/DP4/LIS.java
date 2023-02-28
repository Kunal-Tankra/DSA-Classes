package DP.DP4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class LIS {
    // longest increasing subsequence..
    public static int lis(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        // all unique elem in arr2
        int arr2[] = new int[hs.size()];
        int i = 0;
        for (int elem : hs) {
            arr2[i] = elem;
            i++;
        }

        // sort
        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }

    public static int lcs(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr1[i-1] == arr2[j-1])            {
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    // 2nd method
    public static int lis2(int arr[]){
        int n = arr.length;

        int dp[] = new int[n];
        dp[0] = 1;  //initialy first elems lis = 1

        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int count = 0;

            for (int j = 0; j < i; j++) {  //starting to ith
                if(arr[j] < curr){
                    count = Math.max(count, dp[j]);  
                }
            }

            dp[i] = count +1;
            ans = Math.max(ans, dp[i]);
            
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {50,3,10,7,40,80};
        System.out.println(lis(arr));
        System.out.println("lis2: "+ lis2(arr));

        
    }
}
