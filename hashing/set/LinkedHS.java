package hashing.set;
import java.util.*;

public class LinkedHS {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>(); 
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");
        
        // linked hash set
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        System.out.println(cities);
        System.out.println(lhs);

    }
}
