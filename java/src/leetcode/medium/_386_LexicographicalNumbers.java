package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _386_LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
        }
        list.sort(Comparator.comparing(String::valueOf));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }
}
