package BinarySearchTrees;

import java.util.*;

import javax.swing.plaf.synth.SynthLabelUI;

public class BST_practiceQ {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // 1. Range Sum of Bst....
    public static int sumInRange(Node root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumInRange(root.left, L, R);
        int rightSum = sumInRange(root.right, L, R);

        if (root.data >= L && root.data <= R) {
            return root.data + leftSum + rightSum;
        }

        return leftSum + rightSum;
    }

    // 2. find the closest element in Binary Search Tree...
    static int minDiff = Integer.MAX_VALUE;
    static Node closest;

    public static void closestElem(Node root, int k) {
        if (root == null) {
            return;
        }

        // diff = 0;
        if (root.data == k) {
            closest = root;
            return;
        }

        closestElem(root.left, k);
        closestElem(root.right, k);

        int currDiff = Math.abs(root.data - k);

        if (minDiff > currDiff) {
            minDiff = currDiff;
            closest = root;
        }

    }

    // 3. find Kth smallest elem in BST....
    static int count = 0;
    public static void smallestElem(Node root, int k) {
        if (root == null) {
            return;
        }
    
        smallestElem(root.left, k);
        
        count++;
        if(count ==  k){
            System.out.println(root.data);
            return;
        }
        else if(count > k){
            return;
        }
        smallestElem(root.right, k);

        

    }

    // 4. two sum BSTs ... output should be count of pairs..
    static int countPairs = 0;
    public static void count_PairsSum1(Node root1, Node root2, int x){
        if(root1 == null || root2 == null){
            return;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        while(true){
            while(root1 != null){
                st1.push(root1);
                root1  = root1.left;
            }

            while(root2 != null){
                st2.push(root2);
                root2 = root2.right;
            }

            if(st1.isEmpty() || st2.isEmpty()){
                break;
            }

            Node top1 = st1.peek();
            Node top2 = st2.peek();

            if(top1.data + top2.data == x){
                countPairs++;

                st1.pop();
                st2.pop();

                root1 = top1.right;
                root2 = top2.left;
                
            }
            else if(top1.data + top2.data < x){
                st1.pop();

                root1 = top1.right;
            }
            else{
                st2.pop();

                root2 = top2.left;
            }
        }
        

    }

    // approach 2.. O(n*H)
    public static void count_PairsSum2(Node root1, Node root2, int x){
        if(root1 == null){
            return;
        }

        count_PairsSum2(root1.left, root2, x);
        checkIn2ndBSt(root1.data, root2, x);
        count_PairsSum2(root1.right, root2, x);
    }

    public static void checkIn2ndBSt(int root1Data,Node root2, int x ){
        if(root2 == null){
            return;
        }

        int val = x - root1Data;

        if(val == root2.data){
            countPairs++;

        }
        else if(val < root2.data){
            checkIn2ndBSt(root1Data, root2.left, x);
        }
        else{
            checkIn2ndBSt(root1Data, root2.right, x);
        }
    }

   
    // 5. maximum sum bst in binary tree....
    static class Info{
        boolean isBST;
        int max;
        int min;
        int sum;

        Info(boolean isBSt, int max , int min, int sum){
            this.isBST = isBSt;
            this.max = max;
            this.min = min;
            this.sum = sum;
            
        }
    }

     static int maxSumBST = Integer.MIN_VALUE;
    public static Info fintMaxSumBST(Node root){
        // base
        if(root == null){
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Info left = fintMaxSumBST(root.left);
        Info right = fintMaxSumBST(root.right);

        // making curr info
        int max = Math.max(root.data, Math.max(left.max, right.max));
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int sum = left.sum + right.sum + root.data;

        // valid check
        if((root.data > left.max && root.data < right.min) && (left.isBST && right.isBST)){ // valid

            maxSumBST = Math.max(maxSumBST, sum);

            return new Info(true, max, min, sum);
        }

       



        return new Info(false, max, min, sum);

    }

    // preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        // 1.
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right = new Node(11);
        root.right.right = new Node(20);

        // int sum = sumInRange(root, 3, 5);
        // System.out.println(sum);

        // 2.
        closestElem(root, 19);
        // System.out.println(closest.data);

        // 3. 
        // smallestElem(root, 5);

        // 4.
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        
        root1.right = new Node(7);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        
        root2.right = new Node(15);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        count_PairsSum2(root1, root2, 16);
        // System.out.println(countPairs);

        // 5.
        root = new Node(7);
        root.left  = new Node(12);
        root.left.left  = new Node(11);
        root.left.right  = new Node(13);
        root.left.left.left  = new Node(2);
        // root.left.left.right  = new Node(7);

        root.right  = new Node(2);
        root.right.right  = new Node(5);
        root.right.right.left  = new Node(1);
        root.right.right.right  = new Node(38);
        fintMaxSumBST(root);
        // preorder(root);
        System.out.println(maxSumBST);

    }
}
