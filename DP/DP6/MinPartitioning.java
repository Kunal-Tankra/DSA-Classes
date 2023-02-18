package DP.DP6;

public class MinPartitioning {
    // minimum partitioning...   variation of 0-1 knapsack

    // O(n*W)
    public static int minPartitioning(int num[]){
        int n = num.length;
        int sum = 0;
        for (int elem : num) {
            sum += elem;
        }

        int W = sum/2;

        int dp[][] = new int[n+1][W+1];

        // bottom up
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = num[i-1];

                if(v <= j){  //include
                    int include = v + dp[i-1][j - v];
                    int exclude = dp[i-1][j];
                    
                    dp[i][j] = Math.max(include, exclude);
                }
                else{  //exlcude
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;

                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;


        return Math.abs(sum2-sum1);

    }

    // variation of question
    // if sum1 -sum 2 ==0 -> return true;
    public static boolean isZero(int num[]){
        int n = num.length;
        int sum = 0;
        for (int elem : num) {
            sum+= elem;
        }

        int w = sum/2;
        int dp[][] = new int[n+1][w+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = num[i-1];
                if(v <=j){
                    dp[i][j] = Math.max(v + dp[i-1][j-v], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            
        }

        int sum1 = dp[n][w];
        int sum2 = sum- sum1;
       
        return sum1 == sum2;
    }
    public static void main(String[] args) {
        int num[] = {1,1,1};

        // System.out.println(minPartitioning(num));

        System.out.println(isZero(num));

    }
}
