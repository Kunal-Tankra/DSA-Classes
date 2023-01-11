package hashing.map;

import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.*;

import javax.naming.LimitExceededException;

public class HashMapImplement {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n
        private int N;
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked") // niche LL wala error na aae isi liye

        public HashMap() { // initial set
            this.N = 4;
            this.buckets = new LinkedList[4]; // ye error dega q k kis type ka LL form hona h nhi btaya..

            // initialy seting ll in all buckedts/index
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // put.....
        public void put(K key, V value) {
            // find bucket index
            int bi = hashFunction(key); // 0 to size-1

            int di = searchInLL(key, bi); // valid -> ind; not valid-> -1;

            if (di != -1) { // exists
                // update
                Node node = buckets[bi].get(di);
                node.value = value;

            } else { // add
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lembda = (double) n / N;
            if (lembda > 2.0) { // 2.0 is threshold value
                rehash();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            // same like initialize code...
            LinkedList<Node> oldBuckets[] = buckets; // copy the bucket

            buckets = new LinkedList[N * 2]; // renew bucket with double size
            N = 2 * N;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>(); // initialize with ll
            }

            // nodes add in bucket again
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N; // because 0 to size-1 me chahiye -

        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; // direct go to that bucket

            int di = 0;

            // search
            for (int i = 0; i < ll.size(); i++) {
                Node curr = ll.get(i);
                if (curr.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        // contains key....
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        // remove
        public V remove( K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
 
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            else{
                return null;
            }

            
        }

        // get....
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }
            else{
                return null;
            }
        }

        // return key set..
        public ArrayList<K> keySet(){
             ArrayList<K> keys = new ArrayList<>();

             for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];

                for (Node node : ll) {
                    keys.add(node.key);
                }

             }

             return keys;
        }

        // is Empty
        public boolean isEmpty(){
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 100);
        hm.put("china", 150);
        hm.put("us", 50);
        hm.put("nepal", 5);

        hm.put("london",25);

        
        System.out.println(hm.remove("india"));
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key+": " + hm.get(key));
        }
    }
}
