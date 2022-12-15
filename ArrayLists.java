import java.util.*;

public class ArrayLists {

    public static void findMax(ArrayList<Integer> arr) { // O(n)
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            maxVal = Math.max(maxVal, arr.get(i));
        }
        System.out.println(maxVal);
    }

    public static void swapIndex(ArrayList<Integer> arr, int a, int b) { // O(n)
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);

        System.out.println(arr);
    }

    // container with most water.......
    public static void mostWaterContainer(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;

        // brute force - O(n^2)
        // for (int i = 0; i < height.size(); i++) {
        // for (int j = i + 1; j < height.size(); j++) {
        // int width = j - i;
        // int waterHeight = Math.min(height.get(i), height.get(j));
        // int currWater = waterHeight * width;
        // maxWater = Math.max(maxWater, currWater);
        // }

        // }

        // 2 pointer approach... O(n)
        int lp = 0, rp = height.size() - 1;
        while (lp < rp) {
            int width = rp - lp;
            int waterHeight = Math.min(height.get(rp), height.get(lp));
            int currWater = waterHeight * width;
            maxWater = Math.max(maxWater, currWater);

            // chhoti height wala aage bdhana
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }

        }
        System.out.println(maxWater);
    }

    // pair sum -1..........
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        // Broute force - O(n^2)
        // for (int i = 0; i < list.size(); i++) {
        // for (int j = i+1; j < list.size(); j++) {
        // if(list.get(i)+ list.get(j) == target){
        // return true;

        // }
        // }
        // }

        // 2 pointer approach...
        int lp = 0, rp = list.size() - 1;
        while (lp < rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    // pair sum -2 ....... sorted and rotated...
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1; // here rp is also breaking point
        for (int i = 0; i < list.size(); i++) { // finding breaking point
            if (list.get(i) > list.get(i + 1)) {
                rp = i;
                lp = i + 1;

                break;
            }
        }

        while (lp != rp) {
            int sum = list.get(rp) + list.get(lp);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                lp = (lp + 1) % list.size();
            } else {
                rp = (rp - 1 + list.size()) % list.size();
            }

        }

        return false;

    }

    // practice questions.....
    // 1. monotonic Araylist check
    public static boolean checkMonotonic(ArrayList<Integer> monotonic) {

        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < monotonic.size() - 1; i++) {

            if (monotonic.get(i) > monotonic.get(i + 1)) {
                inc = false;
            }
            if (monotonic.get(i) < monotonic.get(i + 1)) {
                dec = false;
            }
        }

        return inc || dec;

    }

    // 2. only lonely nums return not _ x+1 , x-1
    public static void lonelyNums(ArrayList<Integer> nums) {
        ArrayList<Integer> newArr = new ArrayList<>();

        // brout Force....
        // for (int i = 0; i < nums.size(); i++) {
        // int curr = nums.get(i);
        // boolean add = true;
        // int count = 0;

        // for (int j = 0; j < nums.size(); j++) {
        // int nxt = nums.get(j);
        // if (nxt == curr) {
        // count++;
        // }

        // if (count >= 2 || nxt == curr - 1 || nxt == curr + 1) {
        // add = false;
        // break;

        // }
        // }

        // if (add) {
        // newArr.add(curr);
        // }
        // }

        // optimized .......
        Collections.sort(nums);
        // if there is single element in array
        if (nums.size() == 1) {
            newArr.add(nums.get(0));
            return;
        }

        // if there is more than one element
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                newArr.add(nums.get(i));
            }
        }

        // corner cases
        if (nums.get(0) + 1 < nums.get(1)) { // for first element
            newArr.add(nums.get(0));
        }
        if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) { // for last element
            newArr.add(nums.get(nums.size() - 1));
        }

        System.out.println(newArr);
    }

    // 3... most frequent number following key
    public static void mostFrequentNumFollowingKey(ArrayList<Integer> nums, int key) {
        // if arraylist size is 1 than it dosen't have any frq num
        if (nums.size() == 1) {
            System.out.println("no frequent num");
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                list.add(nums.get(i + 1));
            }
        }

        // if only 1 element is frequent num following key
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        } else if (list.size() == 0) { // if no one element is frequent
            System.out.println("no frequnt num");
            return;
        }

        int mostFreqnInd = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            int currFrqn = Collections.frequency(list, list.get(i));
            int nxtFrqn = Collections.frequency(list, list.get(i + 1));

            if (currFrqn >= nxtFrqn) {
                mostFreqnInd = i;
            } else {
                mostFreqnInd = i + 1;
            }
        }
        System.out.println(list.get(mostFreqnInd));
    }

    // 4... beautiful array
    // first approach
    public static void beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            
            for (Integer elem : ans) {
                if (2 * elem - 1 <= n) { // odd
                    temp.add(2 * elem - 1 );
                }
            }

            for (Integer elem : ans) {
                if (2 * elem <= n) { // even
                    temp.add(2 * elem );
                }
            }
            
            ans = temp;
        }

        System.out.println(ans);
    }

    // second approach-------D&C
    public static void beautifulArray2(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        divideConque(1,1,ans,n);

        // after divide conque
        System.out.println(ans);
    }

    public static void divideConque(int start, int increment, ArrayList<Integer> ans, int n) {
        // base
        if(start+increment > n){
            ans.add(start);
            return;
        }
        divideConque(start, 2*increment, ans, n);
        divideConque(start+increment, 2*increment, ans, n);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();

        // add element - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4, 5); // -O(n).........
        // System.out.println(list);

        // get element - O(1).........
        int element = list.get(1);
        // System.out.println(element);

        // Delete - O(n)...........
        // list.remove(1);
        // System.out.println(list);

        // set element at index - O(n)................
        // list.set(1, 10);
        // System.out.println(list);

        // contains - O(n).............
        // System.out.println(list.contains(4));
        // System.out.println(list.contains(12));

        // size.....
        // System.out.println(list.size());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(9);
        arr.add(3);
        arr.add(6);

        // findMax(arr);
        // swapIndex(arr, 1, 3);

        // System.out.println(arr);
        // Collections.sort(arr); //ascending
        // System.out.println(arr);

        // descending
        // Collections.sort(arr, Collections.reverseOrder());
        // System.out.println(arr);

        // multi_Dimensional ArrayList...........
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list3.add(1 * i); // 1 2 3 4 5
            list4.add(2 * i); // 2 4 6 8 10
            list5.add(3 * i); // 3 6 9 12 15
        }

        mainList.add(list3);
        mainList.add(list4);
        mainList.add(list5);
        list4.remove(2);
        list4.remove(1);

        // System.out.println(mainList);
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);

            for (int j = 0; j < currList.size(); j++) {
                // System.out.print(currList.get(j)+ " ");
            }
            // System.out.println();
        }

        // container with most water
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        // mostWaterContainer(height);

        // pair sum -1
        ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(2);
        list6.add(3);
        list6.add(4);
        list6.add(5);
        list6.add(6);
        int target = 50;

        // System.out.println(pairSum(list6, target));

        // pair sum -2... sorted & rotated
        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(11);
        list7.add(15);
        list7.add(6);
        list7.add(8);
        list7.add(9);
        list7.add(10);
        int target1 = 16;
        // System.out.println(pairSum2(list7, target1));

        // practice questions....
        // 1. check monotonic arraylist
        ArrayList<Integer> monotonic = new ArrayList<>();
        monotonic.add(6);
        monotonic.add(6);
        monotonic.add(7);
        monotonic.add(8);
        // System.out.println(checkMonotonic(monotonic));

        // 2. lonely nums
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);
        
        // lonelyNums(nums);
        
        
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add( 9);
        nums2.add( 3);
        nums2.add( 3);
        nums2.add( 3);
        
        int key = 2;
        //   mostFrequentNumFollowingKey(nums2, key);
        
        
        
        // 4.. beartuful Array
       
        beautifulArray2( 4);



          

    }
}
