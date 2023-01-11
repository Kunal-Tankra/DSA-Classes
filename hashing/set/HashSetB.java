package hashing.set;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetB {
    // count distinct elem...
    public static void countDistinct(int num[]){
        HashSet<Integer> set = new HashSet<>();
        for (int elem : num) {
            set.add(elem);
        }

        System.out.println(set.size());
    }

    // Union & Intersections of 2 array....
    public static void unionIntersection(int arr1[], int arr2[]){
        HashSet<Integer> union = new HashSet<>();
        // union
        for (int num : arr2) {
            union.add(num);
        }
        
        System.out.println("union: " + union.size() + " -> " + union);
        
        // intersection
        union.clear();
        int intersection = 0;
        for (int num : arr1) {
            union.add(num);
        }
        for (int num : arr2) {
            if(union.contains(num)){
                intersection++;
                union.remove(num) ;
                System.out.print(num + ", ");
                
            }
        }


        System.out.println(" <- intersection: " + intersection);
        

        
    }

    

    public static void main(String[] args) {
       

    }
}
