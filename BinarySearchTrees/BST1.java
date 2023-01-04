package BinarySearchTrees;

import java.util.*;

public class BST1 {

    // node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build a BST
    static Node root = null;

    public static void build(int val[]) {
        for (int i = 0; i < val.length; i++) {
            root = insert(root, val[i]);
        }

    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            // left insert
            root.left = insert(root.left, val);

        } else {
            // right insert
            root.right = insert(root.right, val);

        }

        return root;

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

    // search BST... O(H)
    public static boolean searchBST(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return searchBST(root.left, key);
        } else {

            return searchBST(root.right, key);
        }

    }

    // delete a node..
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else { // here delete the node
            // case 1- leaf node
            if (root.right == null && root.left == null) {
                return null;
            }

            // case 2- one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3- both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // print in range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    // root to leaf paths
    public static void rootToLeaf(Node root) {
        ArrayList<Integer> path = new ArrayList<>();

        paths(root, path);
    }

    public static void paths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        // we are in leaf
        if (root.left == null && root.right == null) {

            System.out.println(path);
        }

        paths(root.left, path);
        paths(root.right, path);

        path.remove(path.size() - 1);

    }

    // validate BST......
    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        // check root is valid
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max); // check for left and right

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

    // mirror a bst
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11 };

        build(values);

        // inorder(root);
        // System.out.println();
        // delete(root, 1);
        // inorder(root);

        // printInRange(root, 5, 12);

        inorder(root);
        System.out.println();
        mirror(root);
        inorder(root);

    }
}
