package algorithms.greedy;

/**
 *  The following implementation assumes that the activities are already sorted according to their finish time.
 * **/

public class ActivitySelection {

    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};
        int n = s.length;
        printMaxActivities(s, f, n);
    }

    public static void printMaxActivities(int[] start, int[] finish, int n) {
        System.out.print("Following activities are selected : ");
        int i = 0;
        System.out.print(i + " ");
        for(int j=1; j<n; j++) {
            if (start[j] > finish[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }
}
