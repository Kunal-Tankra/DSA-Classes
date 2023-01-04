package BinaryTrees;

import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class BinaryTrees3 {
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

    // kth level of a tree....

    // level order treversal
    public static void kthLevel_Iteration(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int currLevel = 1;
        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    currLevel++;
                    q.add(null);
                }
            } else {
                if (k == currLevel) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // recursive form...
    public static void kthLevel_Recursive(Node root, int k, int level) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthLevel_Recursive(root.left, k, level + 1);
        kthLevel_Recursive(root.right, k, level + 1);

    }

    // lowest common ancestor....
    // Approach -1
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }

        }

        // LCA
        return path1.get(i - 1);

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // base
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        // if not found remove last/ remove we added in top line- 102
        path.remove(path.size() - 1);
        return false;
    }

    // Approach -2
    public static Node lca2(Node root, int n1, int n2) {
        // base case
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node righttLca = lca2(root.right, n1, n2);

        // leftLca = val, rightLca = null
        if (righttLca == null) {
            return leftLca;
        }

        if (leftLca == null) {
            return righttLca;
        }

        return root;
    }

    // min distance between nodes...
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int lcaDist(Node root, int n) {
        // base
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    // kth ancestor of node.....
    public static int kthAncestor(Node root, int n , int k){
        // base
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if(max +1 == k){
            System.out.println(root.data);
        }

        return max+1;

    }

    // transform to sum tree...
    public static int transformToSumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = transformToSumTree(root.left);
        int rightSum = transformToSumTree(root.right);

        int rootData = root.data;

        root.data = leftSum + rightSum;

        return rootData + root.data;
    }

    // print tree
    public static void print(Node root){
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       q.add(null);

       while(!q.isEmpty()){
        Node curr = q.remove();
        if(curr == null){
            System.out.println();
            if(q.isEmpty()){
                break;
            }
            else{
                q.add(null);
            }
        }
        else{
            System.out.print(curr.data + " ");
            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }
        }
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

        // System.out.println(minDist(root, 4, 5));
        // kthAncestor(root, 5, 3);

        print(root);
        transformToSumTree(root);
        print(root);
    }
}
