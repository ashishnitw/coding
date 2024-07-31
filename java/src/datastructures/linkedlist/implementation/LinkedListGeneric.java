package datastructures.linkedlist.implementation;

public class LinkedListGeneric<X> {
    private class Node {
        private Node next;
        private X item;

        public Node(X item) {
            this.item = item;
            this.next = null;
        }
        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }
        public Node getNextNode() {
            return next;
        }
        public X getNodeItem() {
            return item;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedListGeneric() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(X item) {
        if(first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        size++;
    }

    public X remove() {
        if (first == null)
            throw new IllegalStateException("list is empty");
        X item = first.getNodeItem();
        first = first.getNextNode();
        size--;
        return item;
    }

    public X get(int position) {
        if(position > size())
            throw new IllegalArgumentException("wrong position");
        Node curr = first;
        for(int i=0; i<position && curr!=null; i++) {
            if(i == position)
                return curr.getNodeItem();
            curr = curr.getNextNode();
        }
        return null;
    }

    public int find(X item) {
        if(first == null)
            throw new IllegalStateException("empty list");
        Node curr = first;
        for(int i=0; i<size() && curr!=null; i++) {
            if(curr.getNodeItem().equals(item))
                return i;
            curr = curr.getNextNode();
        }
        return -1;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node curr = first;
        while(curr != null) {
            contents.append(curr.getNodeItem());
            curr = curr.getNextNode();
            if(curr != null)
                contents.append(", ");
        }
        return contents.toString();
    }

    public int size() {
        return size;
    }

    public void insert(X item, int position) {
        if(position > size())
            throw new IllegalArgumentException("wrong position");
        Node curr = first;
        for(int i=0; i<position && curr!=null; i++) {
            curr = curr.getNextNode();
        }
        Node newNode = new Node(item);
        Node nextNode = curr.next;
        curr.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        size++;
    }

    public X removeAt(int position) {
        if(first == null)
            throw new IllegalStateException("empty list");
        Node curr = first;
        Node prev = first;
        for(int i=0; i<position && curr!=null; i++) {
            prev = curr;
            curr = curr.getNextNode();
        }
        X item = curr.getNodeItem();
        prev.setNextNode(curr.getNextNode());
        size--;
        return item;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
