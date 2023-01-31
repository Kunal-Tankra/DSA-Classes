package DP.DP2;

public class TargetSumB {
    // if a subset's sum = 10 -> return true

    // O(n * sum)
    public static boolean targetSum(int num[], int sum){
        int n = num.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        // initialize
        // i = items & j = target sum
        // sum = 0 -> set true
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        // item = 0 -> set false (already set)

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = num[i-1];

                // include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                // exclude
                if(dp[i-1][j] == true){
                    dp[i][j] = true;

                }
            }
        }

        // print
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(dp[i][j]){

                    System.out.print("T ");
                }
                else{
                    System.out.print("F ");

                }
            }
            System.out.println();
        }

        return dp[n][sum];
    }
    
    public static void main(String[] args) {
        int num[] = {4,2,7,1,3};
        int sum = 10;

        System.out.println(targetSum(num, sum));
        
    }
}
