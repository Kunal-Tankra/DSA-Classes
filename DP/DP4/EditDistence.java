package DP.DP4;

public class EditDistence {
    // O(n*m)
    public static int editdist(String w1, String w2){
        int n = w1.length();
        int m = w2.length();
        int dp[][] = new int[n+1][m+1];

        // i -> w1 length, j-> w2 length
        // (i,j) -> no. of operations to convert w1->w2

        // initialize
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0){
                    dp[i][j] = j;
                }
                if(j == 0){
                    dp[i][j] = i;
                }

            }
           
        }

        // bottom up fill
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(w1.charAt(i-1) == w2.charAt(j-1)){ //same
                    dp[i][j] = dp[i-1][j-1];
                }
                else{ //diff
                    int add = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = Math.min(add, Math.min(delete, replace)) +1;
                    // yha tk kitne min me phoch skte +1
                }
            }
        }

        return dp[n][m];

    }
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        int operations =editdist(word1, word2);
        System.out.println(operations);
        
    }
}
