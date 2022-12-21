public class DoubleLL {

    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add first...
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    // add Last....
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // remove last...
    public int removeLast(){
        int val;
        if(head == null){
            System.out.println("DLL is empty");

            return Integer.MIN_VALUE;
        }
        if(size == 1){
             val = head.data;
            
            head = tail = null;
            size = 0;
            return val;
        }

         val = tail.data;

        tail = tail.prev;
        tail.next = null;

        
        size--;

        return val;
    }

    // remvoe first
    public int removeFirst(){
        int val;
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        val = head.data;
        head = head.next;
        head.prev = null;
        size--;

        return val;
    }

    // print double LL.
    public void print(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // reverse a Dll..
    public void reverse(){
        // if(head == null){
        //     System.out.println("Dll is empty");
        //     return;
        // }

        // if(head.next == null){
        //     return;
        // }

        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);

        dll.print();
        dll.reverse();
        dll.print();
       
    }
}
