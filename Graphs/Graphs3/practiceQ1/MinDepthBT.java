package Graphs.Graphs3.practiceQ1;

public class MinDepthBT {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // find minimum Depth of a Binary Tree.......
    public static int minDepth(Node root){
        if(root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left, right)+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(5);

        root.right = new Node(2);
        // root.right.left = new Node(9);

        System.out.println(minDepth(root));
        
    }
}
