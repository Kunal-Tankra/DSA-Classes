package BinaryTrees;

import java.math.RoundingMode;
import java.util.*;

public class BinaryTrees2 {

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

    // height
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Approach - 1..........

    // diameter -- O(n^2)
    public static int diam(Node root) {
        // base
        if (root == null) {
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int selfDiam = lHeight + rHeight + 1;

        int lDiam = diam(root.left);
        int rDiam = diam(root.right);

        return Math.max(selfDiam, Math.max(lDiam, rDiam));
    }

    // Aproach -2.....
    static class Info {
        int diam;
        int height;

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    // diam
    public static Info diam2(Node root) {
        // base
        if (root == null) {
            return new Info(0, 0);
        }

        Info lInfo = diam2(root.left);
        Info rInfo = diam2(root.right);

        int fianlDiam = Math.max(lInfo.height + rInfo.height + 1, Math.max(lInfo.diam, rInfo.diam));

        int finalHeight = Math.max(lInfo.height, rInfo.height) + 1;

        return new Info(fianlDiam, finalHeight);
    }

    // subtree of another tree....
    public static boolean isSubtree(Node root, Node subRoot){
        // base
        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIndentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);   //check for left and right subtrees
    }

    public static boolean isIndentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }

        else if(node == null || subRoot == null || node.data != subRoot.data){       // conditions for send false
            return false;
        }

        
        return isIndentical(node.left, subRoot.left) &&  isIndentical(node.right, subRoot.right);  // for left and right check identical
        
    }

    // top view of a tree.....
    static class Info2{
        Node node;
        int hd;  // horizontal distance

        public Info2(Node node, int hd){

            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        // level treverse
        Queue<Info2> q = new LinkedList<>();

        // key -> hd, value -> node
        HashMap<Integer, Node> map = new HashMap<>();

        // for iterate in end
        int min = 0, max = 0;

        // adding initialy
        q.add(new Info2(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{

                // adding in map if occurring first time
                if(!map.containsKey(curr.hd)){    //for top view
                    map.put(curr.hd, curr.node);
                }

                // map.put(curr.hd, curr.node);   //for bottom view

                if(curr.node.left != null){
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if(curr.node.right != null){
                    q.add(new Info2(curr.node.right, curr.hd +1));
                    max = Math.max(max, curr.hd+1);
                }
            }


        }
        
        // iterating from map
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }


    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        topView(root);
    }
}
