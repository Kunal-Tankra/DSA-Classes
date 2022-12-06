public class RecursioinBasics {
    // 1.
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    // 2.
    public static void printIncreasing(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }

        printIncreasing(n - 1);
        System.out.print(n + " ");

    }

    // 3.
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fNm1 = fact(n - 1);
        int fact = n * fNm1;

        return fact;

    }

    // 4.
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }

        int totalSum = n + sum(n - 1);
        return totalSum;
    }

    // 5.
    public static int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        int f1 = fib(n - 1);
        int f2 = fib(n - 2);

        return f1 + f2;
    }

    // 6.
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    // 7.
    public static void firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            System.out.println("there is no match");
            return;
        }

        if (key == arr[i]) {
            System.out.println("index:" + i);
            return;
        }

        firstOccurence(arr, key, i + 1);
    }

    // 8.
    public static int lastOccurence(int arr[], int key, int i) {
        if (i == -1) {
            return -1;
        }

        if (key == arr[i]) {
            return i;
        }

        return lastOccurence(arr, key, i - 1);
    }

    // 9. x to the power n
    public static int printxPn(int x, int n) {
        if (n == 1) {
            return x;
        }

        int xPn = x * printxPn(x, n - 1);
        return xPn;
    }

    // 10. x to the power n (optimized)
    public static int optimizedxPn(int x, int n) {
        if (n == 1) {
            return x;
        }

        // int halfPwrSqr = optimizedxPn(x, n/2) * optimizedxPn(x, n/2); //TC-> O(n) but
        // chahiye log n
        // or
        int halfPwr = optimizedxPn(x, n / 2);
        int halfPwrSqr = halfPwr * halfPwr;

        if (n % 2 != 0) {
            halfPwrSqr *= x;
        }

        return halfPwrSqr;
    }

    // 11
    public static int tileProblem(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // kaam
        // vertical
        int fnm1 = tileProblem(n - 1);

        // horizontal
        int fnm2 = tileProblem(n - 2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    // 12.
    public static void removeDuplicate(String str, int ind, StringBuilder newStr, boolean mapArr[]) {
        if (ind == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(ind);

        if (mapArr[currChar - 'a'] == true) {
            removeDuplicate(str, ind + 1, newStr, mapArr);
        } else {
            mapArr[currChar - 'a'] = true;
            removeDuplicate(str, ind + 1, newStr.append(currChar), mapArr);
        }
    }

    // 13
    public static int friendsPair(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return friendsPair(n - 1) + ((n - 1) * friendsPair(n - 2));
    }

    // 14
    public static void printBinStrings(int n, int lastPlace, String newStr) {
        if (n == 0) {
            System.out.println(newStr);
            return;
        }

        // kaam
        printBinStrings(n - 1, 0, newStr + "0");

        if (lastPlace == 0) {
            printBinStrings(n - 1, 1, newStr + "1");
        }

    }

    // practice questions...
    // 1
    public static void findKeyInd(int arr[], int n, int key) {
        if (n == arr.length) {
            return;
        }

        if (arr[n] == key) {
            System.out.print(n + " ");
        }

        findKeyInd(arr, n + 1, key);

    }

    // 2.
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void getNumbersInString(int num) {
        if (num == 0) {
            return;
        }

        int lastDigit = num % 10;

        getNumbersInString(num / 10);

        System.out.print(digits[lastDigit] + " ");
    }

    // 3.
    public static int countStrLength(String str) {
        if (str.length() == 0) {
            return 0;
        }

        return 1 + countStrLength(str.substring(1));
    }

    // 4.
    public static int countSubStr(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }

        int res = countSubStr(str, i + 1, j, n - 1) +
                countSubStr(str, i, j - 1, n - 1) -
                countSubStr(str, i + 1, j - 1, n - 2); // common

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;

    }

    // 5.. Tower of Honoi ->>>>> important
    public static void twrOfHonoi(int n, char src, char des, char help) {
        // base case
        if( n == 1){
            System.out.println("Move disk " + n + " from " + src + " to " + des);
            return;
        }
        
        // work
        twrOfHonoi(n-1, src, help, des);
        System.out.println("Move disk " + n + " from " + src + " to " + des);
        twrOfHonoi(n-1, help, des, src);
        


        
    }


    public static void main(String[] args) {
        // String str = "aba";
        // System.out.println(countSubStr(str, 0, str.length() - 1, str.length()));

        twrOfHonoi(2, 'A', 'C', 'B');
    }
}
