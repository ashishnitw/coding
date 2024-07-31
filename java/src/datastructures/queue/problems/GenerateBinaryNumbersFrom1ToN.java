package datastructures.queue.problems;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbersFrom1ToN {

    public static void generateBinaryNumbers(int n) {
        System.out.println("Binary numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
    }

    public static void generateBinaryNumbersUsingQueue(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        System.out.println("Binary numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            String s = q.poll();
            System.out.println(s);
            q.add(s + "0");
            q.add(s + "1");
        }
    }

    public static void main(String[] args) {
        generateBinaryNumbers(5);
        generateBinaryNumbersUsingQueue(5);
    }
}
