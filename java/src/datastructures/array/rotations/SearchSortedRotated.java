package datastructures.array.rotations;

public class SearchSortedRotated {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };
        System.out.println(searchInSortedRotated(arr, 8));
        System.out.println(searchInSortedRotatedSimple(arr, 8));
    }

    private static int searchInSortedRotatedSimple(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k)
                return mid;
            // Determine which side is sorted
            if (arr[l] <= arr[mid]) {   // Left side is sorted
                if (arr[l] <= k && k < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {    // Right side is sorted
                if (arr[mid] < k && k <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int searchInSortedRotated(int[] arr, int k) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        if (arr[pivot] == k)
            return pivot;
        if (pivot == -1)
            return binarySearch(arr, 0, arr.length - 1, k);
        if (arr[0] <= k)
            return binarySearch(arr, 0, pivot - 1, k);
        return binarySearch(arr, pivot + 1, arr.length - 1, k);
    }

    private static int binarySearch(int[] arr, int i, int j, int x) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    // Pivot is the element which is greater than its next element
    public static int findPivot(int[] arr, int l, int r) {
        if (l > r)
            return -1;
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (arr[l] >= arr[mid]) {
            return findPivot(arr, l, mid - 1);
        } else {
            return findPivot(arr, mid + 1, r);
        }
    }
}
