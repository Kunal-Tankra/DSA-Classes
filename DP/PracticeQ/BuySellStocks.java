package DP.PracticeQ;

public class BuySellStocks {

    static int max_profit(int a[], int b[], int n, int fee) {
        int i, j, profit;

        int l, r, diff_day = 1, sum = 0;

        // b[0] will contain the maximum profit
        b[0] = 0;
        // b[1] will contain the day
        // on which we are getting the maximum profit
        b[1] = diff_day;
        for (i = 1; i < n; i++) {
            l = 0;
            r = diff_day;
            sum = 0;

            for (j = n - 1; j >= i; j--) {
                // here finding the max profit
                profit = (a[r] - a[l]) - fee;

                // if we get less then or equal to zero
                // it means we are not getting the profit
                if (profit > 0) {
                    sum = sum + profit;
                }
                l++;

                r++;
            }
            // check if sum is greater then maximum then store the new maximum
            if (b[0] < sum) {
                b[0] = sum;

                b[1] = diff_day;

            }
            diff_day++;
        }

        return 0;
    }

    // my code
    public static void maxProfit(int arr[], int tranfee) {
        int final_dayDiff = 1;
        int final_profit = 0;

        int dayDiff = 1;
        while(dayDiff < arr.length){
            int sum = 0;
            int diffInd = dayDiff;

            for (int i = 0; i < arr.length; i++) {
                if(diffInd < arr.length){
                    int profit = arr[diffInd] - arr[i] - tranfee;

                    if(profit > 0){
                        sum+= profit;
                    }

                    diffInd++;
                }
                
            }

            if(final_profit< sum){
                final_dayDiff = dayDiff;
                final_profit = sum;
            }

            dayDiff++;
        }

        System.out.println("my: " + final_profit + ", " + final_dayDiff);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int transactionFee = 2;
        maxProfit(arr, transactionFee);

        // copy
        int n = arr.length;
        int[] b = new int[2];
        int tranFee = 2;
        max_profit(arr, b, n, tranFee);
        System.out.println(b[0] + ", " + b[1]);
    }
}
