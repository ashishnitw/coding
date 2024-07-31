package algorithms.greedy;

public class HuffmanCoding {

    static class HuffmanNode {
        char c;
        int data;
        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(char c, int data) {
            this.c = c;
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printCode(HuffmanNode root, String s) {

    }

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};
    }
}
