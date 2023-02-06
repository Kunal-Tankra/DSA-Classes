package DP.DP4;

import javax.print.DocFlavor.STRING;

public class LCSubstring {
    // longest common substring (variation of lcs->(lc_sequence))

    // recursion
    public static int lcs(String s1, String s2, int n, int m, int same){
        if(n ==0 || m ==0){
            return 0;
        }


        if(s1.charAt(n-1) == s2.charAt(m-1)){
            same++;
            int ans1 = lcs(s1, s2, n-1, m-1, same);
            return Math.max(same, ans1);
        }
        else{
            int ans2 = lcs(s1, s2, n-1, m, 0);
            int ans3 = lcs(s1, s2, n, m-1, 0);
            return Math.max(ans2, ans3);
        }
    }

    // tabulation .. O(n*m)
    public static int lcsTabu(String s1, String s2 ){
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        // initialize for i = 0 -> 0 & j = 0 -> 0
        // already filled in all (i,j)-> 0 in java

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;

                    ans = Math.max(ans, dp[i][j]);
                }
                else{

                    dp[i][j] = 0;
                }
            }
        }

       

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";

        // System.out.println(lcs(s1, s2, s1.length(), s2.length(), 0));
        System.out.println(lcsTabu(s1, s2));

    }
}
