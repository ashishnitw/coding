package datastructures.stack.implementation;

public class StackGeneric<V> {
    private int maxSize;
    private int top;
    private V array[];

    /**
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Un-comment the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public StackGeneric(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[maxSize];//type casting Object[] to V[]
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public V top(){
        if(isEmpty())
            return null;
        return array[top];
    }

    public void push(V value){
        if(isFull()) {
            System.err.println("Stack is Full!");
            return;
        }
        array[++top] = value; //increments the top and adds value to updated top
    }

    public V pop(){
        if(isEmpty())
            return null;
        return array[top--]; //returns value and top and decrements the top
    }

    public boolean contains(V value) {
        for (int i = 0; i <= top; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StackGeneric<Integer> stack = new StackGeneric<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Top element is: " + stack.top());
        System.out.println("Is stack full? " + stack.isFull());
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Top element is: " + stack.top());
        System.out.println("Is stack full? " + stack.isFull());

    }
}
