package interview.google;

import java.util.*;

public class InfraTracker {

    private final Map<String, TreeSet<Integer>> serverMap;

    public InfraTracker() {
        serverMap = new HashMap<>();
    }

    public void init(List<String> existingInventory) {
        for (String server : existingInventory) {
            String[] parts = server.split("-");
            if (parts.length != 2 || !parts[1].matches("\\d+")) {
                throw new IllegalArgumentException("Invalid server name : " + server);
            }
            String type = parts[0];
            int number = Integer.parseInt(parts[1]);
            serverMap.putIfAbsent(type, new TreeSet<>());
            serverMap.get(type).add(number);
        }
    }

    public String allocate(String type) {
        serverMap.putIfAbsent(type, new TreeSet<>());
        TreeSet<Integer> set = serverMap.get(type);
        int newNum = 1;
        if (!set.isEmpty()) {
            for (int i = 1; i <= set.last() + 1; i++) {
                if (!set.contains(i)) {
                    newNum = i;
                    break;
                }
            }
        }
        set.add(newNum);
        return type + "-" + newNum;
    }

    public void deallocate(String name) {
        String[] parts = name.split("-");
        if (parts.length != 2 || !parts[1].matches("\\d+")) {
            throw new IllegalArgumentException("Invalid server name: " + name);
        }
        String type = parts[0];
        int number = Integer.parseInt(parts[1]);
        if (!serverMap.containsKey(type) || !serverMap.get(type).contains(number)) {
            throw new IllegalArgumentException("Server not found: " + name);
        }
        serverMap.get(type).remove(number);
    }

    public static void main(String[] args) {
        InfraTracker tracker = new InfraTracker();

        tracker.init(Arrays.asList("api-1", "db-1"));

        System.out.println(tracker.allocate("api")); // Output: api-2
        System.out.println(tracker.allocate("db"));  // Output: db-2
        System.out.println(tracker.allocate("api")); // Output: api-3

        tracker.deallocate("api-2");
        tracker.deallocate("api-1");

        System.out.println(tracker.allocate("api")); // Output: api-1
    }
}
