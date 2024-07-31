package algorithms.greedy;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterUsingStack(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4 , 5 , 2 , 25};
        System.out.println(Arrays.toString(nextGreater(arr)));
        System.out.println(Arrays.toString(nextGreaterUsingStack(arr)));
    }
}
