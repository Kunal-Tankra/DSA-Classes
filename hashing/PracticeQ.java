package hashing;

import java.util.*;

public class PracticeQ {
    // 1. bottom view of a binary tree....
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        Node node;
        int x;

        public Info(Node node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public static void bottomViewOfBT(Node root) {
        // initialy x = 0
        HashMap<Integer, Node> map = new HashMap<>();

        // add all nodes in map
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                map.put(curr.x, curr.node);

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.x - 1));
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.x + 1));
                }
            }
        }

        // print all nodes from map
        for (int key : map.keySet()) {
            System.out.print(map.get(key).data + " ");
        }

    }

    // 2. two sum......
    public static void twoSum(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int num : arr) {
            if (map.containsKey(target - num)) {
                System.out.print(map.get(target - num) + ",");
                map.remove(target - num);
            }
        }
    }

    // 3. sort by frequency....
    public static void sortByFrq(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (!map.isEmpty()) {
            int frq = 0;
            char ch = 'd' ;
            for (char key : map.keySet()) {
                if(map.get(key) > frq){
                    frq = map.get(key);
                    ch = key;
                    
                }
               
            }

            map.remove(ch);
            

            for (int i = 0; i < frq; i++) {
                System.out.print(ch);
            }
        }
        System.out.println();
    }

    // ans of Least Recent Used from leetcode....
    class LRUCache {
        HashMap<Integer, Node> map = new HashMap<>();
        
        int capa = 0;
        static Node head = new Node(0,0);
        static Node tail = new Node(0,0);
        public LRUCache(int capacity) {
            this.capa = capacity;
            
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) {
           if(map.containsKey(key)){
               Node node = map.get(key);
            //    remove from dq
               remove(node);
    
            //    add in front in dq
            add(node);
               return node.value;
           }
           return -1;
        }
    
        public static void remove(Node node){
            // remove from last
            // if(node.prev != null){
    
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // }
         
            
        }
    
        public static void add(Node node){
            // add in starting
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            
        }
    
        
        
        public void put(int key, int value) {
          Node temp = new Node(key, value);
          if(map.containsKey(key)){
              add(temp);
              remove(map.get(key));
              map.put(key, temp);
          }
          else{
            //   if have space
              if(map.size()< capa){
                  map.put(key,temp);
    
                  add(temp);
              }
              else{
                //   dosnt have space
                map.put(key, temp);
                add(temp);
    
                Node last = tail.prev;
                remove(last);
                map.remove(last.key);
              }
          }
    
            
        }
    
    // dq node
        static class Node{
            int key;
            int value;
            Node next;
            Node prev;
    
            Node(int key, int val){
                this.key = key;
                this.value = val;
            }
        }
    }
    
    

    public static void main(String[] args) {
        // 1.
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right = new Node(22);
        root.right.right = new Node(25);

        // bottomViewOfBT(root);

        // 2.
        int arr[] = { 2, 7, 11, 15 };
        // twoSum(arr, 9);

        // 3.
        String s = "cccaaa";
        // sortByFrq(s);

        
        
        
        
        
        
    }
    
}
