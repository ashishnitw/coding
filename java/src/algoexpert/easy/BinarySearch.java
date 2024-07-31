package algoexpert.easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        System.out.println(binarySearch(array, 33));
        System.out.println(binarySearch(array, 34));
    }

    // Time Complexity: O(log(n)
    // Space Complexity: O(1)
    private static int binarySearch(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == x)
                return middle;
            else if (array[middle] < x)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }

}
