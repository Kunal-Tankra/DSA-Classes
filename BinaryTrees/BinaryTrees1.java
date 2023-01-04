package BinaryTrees;

import java.util.*;

public class BinaryTrees1 {

    // ndoe
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

    static class BinaryTree {
        static int ind = -1;

        // build tree..
        public static Node buildTree(int nodes[]) {
            ind++;
            // base case- if first elem is null
            if (nodes[ind] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[ind]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode; // root element
        }

        // preorder...

        public static void preorder(Node root){
            // base 
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);

        }

        // inorder
        public static void inorder(Node root){
            // base
            if(root == null){
                return ;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        
        // postorder..
        public static void postorder(Node root){
            // base
            if(root == null){
                return ;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // level order
        public static void levelOrder(Node root){
            // base
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            // initialy
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if(currNode == null){
                    System.out.println();
                    // if null is in last
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");

                    if(currNode.left != null){
                        q.add(currNode.left);
                    }

                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    // find height
    public static int treeHeight(Node root){
        // base
        if(root == null){
            return 0;
        }

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    // count of nodes
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes +1;
    } 

    // sum of nodes
    public static int nodesSum(Node root){
        // base
        if(root == null){
            return 0;
        }

        int leftSum = nodesSum(root.left);
        int rightSum = nodesSum(root.right);

        return root.data + leftSum + rightSum;
    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // BinaryTree tree = new BinaryTree();

        // Node root = tree.buildTree(nodes);

    //    tree.levelOrder(root);

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
 
    int height = nodesSum(root);
    System.out.println(height);
    }
}
