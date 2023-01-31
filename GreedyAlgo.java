import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class GreedyAlgo {

    // activity selection....
    public static void activitySelection(int start[], int end[]) {
        // if end is unsorted then sort it
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];

        }

        // sort 2d array
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        for (int i = 0; i < start.length; i++) {
            System.out.print(activities[i][0] + " ");
            System.out.print(activities[i][1] + " ");
            System.out.println(activities[i][2] + " ");

        }

        // index
        ArrayList<Integer> ans = new ArrayList<>();

        int maxWork = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < start.length; i++) {

            int currStart = activities[i][1];

            if (lastEnd <= currStart) {
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
                maxWork++;
            }
        }

        System.out.println("max work can done: " + maxWork);

        for (Integer i : ans) {
            System.out.print("A" + i + " ");
        }
    }

    // fractional Knapsack...
    public static void fractionalKnapsack(int val[], int weight[], int w) {

        double ratio[][] = new double[val.length][2];
        // 0th col -> ind, 1th col-> ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // sort - ascending orger
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int value = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int currInd = (int) ratio[i][0];

            if (capacity >= weight[currInd]) { // include full item
                value += val[currInd];
                capacity -= weight[currInd];
            } else { // include fractional item( bcha hua weight jitna)
                value += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println(value);
    }

    // min absolute difference pairs.....
    public static void minAbsoluteDiff(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int minDiff = 0;
        for (int i = 0; i < b.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }

        System.out.println(minDiff);
    }

    // max length chain of pairs.....
    public static void maxLengthChain(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int lastChainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (lastChainEnd < pairs[i][0]) {
                chainLen++;
                lastChainEnd = pairs[i][1];
            }
        }

        System.out.println(chainLen);
    }

    // indian coins....
    public static void indianCoins(int ammount) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());

        int coinsCount = 0;

        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= ammount) {
                System.out.print(coins[i] + " ");
                coinsCount++;
                ammount -= coins[i];
            }
        }

        System.out.println();

        System.out.println("total (min)coins:" + coinsCount);
    }

    // job sequencing problem
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobSequencing(int jobInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // sort a array of object with profit ----discending
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        int time = 0;

        for (int j = 0; j < jobs.size(); j++) {
            if (jobs.get(j).deadline > time) {
                System.out.println("index: " + jobs.get(j).id + " ");
                time++;
            }

        }

    }

    // chocala problem.....
    public static void chocalaProblem(Integer costVer[], Integer costHor[]) {
        // sort arrays in descending orger
        Arrays.sort(costVer, Comparator.reverseOrder());
        Arrays.sort(costHor, Comparator.reverseOrder());

        // tracker
        int h = 0, v = 0;

        // horizontal & vertical pices
        int hp = 1, vp = 1;

        int totalCost = 0;

        while (h < costHor.length && v < costVer.length) {
            int hCutPrice = costHor[h];
            int vCutPrice = costVer[v];

            if (hCutPrice > vCutPrice) { // horizontal cut
                totalCost += hCutPrice * hp;
                h++;
                vp++;
            } else { // vertical cut
                totalCost += vCutPrice * vp;
                v++;
                hp++;
            }
        }

        // remaining costHor
        while (h < costHor.length) {
            totalCost += costHor[h] * hp;
            h++;
            vp++;
        }

        // remaining costVer
        while (v < costVer.length) {
            totalCost += costVer[v] * vp;
            v++;
            hp++;
        }

        System.out.println(totalCost);
    }

    // practice questions....

    // 1. maximum balanced string partitions
    public static void maxBalancedString(String str) {
        if (str.length() == 0) {
            return;
        }
        int LCount = 0, RCount = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                LCount++;
            } else {
                RCount++;
            }

            if (LCount == RCount) {
                ans++;
                LCount = RCount = 0;
            }
        }

        System.out.println(ans);
    }

    // 2. Kth largest odd number in given range
    public static void KthLargestOdd(int L, int R, int k) {
        // my approach....
        // ArrayList<Integer> arr = new ArrayList<>();

        // for (int num = L; num <= R; num++) {
        // if (num % 2 != 0) { // odd
        // arr.add(num);
        // }
        // }

        // // if k > arr.size
        // if (k > arr.size()) {
        // System.out.println("nothing is in this position");
        // return;
        // }

        // Collections.sort(arr, Comparator.reverseOrder()); // desending

        // System.out.println(arr.get(k - 1));

        // ----------------------------------------------------------------------
        // 2nd approach - O(1), O(1)..................................

        // Base Case
        if (k <= 0) {
            System.out.println("nothing is in this position");
            return;
        }

        if ((R & 1) > 0) {

            // Calculate count of odd numbers within the range
            int Count = (int) Math.ceil((R - L + 1) / 2);

            // if k > range then kth largest odd number is not in the range
            if (k > Count) {
                System.out.println("nothing is in this position");
                return;
            }

            else {

                System.out.println(R - 2 * k + 2);
            }
        } else {

            // Calculate count of odd numbers within the range
            int Count = (R - L + 1) / 2;

            // If k > range then kth largest odd number is not in this range
            if (k > Count) {
                System.out.println("nothing is in this position");
                return;
            }

            else {

                System.out.println(R - 2 * k + 1);
            }
        }
    }

    // 3. Lexicographically smallest string of length N and sum K...
    // another approach in google
    public static void stringOf_LengthN_SumK(int N, int K) {
        char alpthabets[] = new char[26];
        // 'z' to 'a'
        int j = 0;
        for (char i = 'z'; i >= 'a'; i--) {
            alpthabets[j] = i;
            j++;
        }

        ArrayList<Character> ans = new ArrayList<>();

        for (int i = 0; i < alpthabets.length; i++) {
            int currChar = alpthabets[i] - 'a' + 1;

            while (K >= currChar) {
                K -= currChar;
                N--;

                if ((K == 0 && N != 0) || K < N) {
                    K += currChar;
                    N++;
                    break;
                }

                ans.add(alpthabets[i]);
            }
        }

        Collections.sort(ans);
        System.out.println(ans);
    }

    // 4. Best Time to Buy and Sell Stock
    public static void maxProfit(int prices[]) {
        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice > maxProfit) {
                maxProfit = prices[i] - buyPrice;
            }
        }

        System.out.println(maxProfit);
    }

    // 5. Split the given array into K sub-arrays.... smj ni aaya..
    public static int ans = 10000000;

    public static void solve(int a[], int n, int k, int index, int sum, int maxsum) {
        // K=1 is the base Case
        if (k == 1) {
            maxsum = Math.max(maxsum, sum);
            sum = 0;
            for (int i = index; i < n; i++) {
                sum += a[i];
            }
            // we update maxsum
            maxsum = Math.max(maxsum, sum);
            // the answer is stored in ans
            ans = Math.min(ans, maxsum);
            return;
        }
        sum = 0;
        // using for loop to divide the array into K-subarray
        for (int i = index; i < n; i++) {
            sum += a[i];

            // for each subarray we calculate sum ans update maxsum
            maxsum = Math.max(maxsum, sum);

            // calling function again
            solve(a, n, k - 1, i + 1, sum, maxsum);
        }
    }

    public static void main(String[] args) {

        // Integer costVer[]= {2,1,3,1,4};
        // Integer costHor[]= {4,1,2};

        // chocalaProblem(costVer, costHor);

        // String str = "LRLLRRLRRL";
        // maxBalancedString(str);

        // KthLargestOdd(-3, 3, 1);

        // stringOf_LengthN_SumK(3, 25);

        // int prices[] = { 7, 1, 5, 3, 6, 4 };
        // maxProfit(prices);

        int arr[] = { 1, 2, 3, 4 };
        int k = 3; // K divisions
        int n = 4; // Size of Array
        solve(arr, n, k, 0, 0, 0);
        System.out.println(ans);
    }
}
