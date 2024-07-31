package algorithms.dp;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        System.out.println(subArraySum(arr, 33));
    }

    private static boolean subArraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return false;
        int i = 0;
        int j = 1;
        int sum = arr[0];
        while (j < arr.length) {
            if (sum == k) {
                return true;
            } else if (sum < k) {
                sum += arr[j];
                j++;
            } else {
                sum -= arr[i];
                i++;
            }
        }
        return false;
    }
}
