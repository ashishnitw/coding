package algorithms.greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a list arr[] of everyday temperatures.
 * For each day, the task is to find the count of days remaining for the next day with warmer temperatures.
 * If there is no such day for which warmer temperature is possible then print -1.
 * */
public class NextHigherTemperature {

    public static int[] nextWarmerDay(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextWarmerDayGreedy(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();   // store the index of the element.
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i=0; i<n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            System.out.println("Stack: " + stack);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = nextWarmerDay(arr);
        System.out.println(Arrays.toString(res));

        int[] arr1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res1 = nextWarmerDayGreedy(arr1);
        System.out.println(Arrays.toString(res1));
    }
}
