import java.net.NetworkInterface;
import java.util.*;

public class LLPracticeQ {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // print..
    public static void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // add last...
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;

    }

    // 1. find intersection...
    public void intersection(Node head1, Node head2) {
        Node temp1 = head1;

        while (temp1 != null) {
            Node temp2 = head2;

            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.println(temp1.data);
                    return;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }

    // 2. delete n nodes after m nodes...
    public void deleteNafterM(int m, int n) {
        Node temp = head;
        int countM = 0;
        int countN = 0;

        while (temp != null) {
            countM++;

            while (countN != n && countM == m) {
                temp.next = temp.next.next;
                countN++;
            }

            temp = temp.next;
            if (countN == n && countM == m) {
                countN = 0;
                countM = 0;
            }

        }
    }

    // 3. swappint nodess......
    public void swap(int x, int y) {
        if (x == y) {

            return;
        }

        Node prevX = null, currX = head;

        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;

        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {

            return;
        }

        if (prevX != null) {

            prevX.next = currY;
        } else {

            head = currY;
        }

        if (prevY != null) {

            prevY.next = currX;
        } else {

            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // odd even....
    public Node oddEven() {
        Node temp = head;

        // even linked list
        Node head1 = new Node(-1);
        Node track1 = head1; // tail1

        // odd linked list
        Node head2 = new Node(-1);
        Node track2 = head2;

        while (temp != null) {
            if ((temp.data % 2) != 0) { // odd

                track2.next = temp;
                track2 = track2.next;

            } else { // even
                track1.next = temp;
                track1 = track1.next;

            }
            temp = temp.next;
        }

        head1 = head1.next;
        head2 = head2.next;

        track1.next = head2; // track1 = tail1
        track2.next = null;

        if (head1 == null) {
            return head2;
        }
        return head1;

    }

    // 5. merge k lists
    public static Node mergeKLists(Node arr[]){
        Node sortedHead = arr[0];
     
        for (int i = 1; i<arr.length; i++) {
            sortedHead = mergeSort(sortedHead, arr[i]);
        }

        return sortedHead;
    }

    public static Node mergeSort(Node head1, Node head2) {
        LLPracticeQ ll = new LLPracticeQ();
        Node mergeLL = ll.new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
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
        
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
            
        }
        
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
            
        }

        return mergeLL.next;
    }

    public static void main(String[] args) {
        LLPracticeQ ll = new LLPracticeQ();

        // 1. find intersection.....
        // Node head1, head2;
        // head1 = ll.new Node(1);
        // head1.next = ll.new Node(2);
        // head1.next.next = ll.new Node(3);

        // Node temp = ll.new Node(6);
        // head1.next.next.next = temp;

        // head1.next.next.next.next = ll.new Node(7);

        // head2 = ll.new Node(4);
        // head2.next = ll.new Node(5);
        // head2.next.next = temp;

        // ll.intersection(head1, head2);

        // ll.addLast(1);
        // ll.addLast(3);
        // ll.addLast(5);
        // ll.addLast(5);
        // ll.addLast(7);
        // ll.addLast(1);
        // ll.addLast(9);
        // ll.addLast(3);
        // ll.addLast(7);

        // print();
        // head = ll.oddEven();
        // print();

        // 5. merge k sorted lists
        LinkedList<Integer> l2 = new LinkedList<>();
        int k = 3;
        int n = 2;

        Node arr[] = new Node[k];

        arr[0] = ll.new Node(1);
        arr[0].next = ll.new Node(3);
        arr[0].next.next = ll.new Node(5);
        arr[0].next.next.next = ll.new Node(7);

        arr[1] = ll.new Node(2);
        arr[1].next = ll.new Node(4);
        arr[1].next.next = ll.new Node(6);
        arr[1].next.next.next = ll.new Node(8);

        arr[2] = ll.new Node(0);
        arr[2].next = ll.new Node(9);
        arr[2].next.next = ll.new Node(10);
        arr[2].next.next.next = ll.new Node(11);

        
       
        head = mergeKLists(arr);
        print();

    }

}
