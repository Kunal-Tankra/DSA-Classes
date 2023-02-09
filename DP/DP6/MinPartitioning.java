package DP.DP6;

public class MinPartitioning {
    // minimum partitioning...
    public static int minPartitioning(int num[], int i, int j){
        if(num.length == 2){
            return Math.abs(num[1] - num[0]);
        }
        if(i == j){
            return num[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int min1 = minPartitioning(num, i, k);
            int min2 = minPartitioning(num, k+1, j);

            int min3;
            if(i == j-1){

              return  min3 = Math.abs(min2+min1);
            }
            else{
                
                min3 = Math.abs(min2-min1);
            }
            ans = Math.min(ans, min3);
        }

        return ans;
    }
    public static void main(String[] args) {
        int num[] = {1,36};

        System.out.println(minPartitioning(num, 0, num.length-1));

    }
}
