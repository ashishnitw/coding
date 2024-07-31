package datastructures.queue.implementation;

public class QueueUsingArray {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public QueueUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;   // to keep the index in range
        arr[rear] = item;
        count++;
        System.out.println(item + " enqueued to queue");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        front = (front + 1) % capacity;
        count--;
        System.out.println("Dequeued from queue");
    }

    public void print(QueueUsingArray queue) {
        for (int i = 0; i < queue.count; i++) {
            int index = (queue.front + i) % queue.capacity;
            System.out.print(queue.arr[index] + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print(queue);
        queue.dequeue();
        queue.print(queue);
        queue.enqueue(6);
        queue.print(queue);

    }
}
