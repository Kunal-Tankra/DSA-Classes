package hashing.map;
import java.util.*;

public class TreeMapB {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("india",500);
        tm.put("america",100);
        tm.put("nepal",20);
        tm.put("china",2000);

        // this will print with sorted keys- alphabeticay
        System.out.println(tm);
    }
}
