package interview.google;

import java.util.*;

public class InfraTracker2 {

    private final Map<String, PriorityQueue<Integer>> availableNumbers;
    private final Map<String, Integer> nextNumber;

    public InfraTracker2() {
        availableNumbers = new HashMap<>();
        nextNumber = new HashMap<>();
    }

    // Initialize with a list of existing servers
    public void init(List<String> existingInventory) {
        for (String server : existingInventory) {
            String[] parts = parseServerName(server);
            String type = parts[0];
            int number = Integer.parseInt(parts[1]);

            availableNumbers.putIfAbsent(type, new PriorityQueue<>());
            nextNumber.putIfAbsent(type, 1);

            if (number >= nextNumber.get(type)) {
                nextNumber.put(type, number + 1); // Update the next number for this type
            }
            availableNumbers.get(type).add(number); // Add to the available numbers
        }
    }

    // Allocate a server of the given type
    public String allocate(String type) {
        availableNumbers.putIfAbsent(type, new PriorityQueue<>());
        nextNumber.putIfAbsent(type, 1);

        PriorityQueue<Integer> gaps = availableNumbers.get(type);
        int allocatedNumber;

        // Allocate the smallest gap or the next sequential number
        if (!gaps.isEmpty() && gaps.peek() < nextNumber.get(type)) {
            allocatedNumber = gaps.poll();
        } else {
            allocatedNumber = nextNumber.get(type);
            nextNumber.put(type, allocatedNumber + 1);
        }

        return type + "-" + allocatedNumber;
    }

    // Allocate a server of the given type
    public void deallocate(String name) {
        String[] parts = parseServerName(name);
        String type = parts[0];
        int number = Integer.parseInt(parts[1]);

        if (!availableNumbers.containsKey(type) || number >= nextNumber.get(type)) {
            throw new IllegalArgumentException("Server not found or invalid: " + name);
        }

        availableNumbers.get(type).add(number); // Mark the number as available
    }

    // Parse and validate the server name
    private String[] parseServerName(String name) {
        String[] parts = name.split("-");
        if (parts.length != 2 || !parts[1].matches("\\d+")) {
            throw new IllegalArgumentException("Invalid server name: " + name);
        }
        return parts;
    }

    public static void main(String[] args) {
        InfraTracker2 tracker = new InfraTracker2();

        /** RECHECK */

        tracker.init(Arrays.asList("api-1", "api-3", "db-2"));
        System.out.println(tracker.allocate("api"));  // Expected: api-2 (fills the gap)
        System.out.println(tracker.allocate("db"));   // Expected: db-3
        System.out.println(tracker.allocate("api"));  // Expected: api-4
        tracker.deallocate("api-2");
        tracker.deallocate("api-1");
        System.out.println(tracker.allocate("api"));  // Expected: api-1 (fills the smallest gap)
        System.out.println(tracker.allocate("api"));  // Expected: api-2 (fills the next smallest gap)

    }
}
