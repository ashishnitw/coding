package datastructures.stack.problems;

import java.util.Stack;

public class SortElementsInStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        sortUsingRecursion(stack);
        //sortUsingTempStack(stack);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private static void sortUsingTempStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int a = stack.pop();
            while (!temp.isEmpty() && a > temp.peek())
                stack.push(temp.pop());
            temp.push(a);
        }
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }

    private static void sortUsingRecursion(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int a = stack.pop();
            sortUsingRecursion(stack);
            insert(stack, a);
        }
    }

    private static void insert(Stack<Integer> stack, int a) {
        if (stack.isEmpty() || a > stack.peek()) {
            stack.push(a);
            return;
        }
        int b = stack.pop();
        insert(stack, a);
        stack.push(b);
    }
}
