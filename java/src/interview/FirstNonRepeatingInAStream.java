package interview;

import java.util.*;

public class FirstNonRepeatingInAStream {
    static Queue<Character> list = new LinkedList<>();
    static Map<Character, Integer> map = new HashMap<>();   // character -> count

    public static void add(char c) {
        if (map.containsKey(c)) {
            // repeating character encountered will be removed to the list
            int count = map.get(c);
            map.put(c, count + 1);
            list.poll();
        } else {
            // non-repeating character encountered will be added to the list
            map.put(c, 1);
            list.add(c);
        }
    }
    public static void getFirstNonRepeating() {
        if (list.isEmpty()) {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + list.peek());
        }
    }

    public static void main(String[] args) {
        add('a');
        getFirstNonRepeating();
        add('b');
        getFirstNonRepeating();
        add('a');
        getFirstNonRepeating();
        add('b');
        getFirstNonRepeating();
        add('b');
        getFirstNonRepeating();
        add('c');
        getFirstNonRepeating();
    }
}
