package DP.PracticeQ;

public class NumOfParenthesis {
    // find the number of parenthesis combinations (same as balance parentheses)

    static int ans = 0;
    public static void ParCombi(int n, int open, int close ){
        if(close == n){
            ans++;
        }

        
        if(open < n){
          
          ParCombi(n, open+1, close);
        }
        if(open > close){
            
          ParCombi(n, open, close+1);

        }

       
    }

    public static void main(String[] args) {
       int n = 3;
       ParCombi(n, 0, 0);
       System.out.println(ans);
       
    }
}
