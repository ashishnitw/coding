package interview;

import java.util.Arrays;

public class NextHigherTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = nextHigherTemperature(temperatures);
        System.out.println("Next higher temperature for each day: " + Arrays.toString(result));
    }

    private static int[] nextHigherTemperature(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                j++;
            }
            if (j < n) {
                result[i] = j - i;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

}
