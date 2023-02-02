package DP.DP3;

public class LCS {
    // recursion
    public static int lcs(String str1, String str2, int n, int m) {
        // base
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // if last char is same
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else {
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }
    
    // memoization..o(n*m)
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        // base
        if (n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1){ //already calculated
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // if last char is same
            return dp[n][m] =  lcsMemo(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            int ans1 = lcsMemo(str1, str2, n - 1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m - 1, dp);

            return dp[n][m] = Math.max(ans1, ans2);
        }

        
    }

    // tabulation..O(n*m)
    public static int lcsTabu(String str1, String str2, int n, int m){
        // n-> str1 length, m-> str2 length

        // making dp
        int dp[][] = new int [n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // initialize
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
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


    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int n = str1.length();
        int m = str2.length();

        // System.out.println(lcs(str1, str2, n, m));

        // memo
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(lcsMemo(str1, str2, n, m, dp));

        // tabu
        System.out.println(lcsTabu(str1, str2, n, m));

    }
}
