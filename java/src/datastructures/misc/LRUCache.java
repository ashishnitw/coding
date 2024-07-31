package datastructures.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Doubly Linked List Node
 */
public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        System.out.println("LRUCache created: capacity = " + capacity);
    }

    public void addToHead(Node node) {
        // Most recently used node will be added to the head
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            System.out.println("Get: Not found");
            return -1;
        }
        delete(node);   // remove the node from its current position
        addToHead(node);    // add the node to the head
        System.out.println("Get: " + node.value);
        return node.value;
    }

    public void set(int key, int value) {
        System.out.println("Set: " + key + " -> " + value);
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            if (size < capacity) {
                size++;
            } else {
                // remove the least recently used node
                cache.remove(tail.prev.key);
                delete(tail.prev);
            }
            addToHead(node);
        } else {
            // update the value of the node
            node.value = value;
            delete(node);
            addToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.get(1);
        cache.set(3, 3);
        cache.get(2);
    }
}
