package BinarySearchTrees;

import java.util.*;

public class BST2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // level order treverse
    public static void print(Node root) {
        if (root == null) {
            return;
        }
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

    // inorder
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // preorder
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // sorted array to Balanced BST...
    public static Node balancedBST(int arr[], int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = balancedBST(arr, st, mid - 1);
        root.right = balancedBST(arr, mid + 1, end);

        return root;
    }

    // convert BST to balanced BST...
    public static Node convert2Balanced(Node root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder);

        // sorted inorder -> balance bst
        return balancedBST_ArrayList(inorder, 0, inorder.size() - 1);
    }

    public static void findInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        findInorder(root.left, inorder);
        inorder.add(root.data);
        findInorder(root.right, inorder);

    }

    public static Node balancedBST_ArrayList(ArrayList<Integer> arr, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(arr.get(mid));
        root.left = balancedBST_ArrayList(arr, st, mid - 1);
        root.right = balancedBST_ArrayList(arr, mid + 1, end);

        return root;
    }

    // size of largest BST in BT....
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST_size = 0;
    public static Info largestBST(Node root ){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // making curr node info-
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // valid check
        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST_size = Math.max(maxBST_size, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }

    // merge 2 BSTs...  O(n+m)
    public static Node merge(Node root1, Node root2){
        ArrayList<Integer> nodes1 = new ArrayList<>();
        ArrayList<Integer> nodes2 = new ArrayList<>();
        
        getAllNodes(root1, nodes1);
        getAllNodes(root2, nodes2);

        // sort all nodes arraylist
        ArrayList<Integer> nodes = new ArrayList<>();
        int i = 0, j = 0;

        while(i< nodes1.size() && j < nodes2.size()){
            if(nodes1.get(i)< nodes2.get(j)){
                nodes.add(nodes1.get(i));
                i++;
            }
            else{
                nodes.add(nodes2.get(j));
                j++;
            }
        }
        
        while(i < nodes1.size()){
            nodes.add(nodes1.get(i));
            i++;
            
        }
        
        while(j < nodes2.size()){
            nodes.add(nodes2.get(j));
            j++;

        }

        // build that bst
        return buildBST_merge(nodes, 0, nodes.size()-1);

        
    }

    public static Node buildBST_merge(ArrayList<Integer> nodes, int st, int end){
        if(st > end){
            return null;
        }

        int mid = (st + end )/2;
        Node root = new Node(nodes.get(mid));

        root.left = buildBST_merge(nodes, st, mid-1);
        root.right = buildBST_merge(nodes, mid +1, end);

        return root;
    }

    public static void getAllNodes(Node root, ArrayList<Integer> nodes){
        if(root == null){
            return;
        }

        getAllNodes(root.left, nodes);
        nodes.add(root.data);
        getAllNodes(root.right, nodes);
    }

    public static void main(String[] args) {
        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        // Node root = balancedBST(arr, 0, arr.length - 1);

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        // root.left.left.left = new Node(3);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        // preorder(root);
        // System.out.println();
        // root = convert2Balanced(root);
        // preorder(root);

        // largestBST(root);
        // System.out.println(maxBST_size);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        root = merge(root1, root2);
        preorder(root);

    }
}
