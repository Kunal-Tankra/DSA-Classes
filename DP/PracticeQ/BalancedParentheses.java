package DP.PracticeQ;


public class BalancedParentheses {
    // print all combinations of balanced parentheses

    public static void printBalanced(char arr[], int pos, int n, int open , int close){
        if(close == n){ //arr is full whith open and close equaly
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();

            return;
        }
        else{
            if(open < n){  //add open
                arr[pos] = '{';
                printBalanced(arr, pos+1, n, open+1, close);
            }
            if(open > close){ //add close
                arr[pos] = '}';
                printBalanced(arr, pos+1, n, open, close+1);
            }
        }

    }

    public static void balancedParentheses(int n, char arr[]){
        if(n > 0){
            // arr, pos, n, open, close
            printBalanced(arr, 0, n, 0,0);
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        char arr[] = new char[n*2]; //double because there is open and close perentheses
        balancedParentheses(n, arr);

    }
    
}
