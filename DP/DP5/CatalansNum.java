package DP.DP5;

import java.util.Arrays;

public class CatalansNum {
    // 1. recursion
    public static int catalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int cn = 0;
        for (int i = 0; i <= n - 1; i++) {
            cn += catalan(i) * catalan(n - 1 - i);
        }

        return cn;

    }

    // 2. memoization
    public static int catalanMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i <= n-1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n-1-i, dp);
        }

        return dp[n] = ans;
        
    }

    // 3. tabulation.....O(n*n)
    public static int catalanTabu(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = 0;
            for (int j = 0; j <= i-1; j++) {
                dp[i] += dp[j] * dp[i-j-1];    //Cn = Ci * Cn-i-1
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        // System.out.println(catalan(n));

        // memo
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        // System.out.println(catalanMemo(n, dp));

        // tabu
        System.out.println(catalanTabu(n));
    }
}
