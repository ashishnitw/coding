package datastructures.array.rotations;

import static datastructures.array.rotations.SearchSortedRotated.findPivot;

public class PairWithGivenSumInSortedRotated {

    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        System.out.println(isPairWithGivenSum(arr, 16));
    }

    private static boolean isPairWithGivenSum(int[] arr, int sum) {
        int r = findPivot(arr, 0, arr.length - 1);
        int n = arr.length;
        int l = (r + 1) % n;
        while (l != r) {
            if (arr[l] + arr[r] < sum)
                l = (l + 1) % n;
            else if (arr[l] + arr[r] > sum)
                r = (n + r - 1) % n;
            else
                return true;
        }
        return false;
    }
}
