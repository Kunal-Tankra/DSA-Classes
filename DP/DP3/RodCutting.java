package DP.DP3;

public class RodCutting {

    public static int rodCutting(int length[], int[] price, int totRod){
        int n = length.length;

        int dp[][] = new int[n+1][totRod+1];
        // i-> length, j-> tot rod length
        // (i,j) -> map Profit of i,j

        // initialy: i,j = 0 ->0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int l = length[i-1];
                int p = price[i-1];

                if(l <= j){ //valid
                    int incProfit = p + dp[i][j-l];
                    int excProgit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProgit);
                }
                else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // print dp
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][totRod];
    }

    public static void main(String args[]){
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totRod = 8;

        System.out.println(rodCutting(length, price, totRod));
    }
}
