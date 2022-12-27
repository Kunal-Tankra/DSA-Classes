package BinaryTrees;

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
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

       tree.preorder(root);
    }
}
