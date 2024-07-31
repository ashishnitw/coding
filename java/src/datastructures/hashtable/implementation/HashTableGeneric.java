package datastructures.hashtable.implementation;

public class HashTableGeneric<X, Y> {
    private HashEntry[] data;
    private int capacity;
    private int size;

    public HashTableGeneric(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[tableSize];
        this.size = 0;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        if(data[hash] == null)
            return null;
        else
            return (Y)data[hash].getValue();
    }
    public void put(X key, Y value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry<X, Y>(key, value);
        size++;
    }
    public Y delete(X key) {
        Y value = get(key);
        if(value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
            hash = (hash + 1)%this.capacity;

            while(data[hash] != null) {
                HashEntry he = data[hash];
                data[hash] = null;
                put((X)he.getKey(), (Y)he.getValue());
                size--;
                hash = (hash+1) % this.capacity;
            }
        }
        return value;
    }
    public boolean hasKey(X key) {	//close to constant time
        int hash = calculateHash(key);
        if(data[hash] == null)
            return false;
        else {
            if(data[hash].getKey().equals(key))
                return true;
        }
        return false;
    }
    public boolean hasValue(Y value) {	//Linear time
        for(int i=0; i<capacity; i++) {
            HashEntry entry = data[i];
            if(entry != null && entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }
    private int calculateHash(X key) {
        int hash = (key.hashCode() % this.capacity);
        while(data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;	//collision
        }
        return hash;
    }

    public void print() {
        for(int i=0; i<capacity; i++) {
            if(data[i] != null)
                System.out.println(data[i]);
        }
    }

    private class HashEntry<X, Y> {
        private X key;
        private Y value;
        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }
        public X getKey() {
            return key;
        }
        public void setKey(X key) {
            this.key = key;
        }
        public Y getValue() {
            return value;
        }
        public void setValue(Y value) {
            this.value = value;
        }
        public String toString() {
            return key + " => " + value;
        }
    }

    public static void main(String[] args) {
        HashTableGeneric<String, Integer> ht = new HashTableGeneric<>(10);
        ht.put("one", 1);
        ht.put("two", 2);
        ht.put("three", 3);
        ht.put("four", 4);
        ht.print();
    }
}

