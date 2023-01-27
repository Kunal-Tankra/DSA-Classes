package DP.DP1;

public class FibonacciB {

    // before->O(2^n).........after dp ..O(n)
    public static int fib(int n, int f[]){
        if(n ==0 || n == 1){
            return n;
        }

        if(f[n] != 0){  //fib[n] is alreacy calculated
            return f[n];
        }

        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }

    public static void main(String[] args) {
        int n = 5;
        // to store
        int f[] = new int[n+1]; //n+1 because starting with 0
        System.out.println(fib(n, f));
    }
}
