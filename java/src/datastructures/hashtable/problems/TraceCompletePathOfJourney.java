package datastructures.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class TraceCompletePathOfJourney {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("NewYork","Chicago");
        map.put("Boston","Texas");
        map.put("Missouri","NewYork");
        map.put("Texas","Missouri");
        tracePath(map);
    }

    private static void tracePath(Map<String, String> map) {
        // To store reverse of given map
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> e : map.entrySet()) {
            reverseMap.put(e.getValue(), e.getKey());
        }
        // Find the starting point of itinerary
        String start = null;
        for (Map.Entry<String, String> e : map.entrySet()) {
            if (!reverseMap.containsKey(e.getKey())) {
                start = e.getKey();
                break;
            }
        }
        // If we could not find a starting point, then something wrong with input
        if (start == null) {
            System.out.println("Invalid input");
            return;
        }
        // Once we have starting point, we simple need to go next, next of next using given hash map
        String to = map.get(start);
        while (to != null) {
            System.out.println(start + " -> " + to);
            start = to;
            to = map.get(to);
        }
    }
}
