import java.util.*;

public class JavaBasics {

    public static int fact(int n) {
        int factN = 1;

        for (int i = 1; i <= n; i++) {
            factN *= i;
        }

        return factN;

    }

    public static int BC(int n, int r) {

        int factN = fact(n);

        int factR = fact(r);

        int factN_R = fact(n - r);

        return factN / (factR * factN_R);
    }

    public static float sum(float a, float b) {
        return a + b;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    // check prime
    public static boolean checkPrime(int n) {
        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }

    public static void rangePrime(int n) {

        for (int i = 2; i <= n; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void binToDec(int binNum) {
        // int n = 101;
        int pow = 0;
        int dec = 0;

        while (binNum > 0) {

            int lastNum = binNum % 10;

            dec += (lastNum * (int) Math.pow(2, pow));

            binNum /= 10;
            pow++;

        }

        System.out.println("final:" + dec);

    }

    public static void decToBin(int decNum) {
        int bin = 0;
        int pow = 0;

        while (decNum > 0) {
            int rem = decNum % 2;

            bin = bin + (rem * (int) Math.pow(10, pow));

            decNum /= 2;
            pow++;

        }

        System.out.println("bin: " + bin);

    }

    public static int opposite(int n) {
        int opposite = 0;
        int pow = 0;
        while (n > 0) {
            int LD = n % 10;
            opposite = (opposite * 10) + LD;

            n /= 10;
            pow++;
        }

        return opposite;

    }

    public static void avg(int a, int b, int c) {
        int avg = (a + b + c) / 3;

        System.out.println(avg);

    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void isPalindrome(int n) {
        int opp = opposite(n);

        if (n == opp) {
            System.out.println(n + " is palindrome");
        } else {
            System.out.println(n + " is not palindrome.");
        }

    }

    public static void sumOfDig(int n) {
        int num = n;
        int sum = 0;

        while (n > 0) {
            int ld = n % 10;
            sum += ld;
            n /= 10;
        }
        System.out.println("sum of " + num + " is: "+sum);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sumOfDig(n);

    }
}

// boilerplate code