package Heap_PriorityQueue;
import java.util.*;

public class PriorityQueuesB {
    // camparable obj..
    static class Student implements Comparable<Student>{ //overriding
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
            // accending order
            // +iv - change positions
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // now pq can copmair and can give priority to objects after - camparable obj 
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());   //decending order
        pq.add(new Student("a", 4));
        pq.add(new Student("b", 5));
        pq.add(new Student("c", 2));
        pq.add(new Student("d", 1));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "-" + pq.peek().rank);
            pq.remove();
        }
    }
}
