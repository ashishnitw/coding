package datastructures.array.rotations;

import java.util.Arrays;

public class ArrayRotationByK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        leftRotateByKUsingOneStep(arr, 3);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        leftRotateByKUsingTempArray(arr2, 3);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        leftRotateByKJugglingAlgorithm(arr3, 3, arr3.length);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        leftRotateByKReversalAlgorithm(arr4, 3, arr4.length);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        leftRotateByKBlockSwapAlgorithm(arr5, 0, 3, arr5.length);
        System.out.println(Arrays.toString(arr5));
    }

    // Time complexity: O(n)
    // Space complexity: O(k)
    public static void leftRotateByKUsingTempArray(int[] arr, int k) {
        int n = arr.length;
        int[] temp = new int[k];
        for(int i=0; i<k; i++) {
            temp[i] = arr[i];
        }
        for(int i=0; i<n-k; i++) {
            arr[i] = arr[i+k];
        }
        for (int i=n-k; i<n;i++) {
            arr[i] = temp[i - (n-k)];
        }
    }

    // Time complexity: O(n*k)
    // Space complexity: O(1)
    public static void leftRotateByKUsingOneStep(int[] arr, int k) {
        for(int i=0; i<k; i++) {
            leftRotateOneStep(arr);
        }
    }

    public static void leftRotateOneStep(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n-1] = temp;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    // METHOD: 3
    public static void leftRotateByKJugglingAlgorithm(int[] arr, int k, int n) { // O(n), O(1)
        int gcd = gcd(n, k);
        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int x = j + k;
                if (x >= n)
                    x = x - n;
                if (x == i)
                    break;
                arr[j] = arr[x];
                j = x;
            }
            arr[j] = temp;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    // METHOD: 4
    public static void leftRotateByKReversalAlgorithm(int[] arr, int k, int n) {
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void reverseArray(int[] arr, int a, int b) {
        while (a < b) {
            swap(arr, a, b);
            a++;
            b--;
        }
    }

    // METHOD: 5
    public static void leftRotateByKBlockSwapAlgorithm(int[] arr, int i, int k, int n) { // O(n), O(1)
        // if (k == 0 || n % k == 0)
        //   return;
        // if (n - k == k) {
        //   swap(arr, n - k + i, k);
        //   return;
        // }
        // if (k < n - k) {
        //   swap(arr, n - k + i, k);
        //   leftRotateByKBlockSwapAlgorithm(arr, i, k, n - k);
        // } else {
        //   swap(arr, k, n - k);
        //   leftRotateByKBlockSwapAlgorithm(arr, n - k + i, 2 * k - n, k);
        // }
    }
}
