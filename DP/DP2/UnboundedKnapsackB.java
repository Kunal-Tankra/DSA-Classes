package DP.DP2;

public class UnboundedKnapsackB {
    // O(n * W)
    public static int unboundedKnapsack(int[] val, int[] wt, int W){
        int n = val.length;

        int dp[][] = new int[n+1][W+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }    

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j){ //valid
                    int incProfit = v + dp[i][j-w];  //-----the only chage in 0-1 knapsack is-> dp[i-1][j-w]
                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{ //invalid
                    int excProfit = dp[i-1][j];
    
                    dp[i][j] =  excProfit;

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
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(unboundedKnapsack(val, wt, W));
    }
}
