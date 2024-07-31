package algorithms.recursion;

public class PermutationsOfString {

    public static void main(String[] args) {
        char[] str = {'A', 'B', 'C'};
        permute(str);
    }

    public static void permute(char[] str) {
        permute(str, str.length);
    }

    public static void permute(char[] str, int n) {
        if (n == 1) {
            System.out.println(str);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(str, i, n - 1);
            permute(str, n - 1);
            swap(str, i, n - 1);
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
