package DP.DP3;

public class CoinChangeB {

    // O(n*sum)
    public static int coinChange(int coins[], int sum){
        int n = coins.length;
        // store ways
        // dp[i][j] -> ways for i-coins, j-sum
        int dp[][] = new int[n+1][sum+1];

        // initialize
        // sum is 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // coins is 0
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int c = coins[i-1];

                if(c <= j){ //valid
                    // include + exclude
                    dp[i][j] = dp[i][j-c] + dp[i-1][j];
                }
                else{  //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
            
        }
        
        return dp[n][sum];

    }

    public static void main(String[] args) {
        int coins[] = {2,5,3,6};
        int sum = 10;

        System.out.println(coinChange(coins, sum));
        
    }
}
