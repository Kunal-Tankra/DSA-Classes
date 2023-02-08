package DP.DP4;

public class StringConversion {
    public static void stringCon(String s1, String s2){
        // 1. find lcs length
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];
        // initialize: i=0 -> 0   &  j=0 -> 0

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        int lcsLength = dp[n][m];

        int deleteOperations = n - lcsLength;
        int addOperations = m - lcsLength;

        System.out.println("delete Operations: " + deleteOperations+ '\n' + "add Operations: " + addOperations);

        
    }
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "aceg";

        stringCon(s1, s2);
    }
}
