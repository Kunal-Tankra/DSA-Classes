package DP.DP2;

public class Z_1KnapsackB {
    // find max profit

    // 1. recursion - O(2^n)
    public static int knapsack(int val[], int wt[], int W, int i) {
        if (W == 0 || i == 0) {
            return 0;
        }

        if (wt[i - 1] <= W) { // i-1 -> because we start with last
            // include
            int ans1 = val[i - 1] + knapsack(val, wt, W - wt[i - 1], i - 1);

            // exclude
            int ans2 = knapsack(val, wt, W, i - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, i - 1);

        }
    }

    // 2. memoization - O(i*W) -because of dp
    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) { // i-1 -> because we start with last
            // include
            int ans1 = val[n - 1] + knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);

            // exclude
            int ans2 = knapsackMemo(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
            
        } else {
            dp[n][W] = knapsackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];

        }
    }

    // 3. tabulation
    public static int knapsackTabu(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for (int i = 0; i < dp.length; i++) { //0th col
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) { //0th row
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v  = val[i-1]; //ith item val not i-1
                int w = wt[i-1];

                if(w <= j){ //valid
                    // include -> curr + (dp[i-1 items][weight - curr weight])th profit
                    int incProfit = v + dp[i-1][j-w];

                    // exclude -> dp[i-1 items][curr weight]
                    int excProfit = dp[i-1][j];
                    
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;

                }
            }
        }

        // print
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return dp[n][W];

        
        
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        // knapsack(val, wt, W, val.length);

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsackMemo(val, wt, W, val.length, dp));

        System.out.println(knapsackTabu(val, wt, W));

    }
}
