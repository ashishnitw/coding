package interview.angelone;

public class LastStoneWeight2 {
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length;
        int m = sum / 2;
        int[][] dp = new int[n + 1][m + 1];
        return 0;
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone: " + lastStoneWeightII(stones));
    }
}
