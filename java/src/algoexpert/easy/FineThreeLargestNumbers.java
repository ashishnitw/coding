package algoexpert.easy;

public class FineThreeLargestNumbers {
    public static void main(String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] threeLargest = findThreeLargestNumbers(array);
        for (int num : threeLargest) {
            System.out.println(num);
        }
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] res = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            if (num > res[2]) {

            }
        }
        return res;
    }
}
