package datastructures.array.rotations;

import static datastructures.array.rotations.SearchSortedRotated.findPivot;

public class RotationCountOfSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };
        System.out.println(rotationCount(arr));
    }

    private static int rotationCount(int[] arr) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        return pivot + 1;
    }
}
