package hashing.map;

import java.util.*;

public class HashMapB {

    // majority elem...
    public static void majorityElem(int num[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : num) {
            // if(map.containsKey(n)){
            // map.put(n, map.get(n)+1);
            // }
            // else{
            // map.put(n, 1);
            // }

            // or

            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > num.length / 3) {
                System.out.print(key + " ");
            }
        }

        System.out.println();
    }

    // valid Anagram...
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;

            }
        }

        return map.isEmpty();

    }

    // find Itinerary/ Journey from Tickets....
    public static void itinerary(HashMap<String, String> tickets) {
        // find start
        String start = findStart(tickets);
        System.out.print(start);

        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }

        System.out.println();

    }

    public static String findStart(HashMap<String, String> tickets) {
        // reverse hashmap
        HashMap<String, String> revTickets = new HashMap<>();

        for (String key : tickets.keySet()) {
            revTickets.put(tickets.get(key), key);
        }

        // get start
        for (String key : tickets.keySet()) {
            if (!revTickets.containsKey(key)) {
                return key;
            }
        }
        return null;

    }

    // largest subarray with 0 sum...
    public static void largestSubArrLength(int arr[]){
        // <sum, ind>
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }
            else{
                map.put(sum, j);
            }
        }

        System.out.println(len);
    }

    // subarray sum equal to k
    public static void sumEqlK(int arr[],int k){
        // <sum, count>
        HashMap<Integer, Integer> map = new HashMap<>();

        // initialy
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];

            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(count);

    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Benguluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // itinerary(tickets);

        int arr[] = { 10,2,-2,-20,10 };
        int k = -10;
        sumEqlK(arr , k);

    }
}
