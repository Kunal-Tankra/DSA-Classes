import java.util.NoSuchElementException;

import javax.print.attribute.standard.PrinterMessageFromOperator;

// ------without Java Collections Framework (Linked List)--------

public class LinkedList1 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step - 1 = create new node
        Node newNode = new Node(data);
        size++;

        // if linked list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step -2 = newNode next = head
        newNode.next = head; // linking

        // step -3 = head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;

    }

    // print the linked list.....
    public void print() { // O(n)

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // add in mid of linked list
    public void add(int ind, int data) {
        if (ind == 0) {
            addFirst(data);
            return;
        }

        size++;

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < ind - 1) { // ind -1 because we reached prev of ind element
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove...
    public int removeFirst() {
        // base cases...

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size -2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;

        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // iterative search...
    public int itrSearch(int key) { // O(n)
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) { // key found
                return i;
            }

            temp = temp.next;
            i++;
        }

        // key not found
        return -1;
    }

    // recursive search....

    // my approach

    // public void recSearch(Node head, int i, int key){
    // // base case
    // if(head == null){
    // System.out.println(-1);
    // return;
    // }

    // // kaam
    // if(head.data == key){
    // System.out.println(i);
    // return;
    // }

    // recSearch(head.next, i+1, key);
    // }

    // 2nd approach....
    public int recSearch(int key) {
        return helper(head, key);
    }

    public int helper(Node head, int key) { // O(n)
        // base
        if (head == null) {
            return -1;
        }

        // kaam
        if (head.data == key) {
            return 0;
        }

        int ind = helper(head.next, key); // callind recursion

        if (ind == -1) { // -1 means key has not found
            return -1;
        }

        return ind + 1; // if key found send back +1 index
    }

    // reverse a linked list......
    public void reverse() {
        Node prev = null;
        Node curr = tail = head; // tail = head, curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // delete nth from end
    public void deleteNthFromEnd(int n) {
        // count size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // base case
        if (sz == n) {
            head = head.next;
            return;
        }

        // from starting find prev
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // find mid ---> slow-fast approach
    public Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my mid NOde
    }

    // check palindrome...
    public boolean checkPalindrome() {
        // base case.
        if (head == null || head.next == null) {
            return true;
        }

        // step 1 - find mid..
        Node mid = findMidNode(head);

        // step 2 - reverse 2nd half.
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        // step 3 - check 1st half and 2nd half.
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;

    }

    // check if LL is looped or not
    public static boolean isCycle(){
        Node slow= head;
        Node fast= head;

        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2

            if(slow == fast){
                return true;   //cycle exists
            }
        }

        return false;   //cycle doesn't exixts
    }


    // remove cycle.....
    public static void removeCycle(){
        // check cycle
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCycle = true;
                break;
            }
        }

        if(isCycle == false){
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;   //will be last node

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }


        // last.next = null
        prev.next = null;
    }

    // merge sort.......
    public Node mergeSort(Node head){
        // base
        if(head == null || head.next == null){
            return head;
        }

        // find mid
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }
        }

        // remaining left LL 
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
            
        }

        // remaining right LL
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
            
        }

        return mergeLL.next;
    }

    // zigZag.....
    public static void zigZag(){
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;


        // reverse from mid.next
        Node curr = mid.next;
        mid.next = null;       //first half ends with null

        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node leftH = head;
        Node rightH = prev;
        Node nextL, nextR;

        while(leftH != null && rightH != null){
            // zig zag add
            nextL = leftH.next;
            nextR = rightH.next;

            leftH.next = rightH;
            rightH.next = nextL;

            // update
            leftH = nextL;
            rightH = nextR;
        }

        // zig zag merge
    }

    public static void main(String[] args) {
        LinkedList1 ll = new LinkedList1();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5); 
        ll.addLast(6); 

        ll.print();
       ll.zigZag();
        ll.print();

    }
}
