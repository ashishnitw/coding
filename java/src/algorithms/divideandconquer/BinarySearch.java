package algorithms.divideandconquer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 10));
    }

    public static int binarySearch(int[] arr, int value) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int mid = (i + j) / 2;
            if(arr[mid] > value) {
                j = mid - 1;
            } else if(arr[mid] < value) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
