import java.util.*;

import org.w3c.dom.html.HTMLHeadingElement;

public class PracticeQStack {

    // 1. check palindrome....
    public static void isPalindrome(LinkedList<Character> ll) {
        Stack<Character> s = new Stack<>();

        // adding to stack half of ll
        for (int i = 0; i <= ll.size() / 2; i++) {
            s.push(ll.get(i));
        }

        // n is even means we have added a extra element
        if (ll.size() % 2 == 0) {
            s.pop();
        }

        // check
        for (int i = ll.size() / 2; i < ll.size(); i++) {
            if (s.pop() != ll.get(i)) {
                System.out.println("not palindrome");
                return;
            }

        }

        System.out.println("palindrome");
    }

    // 2. simplify path.....
    public static void simplifyPath(String str) {
        Stack<Character> s = new Stack<>();

        int countDots = 1; // count double dots
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (!s.isEmpty() && curr == '/' && s.peek() == '/') { // prev and curr / nhi hone chahiye for- //
                continue;
            }

            // curr is not . than add them
            if (curr != '.') {

                s.push(curr);
            } else if (curr == '.') {
                if (i >= 0 && str.charAt(i - 1) == '.') { // add only when double dots

                    countDots++;
                }

            }

            // single dot
            if (countDots == 1 && curr == '.' && (!s.isEmpty() && s.peek() == '/')) {

                s.pop();

            } else if (countDots == 2 && curr == '.') { // double dots
                while (!s.isEmpty() && s.peek() != '/') {
                    s.pop();
                }
                countDots = 1;
            }

            // if / in last then remove it
            if (i == str.length() - 1 && s.peek() == '/') {
                s.pop();
            }

        }

        // if empty
        if (s.isEmpty()) {
            s.push('/');
        }

        // add to string
        StringBuilder newstr = new StringBuilder("");
        while (!s.isEmpty()) {
            newstr.insert(0, s.peek());
            s.pop();
        }

        System.out.println(newstr.toString());
    }

    // 3.. decode string....
    public static void decodeStirng(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr != ']') { //add
                s.push(curr);
            } else {
                StringBuilder temp1 = new StringBuilder("");     //for collect cherector
                StringBuilder temp2 = new StringBuilder("");     //for collect strings of cherectors

                while (!s.isEmpty() && s.peek() != '[') {      // nikaal k temp 1 me dlega
                    temp1.insert(0, s.pop());
                }
                s.pop();   //pop '['

                int num = Character.getNumericValue(s.pop());   //get number

                for (int j = 0; j < num; j++) {                 //num jitna temp 2 me temp 1 ki cheze dlengi
                    temp2.append(temp1);
                }

                for (int j = 0; j < temp2.length(); j++) {       //push in stack
                    s.push(temp2.charAt(j));
                }

                if(i == str.length()-1){                         // if last element than temp2 is ans
                    System.out.println(temp2.toString());
                    return;
                }
                temp1 = new StringBuilder();
                temp2 = new StringBuilder();
            }

        }
    }

    // 4. trapping rain water...
    public static void trapingRainWater(int height[]){
        Stack<Integer> s = new Stack<>();
        int totalWater = 0;

        s.push(0);
        // next greater left
        int ngl[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int curr = height[i];

            if( curr > height[s.peek()]){

                s.push(i);
            }
            

            if(s.isEmpty()){
                ngl[i] = height[i];
            }
            else{
                ngl[i] = height[s.peek()];
            }
            
        }

        s = new Stack<>();
        s.push(height.length-1);
        // next greater right
        int ngr[] = new int[height.length];
        for (int i = height.length-1; i >=0 ; i--) {
            int curr = height[i];

            if( curr > height[s.peek()]){
                s.push(i);
            }

            if(s.isEmpty()){
                ngr[i] = height[i];
            }
            else{
                ngr[i] = height[s.peek()];
            }
        }
        

        // water
        for (int i = 0; i < height.length; i++) {
            // water =  water height -  block height
            int waterHeight = Math.min(ngl[i], ngr[i]);
            int water = waterHeight - height[i];

            totalWater += water;
        }

        System.out.println("total water: "+ totalWater);

    }

    public static void main(String[] args) {
        // LinkedList<Character> ll = new LinkedList<>();
        // ll.add('a');
        // ll.add('b');
        // ll.add('c');
        // ll.add('w');
        // ll.add('b');
        // ll.add('a');

        // String str = "3[b2[v]]";
        // decodeStirng(str);

       int height[] = {7,0,4,2,5,0,6,4,0,5};
       trapingRainWater(height);
    }
}
