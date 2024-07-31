package datastructures.queue.implementation;

public class QueueGeneric<X> {

    private X[] data;
    private int front;
    private int end;

    public QueueGeneric(int size) {
        front = -1;
        end = -1;
        data = (X[]) new Object[size];
    }

    public int size() {
        if(front == -1 && end == -1)
            return 0;
        else
            return end - front + 1;
    }

    public void enQueue(X item) {
        if((end + 1)%data.length == front)
            throw new IllegalStateException("Queue is full");
        else if(size() == 0) {
            front++; end++;
            data[end] = item;
        } else {
            end++;
            data[end] = item;
        }
    }

    public X deQueue() {
        X item = null;
        if(size() == 0)
            throw new IllegalStateException("Queue is empty");
        else if (front == end) {
            item = data[front];
            data[front] = null;
            front = -1; end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item) {
        if (size() == 0)
            return false;
        for(int i = front; i < end; i++) {
            if(data[i].equals(item))
                return true;
        }
        return false;
    }

    public X access(int position) {
        if(size() == 0 || position > size())
            throw new IllegalArgumentException("Queue is empty or position is greater than size of queue");
        int trueIndex = 0;
        for(int i = front; i < end; i++) {
            if(trueIndex == position)
                return data[i];
            trueIndex++;
        }
        throw new IllegalArgumentException("Could not find item at position: " + position);
    }



    public static void main(String[] args) {

    }

}
