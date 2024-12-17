package interview;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Create a list of lists of strings
        List<List<String>> listOfLists = new ArrayList<>();

        // Add some example lists
        listOfLists.add(Arrays.asList("apple", "banana", "cherry"));
        listOfLists.add(Arrays.asList("apple", "banana", "cherry")); // duplicate
        listOfLists.add(Arrays.asList("banana", "cherry", "apple")); // duplicate but in different order
        listOfLists.add(Arrays.asList("date", "elderberry", "fig"));

        System.out.println("listOfLists: " + listOfLists);

        // Use a set to filter out duplicate lists
        Set<Set<String>> uniqueSets = new HashSet<>();

        for (List<String> list : listOfLists) {
            uniqueSets.add(new HashSet<>(list)); // Convert list to set to ignore duplicates
        }

        // Convert the unique sets back to list of lists
        List<List<String>> uniqueListOfLists = new ArrayList<>();
        for (Set<String> set : uniqueSets) {
            uniqueListOfLists.add(new ArrayList<>(set));
        }

        // Print the unique lists
        System.out.println("Unique lists: " + uniqueListOfLists);
    }
}
