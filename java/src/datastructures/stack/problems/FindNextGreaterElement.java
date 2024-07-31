package datastructures.stack.problems;

import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElement {

    public static void main(String[] args) {
        int[] arr = { 4, 6, 3, 2, 8, 1, 11 };
        System.out.println("Input Array : " + Arrays.toString(arr));
        int[] res = findNextGreaterElement(arr);
        System.out.println("Next Greater: " + Arrays.toString(res));
    }

    private static int[] findNextGreaterElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
                res[stack.pop()] = arr[i];
            stack.push(i);
        }
        return res;
    }
}
