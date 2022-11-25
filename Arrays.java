import java.util.*;



public class Arrays {

    public static int largest(int numbers[], int key) {
        int startInd = 0, endInd = numbers.length - 1;

        while (startInd <= endInd) {
            int midInd = (startInd + endInd) / 2;

            if (numbers[midInd] > key) { // left
                endInd = midInd - 1;
            }

            else if (numbers[midInd] < key) { // right
                startInd = midInd + 1;
            }

            else if (numbers[midInd] == key) { // found
                return midInd;
            }
        }

        return -1;

    }

    public static void reverseArr(int numbers[]) {
        int first = 0;
        int last = numbers.length - 1;

        while (first < last) {
            int temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp;

            first++;
            last--;
        }
    }

    public static void pairs(int numbers[]) {
        int tp = 0;
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + numbers[i] + "," + numbers[j] + ") ");
                tp++;
            }

            System.out.println();
        }
        System.out.println("Total pairs: " + tp);
    }

    public static void subarryays(int numbers[]) {
        int ts = 0;
        int maxSum = Integer.MIN_VALUE;
        int minsum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;

            for (int j = i; j < numbers.length; j++) {
                int end = j;

                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += numbers[k];
                    System.out.print(numbers[k] + " ");
                }

                System.out.print(" : " + sum); // sum of subarrays

                // for max and min subarrays sum
                if (sum > maxSum) {
                    maxSum = sum;
                }

                if (sum < minsum) {
                    minsum = sum;
                }

                ts++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("total subarrays: " + ts);
        System.out.println("Min Sum of subarrays: " + minsum);
        System.out.println("Max Sum of subarrays: " + maxSum);
    }

    // subarrays sum without loops...
    public static void subarraysSum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        // calculate prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;

            for (int j = i; j < numbers.length; j++) {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                System.out.println(currSum); // sum of subarrays

                // for max and min subarrays sum
                if (currSum > maxSum) {
                    maxSum = currSum;
                }

            }
        }

        System.out.println("Max Sum of subarrays: " + maxSum);

    }

    public static void kadanes_subarraySum(int numbers[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        boolean allNeg = true;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                allNeg = false;
                break;
            }
        }

        if (allNeg) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > maxSum) {
                    maxSum = numbers[i];
                }
            }

        } else {

            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
                if (sum < 0) {
                    sum = 0;
                }

                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.println("max sum of subarrays is: " + maxSum);
    }

    // trapped rainwater...

    public static void trappedRainwater(int height[]) {
        int n = height.length;

        // make left max array
        int leftMaxArr[] = new int[n];
        leftMaxArr[0] = height[0];

        for (int i = 1; i < leftMaxArr.length; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }

        // make right max array
        int rightMaxArr[] = new int[n];
        rightMaxArr[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
        }

        int trapedWater = 0;
        // loop for total water traped
        for (int i = 0; i < n; i++) {
            int waterHeight = Math.min(leftMaxArr[i], rightMaxArr[i]);

            trapedWater += waterHeight - height[i];
        }

        System.out.println("total trapped water is : " + trapedWater);
    }

    
    // practice questions.....
    
    // 1
    public static boolean checkAtLeastTwice(int numbers[]) {

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return (true);
                }

            }
        }
        
        return (false);
    }
    
    // 2....
    public static int findInd(int numbers[], int target) {
        // find min index
        int minInd = minInd(numbers);
        
        // find left and right 
        if(target >= numbers[minInd] && target <= numbers[numbers.length-1]){
           return binarySearch(numbers, minInd, numbers.length-1, target);
        }
        else{
           return  binarySearch(numbers, 0, minInd, target);
           
        }

        


    }

    // binary search function for geting target
    public static int binarySearch(int numbers[], int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right)/2;
            
            if(numbers[mid] == target){
                return mid;
            }
            else if(numbers[mid] > target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
            
        }
        return -1;
    }

    // find the min numbers index
    public static int minInd(int numbers[]) {
        
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if(numbers[mid] < numbers[mid-1]){
                
                return mid;
            }
            else if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
            
        }
        
        return left;
    }
    
    // 3....
    public static void buy_sell_stock(int price[]) {
        int maxProf = 0;
        int buyPrice = Integer.MAX_VALUE;
    
        for (int i = 0; i < price.length; i++) {
            // int sellPrice = price[i];
    
            if (price[i] > buyPrice) {
                int prof = price[i] - buyPrice; // today's profit
    
                maxProf = Math.max(maxProf, prof);
            } else {
                buyPrice = price[i];
            }
        }
        System.out.println("max Profit: " + maxProf);
    }


    // 4...
    public static int findTrapedWater(int height[]) {
        int n = height.length;
        //  make array for max lefts
        int leftMaxArr[] = new int[n];
        leftMaxArr[0] = height[0];

        for (int i = 1; i < leftMaxArr.length; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i]);
        }

        //  make array for max rights
        int rightMaxArr[] = new int[n];
        rightMaxArr[n-1] = height[n-1];

        for (int i = n-2; i >=0 ; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i+1], height[i]);
        }

        // loop for find total traped water
        int totalTrappedWater = 0;
        for (int i = 0; i < rightMaxArr.length; i++) {
            int waterLevel = Math.min(leftMaxArr[i], rightMaxArr[i]);
            totalTrappedWater += waterLevel - height[i];

        }

        return totalTrappedWater;
    }
    
    
    // 5.....
    public List<List<Integer>> tripleSumZero(int num[]) {
        List<List<Integer>> result =  new    ArrayList <List<Integer>> ();
            
            for (int i = 0; i < num.length; i++) {
                int first = num[i];
                
                for (int j = i+1; j < num.length; j++) {
                    int second = num[j];
                    
                    for (int k = j+1; k < num.length; k++) {
                        int third = num[k];
    
                        if(first + second + third ==0){
    
                            List<Integer> triplet = new ArrayList < Integer > ();
                            triplet.add(num[i]); 
                            triplet.add(num[j]); 
                            triplet.add(num[k]); 
                            Collections.sort(triplet); 
                            result.add(triplet);
                        }
                    }
                }
            }
    
            result = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>> (result));
            return result;
        }
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int nums[] = {0,1,2};
        
        
        // tripleSumZero(nums);
        
    }
}
