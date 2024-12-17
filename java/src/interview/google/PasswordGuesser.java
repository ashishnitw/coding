package interview.google;

import java.util.*;

public class PasswordGuesser {

    /** Kahn's Algorithm (BFS approach)
     * V: Number of unique nodes (characters in the password).
     * E: Number of directed edges (relationships defined by the tuples).
     * Time: O(V + E)
     * Space: O(V + E)
     * */
    public static String guessPasswordBFS(List<List<Character>> tuples) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (List<Character> tuple : tuples) {
            for (char c : tuple) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
            graph.get(tuple.get(0)).add(tuple.get(1));
            graph.get(tuple.get(1)).add(tuple.get(2));
        }
        System.out.println("Graph: " + graph);

        for (Map.Entry<Character, Set<Character>> e : graph.entrySet()) {
            for (char c : e.getValue()) {
                inDegree.put(c, inDegree.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("InDegree: " + inDegree);

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0)
                queue.add(e.getKey());
        }
        System.out.println("Queue: " + queue);

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            for (char c : graph.get(curr)) {
                inDegree.put(c, inDegree.get(c) - 1);
                if (inDegree.get(c) == 0) {
                    queue.add(c);
                }
            }
        }

        if (result.length() != graph.size())
            throw new IllegalArgumentException("Invalid tuples: cyclic dependency detected");

        System.out.println("Password: " + result);
        return result.toString();
    }

    public static String guessPasswordDFS(List<List<Character>> tuples) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Boolean> visited = new HashMap<>();


        StringBuilder result = new StringBuilder();

        return result.toString();
    }

    public static void dfs() {

    }

    public static void main(String[] args) {

        guessPasswordBFS(
                Arrays.asList(
                        Arrays.asList('b', 'c', 'a'),
                        Arrays.asList('b', 'c', 'd'),
                        Arrays.asList('c', 'a', 'd')
                )
        );  // bcad
        guessPasswordDFS(
                Arrays.asList(
                        Arrays.asList('b', 'c', 'a'),
                        Arrays.asList('b', 'c', 'd'),
                        Arrays.asList('c', 'a', 'd')
                )
        );  // bcad

        guessPasswordBFS(
                Arrays.asList(
                        Arrays.asList('b', 'd', 'e'),
                        Arrays.asList('a', 'b', 'f'),
                        Arrays.asList('f', 'g', 'c'),
                        Arrays.asList('b', 'f', 'g')
                )
        );  // abdfegc
    }
}
