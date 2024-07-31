package datastructures.hashtable.implementation;

import java.util.ArrayList;
import java.util.List;

public class HashTableBasic {
    static class HashEntry {
        String key;
        int value;
        HashEntry next; // for chaining

        public HashEntry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<HashEntry> buckets;   // buckets
    private int slots;  // no. of buckets
    private int size;   // size of hashtable
    public HashTableBasic() {
        slots = 10;
        size = 0;
        buckets = new ArrayList<>();
        // Initialize all the buckets
        for (int i = 0; i < slots; i++) {
            buckets.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();  // hashCode is a built-in function of Strings
        int index = hashCode % slots;   // get the index
        // check if index is negative
        if (index < 0) {
            index = (index + slots) % slots;
        }
        return index;
    }

    public void insert(String key, int value) {
        int idx = getIndex(key);
        HashEntry head = buckets.get(idx);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets.get(idx);
        HashEntry newEntry = new HashEntry(key, value);
        buckets.set(idx, newEntry);
        newEntry.next = head;

        // Checks if array > 60% of the array gets filled
        if ((1.0 * size) / slots >= 0.6) {
            List<HashEntry> temp = buckets;
            buckets = new ArrayList();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++) // Initialize all the buckets
                buckets.add(null);
            for (HashEntry headNode : temp) {  // Rehash all the values
                while (headNode != null) {
                    insert(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < slots; i++) {
            HashEntry head = buckets.get(i);
            while (head != null) {
                System.out.println(head.key + " -> " + head.value);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        HashTableBasic hashTable = new HashTableBasic();
        hashTable.insert("this", 1);
        hashTable.insert("coder", 2);
        hashTable.insert("this", 4);
        hashTable.insert("hi", 5);
        hashTable.insert("hello", 5);
        System.out.println("Size of hashtable: " + hashTable.getSize());
        hashTable.print();
    }
}
