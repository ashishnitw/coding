package datastructures.stack.problems;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 * */
public class CelebrityProblem {
    private static boolean knows(int[][] party, int i, int id) {
        return party[i][id] == 1;
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    private static int findCelebrity(int[][] party, int n) {
        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < n; j++) {
                if(i != j && (knows(party, i, j) || !knows(party, j, i))) {
                    isCelebrity = false;
                    break;
                }
            }
            if(isCelebrity)
                return i;
        }
        return -1;
    }


    // Time complexity: O(n)
    // Space complexity: O(n)
    private static int findCelebrityEliminationMethod(int[][] party, int n) {
        Stack<Integer> stack = new Stack<>();
        int c = 0;
        for (int i = 0; i < n; i++)
            stack.push(i);
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if(knows(party, a, b))
                stack.push(b);  // a knows b, so a is not celebrity
            else
                stack.push(a);  // a does not know b, so b is not celebrity
        }
        c = stack.pop();
        for (int i = 0; i < n; i++) {
            if(i != c && (knows(party, c, i) || !knows(party, i, c)))
                return -1;
        }
        return c;
    }

    private static int findCelebrityTwoPointer(int[][] party, int n) {
        int i = 0;
        int j = n-1;
        while (i < j) {
            if(knows(party, i, j))
                i++;    // i knows j, so i is not celebrity
            else
                j--;    // i does not know j, so j is not celebrity
        }
        // i is the potential celebrity
        for (int k = 0; k < n; k++) {
            if(k != i && (knows(party, i, k) || !knows(party, k, i)))
                return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        int [][] party1 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };
        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };
        int [][] party3 = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };
        System.out.println(findCelebrity(party1,4));
        System.out.println(findCelebrityEliminationMethod(party1,4));
        System.out.println(findCelebrityTwoPointer(party1,4));

        System.out.println(findCelebrity(party2,4));
        System.out.println(findCelebrityEliminationMethod(party2,4));
        System.out.println(findCelebrityTwoPointer(party2,4));

        System.out.println(findCelebrity(party3,4));
        System.out.println(findCelebrityEliminationMethod(party3,4));
        System.out.println(findCelebrityTwoPointer(party3,4));
    }
}
