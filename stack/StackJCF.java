// ----------stack with java collection frame work--------

import java.util.*;

public class StackJCF {
    // print stack...
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // push at bottom...
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // base
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // reverse string with stack....
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder newStr = new StringBuilder();

        while (!s.isEmpty()) {
            newStr.append(s.pop());
        }

        return newStr.toString();
    }

    // reverse a stack......
    public static void reverseStack(Stack<Integer> s) {
        // base case
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // Stock span problem.....
    public static void stockSpan(int stocks[], int span[]) {
        // stack to store prev highs index
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // first is also 1 because first is also high
        s.push(0);

        for (int i = 1; i < span.length; i++) {
            int currPrice = stocks[i];

            // chhoto ko nikaalna stock se
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {

                span[i] = i + 1;
            } else {
                int prevHighInd = s.peek();
                span[i] = i - prevHighInd;
            }

            s.push(i);

        }
    }

    // next Greater.....
    public static void nextGreater(int arr[], int nextGreater[]) {
        // stack for store index of greater elem
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];

            while (!s.isEmpty() && curr >= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }

    // check valid parentheses....
    public static boolean isValidParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // open
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);

            } else { // close
                // if we are in close and stack is empty - means there is no opening bracked
                if (s.isEmpty()) {
                    return false;
                }

                // if pair
                if ((s.peek() == '(' && ch == ')') ||
                        (s.peek() == '{' && ch == '}') ||
                        (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        return s.isEmpty(); // if there is still a opening breacket
    }

    // check duplicate perentheses.......
    public static boolean isDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // if not closing
            if (ch != ')') {
                s.push(ch);
            } else {
                int count = 0;

                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true;
                }

                s.pop(); // poping'
            }
        }

        return false;
    }

    // find max area in histogram.......
    public static void maxArea(int height[]) {
        int maxArea = 0;

        Stack<Integer> s = new Stack<>();

        // next smaller left
        int nsl[] = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            int curr = height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }

            s.push(i);
        }
            

        s = new Stack<>();    //again empty
        // next smaller right
        int nsr[] = new int[height.length];

        for (int i = height.length-1; i >=0 ; i--) {
            int curr = height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = height.length;
            }
            else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        // area = height * (j - i -1)
        for (int i = 0; i < height.length; i++) {
            int currHeight = height[i];
            int width = nsr[i] - nsl[i] -1;

            int area = currHeight * width;

            maxArea = Math.max(maxArea, area);
        }

        System.out.println("Max area in Histogram: " + maxArea);
    }

    public static void main(String[] args) {
        // int stock[] = {100,80,60,70,60,85,100};
        // int span[] = new int [stock.length];

        // stockSpan(stock, span);
        // for (int i = 0; i < span.length; i++) {
        // System.out.print(span[i] + " ");
        // }

        // String str = "(a+b)";

        // System.out.println(isDuplicateParentheses(str));

        int height[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(height);

    }
}