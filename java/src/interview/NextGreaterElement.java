package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public static int[] nge(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] <= nums[i]) {
                j++;
            }
            if (j < n) {
                result[i] = nums[j];
            }
        }
        return result;
    }

    public static int[] ngeUsingStack(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                System.out.println("Next greater element for " + stack.peek() + " is " + nums[i]);
                result[i-1] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] ngeUsingMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 5, 3};
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Next greater element for each element: " + Arrays.toString(nge(nums)));
        System.out.println("Next greater element for each element using stack: " + Arrays.toString(ngeUsingStack(nums)));
    }
}
