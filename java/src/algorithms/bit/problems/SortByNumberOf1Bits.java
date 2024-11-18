package algorithms.bit.problems;

import java.util.Arrays;

public class SortByNumberOf1Bits {
    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        System.out.println("Original array: " + Arrays.toString(arr));
        sortByNumberOf1Bits(arr);
        System.out.println("Sorted array by number of 1 bits: " + Arrays.toString(arr));
    }

    private static void sortByNumberOf1Bits(int[] arr) {
        Integer[] newArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            if (bitCountA != bitCountB) {
                return bitCountA - bitCountB;
            }
            return a - b;
        });
        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }
}
