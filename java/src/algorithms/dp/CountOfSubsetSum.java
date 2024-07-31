package algorithms.dp;

public class CountOfSubsetSum {

    public static void main(String[] args) {
        int[] num = {1, 1, 2, 3};
        System.out.println(countSubsetsRec(num, 4));
        int[] num2 = {1, 2, 7, 1, 5};
        System.out.println(countSubsetsRec(num2, 9));

        num = new int[]{1, 1, 2, 3};
        System.out.println(countSubsetsMemo(num, 4));
        num2 = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubsetsMemo(num2, 9));

        num = new int[]{1, 1, 2, 3};
        System.out.println(countSubsetsTabulation(num, 4));
        num2 = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubsetsTabulation(num2, 9));

        num = new int[]{1, 1, 2, 3};
        System.out.println(countSubsetsOptimized(num, 4));
        num2 = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubsetsOptimized(num2, 9));
    }

    private static int countSubsetsRec(int[] arr, int sum) {
        return countSubsetsRecUtil(arr, sum, 0, arr.length);
    }

    private static int countSubsetsRecUtil(int[] arr, int sum, int i, int length) {
        if(i >= length || sum < 0)
            return 0;
        if(arr[i] == sum)
            return 1;
        return countSubsetsRecUtil(arr, sum - arr[i], i + 1, length) + countSubsetsRecUtil(arr, sum, i + 1, length);
    }

    private static int countSubsetsMemo(int[] num, int i) {
        return -1;
    }

    private static int countSubsetsTabulation(int[] num, int i) {
        return -1;
    }

    private static int countSubsetsOptimized(int[] num, int i) {
        return -1;
    }

}
