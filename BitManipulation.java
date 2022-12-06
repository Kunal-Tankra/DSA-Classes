import java.util.*;


public class BitManipulation {
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }

    public static void GetIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);

        }
    }

    public static void setIthBit(int n, int i) {
        int bitMask = 1 << i;

        int afterSet = n | bitMask;
        System.out.println(afterSet);
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = 1 << i;
        // System.out.println(n ^ bitMask);
        // or
        return n & ~bitMask;
    }

    public static void updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0){
        // clearIthBit(n, i);
        // }
        // else if(newBit == 1){
        // setIthBit(n, i);

        // }

        // or

        n = clearIthBit(n, i);
        int bitMask = newBit << i;

        System.out.println(n | bitMask);
    }

    public static void clearLastIBits(int n, int i) {
        // int bitMask = -1 << i;
        int bitMask = ~0 << i;
        System.out.println(n & bitMask);
    }

    public static void clearBitsInRange(int n, int i, int j) {
        int a = ~0 << (j + 1);
        // int b = (1 << i) - 1;
        int b = (int)Math.pow(2, i) - 1;             // or may be mere hisaab se ye bhi shi hai..

        int bitMask = a | b;
        System.out.println(n & bitMask);
    }

    public static void isPowerOfTwo(int n) {
        if ((n & (n - 1)) == 0) {
            System.out.println("number is power of 2");
        } else {
            System.out.println("number is not power of 2");

        }
    }

    public static void countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }

    public static void fastExponentiantion(int givenNum, int pow) {
        int ans = 1;

        while (pow > 0) {
            int lsb = pow & 1;

            if (lsb != 0) {
                ans *= givenNum;
            }

            givenNum = (givenNum * givenNum);
            pow = pow >> 1;
        }

        System.out.println(ans);
    }

    // practice questions....
    // 2.
    public static void swapNumbers(int a, int b) {
        // swap using xor
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + ", " + "b: " + b);
    }

    // 3.
    public static void addOneWithBit(int n) {
        System.out.println(-(~n));
       

    }

    public static void upperToLowerCase() {
        for(char i = 'A'; i <= 'Z'; i++)
            System.out.print((char)(i | ' ') + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // oddOrEven(3);

        // GetIthBit(10, 3);

        // setIthBit(5, 1);

        // clearIthBit(10, 1);

        // updateIthBit(10, 2, 1);

        // clearLastIBits(15, 2);

        // clearBitsInRange(12 , 2,5);

        // isPowerOfTwo(8);

        // countSetBits(16);

        // fastExponentiantion(2, 3);

        // swapNumbers(12, 77);

        // addOneWithBit(-2);

        // upperToLowerCase();

       
    }
}
