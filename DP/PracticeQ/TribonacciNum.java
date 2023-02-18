package DP.PracticeQ;

import java.util.Arrays;

public class TribonacciNum {
    // O(n)....memo  & tabulation

    // memoization
    public static int tribonacciNum(int n, int dp[]){
        if(n == 0|| n ==1){
            dp[n] = 0;
        }
        else if(n == 2){
            dp[n] = 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = tribonacciNum(n-1, dp) + tribonacciNum(n-2, dp) + tribonacciNum(n-3, dp);

        return dp[n];


    }

    // tabulation
    public static void tribonacciNumTabu(int n){
        int dp[] = new int[n];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        // print
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;

        // memoization
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        tribonacciNum(n-1, dp);
        for (int i = 0; i < dp.length; i++) {
            
            System.out.print(dp[i]+ " ");
        }

        // tabulation
        // tribonacciNumTabu(n);


    }
}
