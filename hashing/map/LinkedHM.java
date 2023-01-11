package hashing.map;
import java.util.*;

public class LinkedHM {
    
    public static void main(String[] args) {
        // for insertion order metters
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India",500);
        lhm.put("america",100);
        lhm.put("nepal",20);
        lhm.put("china",2000);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",500);
        hm.put("america",100);
        hm.put("nepal",20);
        hm.put("china",2000);


        System.out.println(lhm);
        // hm is without order
        System.out.println(hm);

       
        
    }
}
