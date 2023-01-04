package BinaryTrees;

import java.util.*;

public class BinaryTreesQ {
    // node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 1. check if a Binary Tree is univalued or not
    public static boolean isUnivalued(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.data != root.left.data) {
            return false;

        }

        if (root.right != null && root.data != root.right.data) {
            return false;
        }

        boolean leftCheck = isUnivalued(root.left);
        boolean rightCheck = isUnivalued(root.right);

        return leftCheck && rightCheck;
    }

    // print tree
    public static void print(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // 2. invert Binary tree.....
    public static void mirror(Node root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        // swap
        Node left = root.left;
        root.left = root.right;
        root.right = left;

    }

    // 3. Delete leaf nodes with values as x......
    public static Node deleteLeaf(Node root, int x) {
        if (root == null) {
            return null;
        }

        root.left = deleteLeaf(root.left, x);
        root.right = deleteLeaf(root.right, x);

        if ((root.left == null && root.right == null) && root.data == x) {

            return null;
        }

        return root;
    }

    // 4. find all duplicate Subtrees...
    public static void findDuplicates(Node root){

        // string-> position like node, left, right || integer -> count of that node
        HashMap<String, Integer> map = new HashMap<>();

        duplicates(root, map);


    }

    public static String duplicates(Node root, HashMap<String, Integer> map){
        if(root == null){
            return "";
        }

        String left = duplicates(root.left, map);
        String right = duplicates(root.right, map);

        String str = "(" + left+  (root.data) + right + ")";

        if(map.containsKey(str) && map.get(str) == 1){
            System.out.println(root.data + " ");
        }

        if(map.containsKey(str)){
            map.put(str, map.get(str)+1);
        }
        else{

            map.put(str, 1);
        }
        return str;
    }

    // 5. maximum path sum in a binary tree...
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(Node root){
        if(root == null){
            return 0;
        }

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        // 1. root.data
        // 2. root.data + left
        // 3. root.data + right
        // 4. root.data + left + right

        int currMax = Math.max(Math.max(root.data, root.data + left), Math.max(root.data + right,root.data+ left + right));

        max = Math.max(max, currMax);

        int singlePathSum = Math.max(root.data, Math.max(root.data + left, root.data+ left));
        
        return singlePathSum;


    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        // root.right.left = new Node(15);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        // print(root);
        // findDuplicates(root);

        maxPathSum(root);
        System.out.println(max);

    }
}