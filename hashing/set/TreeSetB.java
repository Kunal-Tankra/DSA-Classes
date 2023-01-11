package hashing.set;
import java.util.*;

public class TreeSetB {

    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(2);
        ts.add(10);
        ts.add(100);
        ts.add(1);
        System.out.println(ts);    //O(logn)
    }
}
