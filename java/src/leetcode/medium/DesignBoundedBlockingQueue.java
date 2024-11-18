package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A blocking queue is a type of queue that supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.
 *
 * */

public class DesignBoundedBlockingQueue {

    private Queue<Integer> queue;
    private int capacity;
    private final Object lock = new Object();

    public DesignBoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == capacity)
                lock.wait();
            queue.add(element);
            System.out.println("Added: " + element);
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (lock) {
            while (queue.isEmpty())
                lock.wait();
            int result = queue.poll();
            lock.notifyAll();
            System.out.println("Dequeued: " + result);
            return result;
        }
    }

    public int size() {
        synchronized (lock) {
            return queue.size();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DesignBoundedBlockingQueue q = new DesignBoundedBlockingQueue(3);
        //q.dequeue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
    }
 }
