package DP.DP5;

// hard 
public class WildcardMatch{
    // wild card matching...
    // with string and pattern

    // O(n*m )
    public static boolean wildCardMatch(String s, String p){
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        // initialize
        // s = "", p=""
        dp[0][0] = true;

        // p = ""
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;    
        }

        // s = ""
        for (int j = 1; j < dp[0].length; j++) {
            if(p.charAt(j-1) == '*'){ //j-1 because if "*" only one char then 1-1=0 index
                dp[0][j] = dp[0][j-1];
            }
            else{ //'?' or any char
                dp[0][j] = false;
            }
        }

        // fill- bottum up
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    //   ignore || include(* matches with ith char of s)
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j]= false;
                }
            }
            
        }

        return dp[n][m];
    }
    public static void main(String[] args){
        String s = "aa";
        String p = "*";

        System.out.println(wildCardMatch(s, p));

    }
}