package algorithms.backtracking;

import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    static Map<Integer, String> map = Map.of(
        2, "abc",
        3, "def",
        4, "ghi",
        5, "jkl",
        6, "mno",
        7, "pqrs",
        8, "tuv",
        9, "wxyz"
    );

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static List<String> letterCombinations(String number) {
        return null;
    }
}
