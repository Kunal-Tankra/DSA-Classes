package DP.DP1;

public class ClimbingStairs {
    // count ways to reach the nth stair.....

    // memoization..O(n)
    public static int countWays(int n, int dp[]) {
        // base
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) { // already have
            return dp[n];
        }

        dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp);
        return dp[n];
    }

    // tabulation....
    public static int countWaysTabu(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // tabulation loop
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];

        System.out.println(n + " stairs" + ": " + countWaysTabu(n));
    }
}
