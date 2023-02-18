package DP.DP6;

import java.util.Arrays;

public class MinArrayJumps {
    public static int minJumps(int arr[]){
        int n = arr.length;

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        // initialize
        dp[n-1] = 0;

        for (int i = n-2; i >=0; i--) {
            int minJumps = Integer.MAX_VALUE;
            
            for (int j = 0; j < arr[i]; j++) {  //arr[i] -> steps
                int lastjumps = dp[i + j+1]; 
                if(lastjumps != -1){

                    minJumps = Math.min(minJumps, lastjumps +1);
                }
            }

            if(minJumps != Integer.MAX_VALUE){

                dp[i] = minJumps;
            }

        }
        

        return dp[0];
    }
    public static void main(String[] args) {
        int arr[] = {2,3,0,1,4};
        System.out.println(minJumps(arr));
        
    }
}
